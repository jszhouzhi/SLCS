package com.slzr.ureport.controller;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.operation.domain.OPTBusDO;
import com.slzr.operation.domain.OPTDepartmentDO;
import com.slzr.operation.domain.OPTDriverDO;
import com.slzr.operation.domain.OPTLineDO;
import com.slzr.operation.service.OPTBusService;
import com.slzr.operation.service.OPTDepartmentService;
import com.slzr.operation.service.OPTDriverService;
import com.slzr.operation.service.OPTLineService;
import com.slzr.ureport.domain.AccountCountDo;
import com.slzr.ureport.service.AccountCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@Controller
public class PageController {

	@Autowired
	private OPTDepartmentService optDepartmentService;

	@Autowired
	private OPTLineService optLineService;
	
	@Autowired
	private OPTDriverService optDriverService;
	
	@Autowired
	private OPTBusService optBusService;

	@Autowired
	private AccountCountService accountCountService;

	private String prefix = "report";
	
	@GetMapping("/icTopupTrans")
	@SystemControllerLog(description="0")
	public String icTopupTrans() {
		return prefix + "/icTopupTrans";
	}

	@GetMapping("/DeptLine")
	@SystemControllerLog(description="0")
	public String deptLine(Model model) {
		Map<String,Object> params=new HashMap<>();


		List<OPTDepartmentDO> Dept = optDepartmentService.list(params);

		List<OPTLineDO> lineName = optLineService.list(params);
		model.addAttribute("dept",Dept);
		model.addAttribute("line",lineName);
		return prefix + "/deptLine";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/LineBus")
	public String LineBus(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTBusDO> bus = optBusService.list(params);
		List<OPTLineDO> lineName = optLineService.list(params);
		model.addAttribute("bus",bus);
		model.addAttribute("line",lineName);
		return prefix + "/lineBus";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/BusDriver")
	public String BusDriver(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTDriverDO> driver = optDriverService.list(params);
		List<OPTBusDO> bus = optBusService.list(params);
		model.addAttribute("driver",driver);
		model.addAttribute("bus",bus);
		return prefix + "/busDriver";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/AccountCount")
	public String AccountCount(Model model) {
		List<AccountCountDo> accountCount=accountCountService.get();//获取充值方式
		Map<String,Object> params=new HashMap<>();

		List<OPTLineDO> lineName = optLineService.list(params);
		model.addAttribute("accountCount",accountCount);
		model.addAttribute("line",lineName);
		return prefix + "/accountCount";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/CountDept")
	public String ACountDept(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTDepartmentDO> Dept = optDepartmentService.list(params);
		model.addAttribute("Dept",Dept);
		return prefix + "/CountDept";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/CountLine")
	public String CountLine(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTLineDO> lineName = optLineService.list(params);
		model.addAttribute("lineName",lineName);
		return prefix + "/CountLine";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/CountDriver")
	public String CountDriver(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTDriverDO> driverName = optDriverService.list(params);
		model.addAttribute("driverName",driverName);
		return prefix + "/CountDriver";
	}

	@SystemControllerLog(description="0")
	@GetMapping("/CountCar")
	public String CountCar(Model model) {
		Map<String,Object> params=new HashMap<>();
		List<OPTBusDO> bus = optBusService.list(params);
		model.addAttribute("bus",bus);
		return prefix + "/CountCar";
	}
	

}
