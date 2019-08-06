package com.slzr.common.utils;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
 * @author lc  
 * @date：2018/3/9 10:10
 *
 */
public class ExcelExportTool {

	
	
	private ExcelExportTool() {}

	public static void exportExcel(String fileName,String sheetName,String[] title,List <Object[]> data,HttpServletResponse response){
		try {
			 OutputStream os = response.getOutputStream();
			 WritableWorkbook wwb = Workbook.createWorkbook(os);
			 WritableSheet wsheet = null;
	         WritableFont wfont = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	         WritableCellFormat titleFormat = new WritableCellFormat(wfont);
	         titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
	         titleFormat.setAlignment(Alignment.CENTRE);
	    	 NumberFormat nf = new NumberFormat("#.##");
			 WritableCellFormat wcfN = new WritableCellFormat(nf);
	         int row = 0;
	         int index=1;
	         for (Object[] temp : data) {
	        	 if(row==0||row==60000){
     				  wsheet=wwb.createSheet(sheetName+index, index);
     				  index++;
     				  row=0;
     				  for (int j = 0; j < title.length; j++) {
     		             wsheet.setColumnView(j, 15);
     		             Label excelTitle = new Label(j, 0, title[j], titleFormat);
     		             wsheet.addCell(excelTitle);
     		           }
     			   }
	        	row++;
	      	   for(int i = 0; i < temp.length; i++ ){
	      		   if(temp[i]!=null){
	      			   String className = temp[i].getClass().getName();
		        		   if(className.indexOf("Double")>=0){
		        			   Double value = (Double) temp[i];
		        			   wsheet.addCell(new Number(i,row,value));
		        		   }else if(className.indexOf("Integer")>=0){
		        			   Integer value = (Integer) temp[i];
		        			   wsheet.addCell(new Number(i,row,value));
		        		   }else if(className.indexOf("Long")>=0){
		        			   Long value = (Long) temp[i];
		        			   wsheet.addCell(new Number(i,row,value));
		        		   }else if(className.indexOf("Short")>=0){
		        			   Short value = (Short) temp[i];
		        			   wsheet.addCell(new Number(i,row,value));
		        		   }else if(className.indexOf("Float")>=0){
		        			   Float value = (Float) temp[i];
		        			   wsheet.addCell(new Number(i,row,value));
		        		   }else{
		        			   String str = temp[i].toString();
		        			   wsheet.addCell(new Label(i,row,str,titleFormat));
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
	
	
	

}
