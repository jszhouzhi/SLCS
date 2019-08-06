package com.slzr.ureport.controller;

import java.text.ParseException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slzr.common.utils.DWMQDateUtil;
import com.slzr.common.utils.DWMQDateVO;
import com.slzr.common.utils.DateUtils;

@RequestMapping("/report/utils")
@Controller
public class UtilsController {
	
	@GetMapping("/dwmq")
	@ResponseBody
	public DWMQDateVO dwmq() {
		DWMQDateVO vo = null;
		try {
			vo = DWMQDateUtil.GetDWMQDateVO(DateUtils.format(Calendar.getInstance().getTime(), DateUtils.DATE_PATTERN));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
