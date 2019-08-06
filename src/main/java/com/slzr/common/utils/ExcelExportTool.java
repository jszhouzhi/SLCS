package com.slzr.common.utils;

import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * elecl 导出工具实现
 * 
 * @author lc @date：2018/3/9 10:10
 *
 */
public class ExcelExportTool {

	private ExcelExportTool() {
	}

	public static void exportExcel(String fileName, String sheetName, String[] title, List<Object[]> data,
			HttpServletResponse response) {
		try {
			OutputStream os = response.getOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet wsheet = null;
			WritableFont wfont = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat titleFormat = new WritableCellFormat(wfont);
			titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			titleFormat.setAlignment(Alignment.CENTRE);
			NumberFormat nf = new NumberFormat("#.##");
			WritableCellFormat wcfN = new WritableCellFormat(nf);
			int row = 0;
			int index = 1;
			for (Object[] temp : data) {
				if (row == 0 || row == 60000) {
					wsheet = wwb.createSheet(sheetName + index, index);
					index++;
					row = 0;
					for (int j = 0; j < title.length; j++) {
						wsheet.setColumnView(j, 15);
						Label excelTitle = new Label(j, 0, title[j], titleFormat);
						wsheet.addCell(excelTitle);
					}
				}
				row++;
				for (int i = 0; i < temp.length; i++) {
					if (temp[i] != null) {
						String className = temp[i].getClass().getName();
						if (className.indexOf("Double") >= 0) {
							Double value = (Double) temp[i];
							wsheet.addCell(new Number(i, row, value));
						} else if (className.indexOf("Integer") >= 0) {
							Integer value = (Integer) temp[i];
							wsheet.addCell(new Number(i, row, value));
						} else if (className.indexOf("Long") >= 0) {
							Long value = (Long) temp[i];
							wsheet.addCell(new Number(i, row, value));
						} else if (className.indexOf("Short") >= 0) {
							Short value = (Short) temp[i];
							wsheet.addCell(new Number(i, row, value));
						} else if (className.indexOf("Float") >= 0) {
							Float value = (Float) temp[i];
							wsheet.addCell(new Number(i, row, value));
						} else {
							String str = temp[i].toString();
							wsheet.addCell(new Label(i, row, str, titleFormat));
						}
					}
				}
			}
			wwb.write();
			wwb.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出到excel
	 * 
	 * @param reportTitle
	 *            报表标题
	 * @param fields
	 *            要导出的字段
	 * @param list
	 *            数据源
	 * @param response
	 *            输出流
	 */
	public static void export(String reportTitle, LinkedHashMap<String, String> fields, List<?> list,
			HttpServletResponse response) {
		try {
			OutputStream os = response.getOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet wsheet = null;

			WritableFont titlewfont = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat titleFormat = new WritableCellFormat(titlewfont);
			titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			titleFormat.setAlignment(Alignment.CENTRE);

			/*
			 * WritableFont stringwfont = new WritableFont(WritableFont.ARIAL, 8,
			 * WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			 * WritableCellFormat stringFormat = new WritableCellFormat(stringwfont);
			 * stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			 * stringFormat.setAlignment(Alignment.CENTRE);
			 */

			WritableFont leftwfont = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat leftFormat = new WritableCellFormat(leftwfont);
			leftFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			leftFormat.setAlignment(Alignment.CENTRE);

			WritableFont rightwfont = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat rightFormat = new WritableCellFormat(rightwfont);
			rightFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			rightFormat.setAlignment(Alignment.CENTRE);

			int row = 0;
			int index = 1;

			int fieldIndex = 0;

			// 得到当前数据集的对象的所有属性
			java.lang.reflect.Field[] objFields = list.get(0).getClass().getDeclaredFields();
			java.lang.reflect.Field.setAccessible(objFields, true);

			for (Object item : list) {
				if (row == 0 || row == 60000) {
					// 创建sheet，并生成表头
					wsheet = wwb.createSheet(reportTitle + index, index);
					wsheet.addCell(new Label(0, 0, reportTitle, titleFormat));
					wsheet.mergeCells(0, 0, fields.size()-1, 0);// 合并表头
					index++;

					Iterator<Entry<String, String>> iter = fields.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
						wsheet.setColumnView(fieldIndex, 15);
						Label excelTitle = new Label(fieldIndex, 1, entry.getKey(), titleFormat);
						wsheet.addCell(excelTitle);
						fieldIndex++;
					}
					row = 1;

				}

				row++;

				// 写值
				Iterator<Entry<String, String>> iter = fields.entrySet().iterator();
				fieldIndex = 0;
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

					for (int i = 0; i < objFields.length; i++) {
						// 该字段要导出
						if (entry.getValue().equals(objFields[i].getName())) {

							String fieldType = objFields[i].getType().toString();

							String val = getValue(fieldType, objFields[i].get(item));

							if (fieldType.endsWith("Double")) {
								wsheet.addCell(new Label(fieldIndex, row, val, rightFormat));
							} else if (fieldType.endsWith("String")) {
								wsheet.addCell(new Label(fieldIndex, row, val, leftFormat));
							} else if (fieldType.endsWith("Date")) {
								wsheet.addCell(new Label(fieldIndex, row, val, leftFormat));
							} else {
								wsheet.addCell(new Label(fieldIndex, row, val, titleFormat));
							}

							// wsheet.addCell(new Label(fieldIndex, row, objValue.toString(), titleFormat));
							fieldIndex++;
						}

					}

				}

			}
			wwb.write();
			wwb.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String getValue(String fieldType, Object value) {
		if (value == null)
			return "";
		if (fieldType.endsWith("Date"))
			return DateUtils.format((Date) value, DateUtils.DATE_TIME_PATTERN);

		return value.toString();
	}

}
