package com.slzr.common.controller;

import org.springframework.stereotype.Controller;

import com.slzr.common.utils.ShiroUtils;
import com.slzr.system.domain.UserDO;

@Controller
public class BaseController {


	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getId() {
		return getUser().getId();
	}

	public String getUserName() {
		return getUser().getUserName();
	}
}