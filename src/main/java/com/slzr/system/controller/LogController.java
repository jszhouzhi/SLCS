package com.slzr.system.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.slzr.common.domain.LogContentDo;
import com.slzr.common.domain.LogDO;
import com.slzr.common.service.LogService;
import com.slzr.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/system/log")
@Controller
public class LogController {
	private String prefix = "system/log";

	@Autowired
	LogService logService;



	@GetMapping("/list")
	public String list(Model model) {
		DWMQDateVO dwmq = null;
		try {
			dwmq = DWMQDateUtil.GetDWMQDateVO(DateUtils.format(Calendar.getInstance().getTime(), DateUtils.DATE_PATTERN));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("dwmq", dwmq);
		return prefix + "/log";
	}

	@ResponseBody
	@GetMapping("/api/list")
	PageUtils list(@RequestParam Map<String, Object> params) throws Exception{
		// 查询列表数据
		Query query = new Query(params);
		List<LogDO> sysUserList = logService.list(query);
		for(int i=0;i<sysUserList.size();i++){
			//将日志内容转成对象
			JSONObject jsonObject = JSONObject.parseObject(sysUserList.get(i).getLogContent());
			LogContentDo logContent = JSONObject.toJavaObject(jsonObject, LogContentDo.class);
			if(!sysUserList.get(i).getLogContent().equals("{}")||!sysUserList.get(i).getLogContent().equals("")){
				String param = logContent.getParams();
				sysUserList.get(i).setLogContent(param);
			}
			//格式化时间
			sysUserList.get(i).setLogDateTime(sysUserList.get(i).getLogDateTime().substring(0,sysUserList.get(i).getLogDateTime().length()-2));
		}
		int total = logService.count(query);

		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}



}
