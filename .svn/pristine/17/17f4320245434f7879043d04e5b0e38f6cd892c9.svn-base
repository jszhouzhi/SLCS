package com.slzr.ureport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bstek.ureport.Utils;
import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;

@RequestMapping("/report/template")
@Controller
public class TemplateController {
	private String prefix = "report/template";
	
	
	@GetMapping("/Print")
	public String CountCar(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {

		Map<String,Object> parameters=getParameterMap(request);

        String reportCondition = request.getQueryString();
        try {  
        	reportCondition = URLDecoder.decode(reportCondition,"UTF-8");
        } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
        }
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out= response.getWriter();  
		
		ExportManager  exportManager=(ExportManager)Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);

		
		HtmlReport htmlReport = exportManager.exportHtml(request.getParameter("xmlName"),request.getContextPath(),parameters);
 
		model.addAttribute("reportCondition",reportCondition.replaceAll("xmlName=", "_u="));
		System.out.println(reportCondition.replaceAll("xmlName=", "_u=file:"));
		model.addAttribute("reportContent",htmlReport.getContent());	
		model.addAttribute("reportStyle",htmlReport.getStyle());		
		return prefix + "/reportTemplate";
	}
		
	public static Map getParameterMap(HttpServletRequest request) {
	    // 参数Map
	    Map properties = request.getParameterMap();
	    // 返回值Map
	    Map returnMap = new HashMap();
	    Iterator entries = properties.entrySet().iterator();
	    Map.Entry entry;
	    String name = "";
	    String value = "";
	    while (entries.hasNext()) {
	        entry = (Map.Entry) entries.next();
	        name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	        }
	        returnMap.put(name, value);
	    }
	    return returnMap;
	}
}
