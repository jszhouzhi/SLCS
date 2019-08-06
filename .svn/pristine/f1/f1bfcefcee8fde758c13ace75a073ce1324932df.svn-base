package com.slzr.account.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.slzr.account.domain.AccountDO;
import com.slzr.account.service.AccountService;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;

/**
 * 账户管理
 * 
 * @author zhy
 * @date 2018-05-31 14:23:00
 */

@Controller
@RequestMapping("/qraccount/qraccount")
public class QRAccountController extends BaseController {

	@Autowired
	private AccountService accountService;

	/**
	 * 初始化
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping()
	@SystemControllerLog(description = "0")
	@RequiresPermissions("account:account:account")
	String QRAccount(Model model) {

		// 页面url前缀
		baseDO.setPrefixUrl("/qraccount/qraccount");
		// 页面标题
		baseDO.setPageTitle("二维码账号");
		// 如果页面有弹窗，设置页面弹窗的宽高度
		baseDO.setPopupArea(Arrays.asList("800px", "620px"));

		// 需要检测的按钮权限（可以是多个）
		baseDO.setPermissionList(Arrays.asList("account:account:loss"));

		// 初始化设置
		initBaseDO();

		// 返回给视图的数据对象
		model.addAttribute("baseDO", baseDO);

		return "account/account/qraccount";
	}

	/**
	 * 查询
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("account:account:account")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		if (!params.containsKey("merchantCode"))
			params.put("merchantCode", getMerchantCode());
		Query query = new Query(params);
		List<AccountDO> sysUserList = accountService.list(query);
		int total = accountService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);

		return pageUtil;
	}

	/**
	 * 更新账号状态
	 * 
	 * @param id
	 * @param operationType
	 * @return
	 */
	@PostMapping("/operation")
	@SystemControllerLog(description = "6")
	@ResponseBody
	R operation(Integer id, Integer operationType) {

		try {
			if (accountService.updateAccountState(id, operationType) > 0) {
				return R.ok();
			} else {
				return R.error();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("更新账号状态失败！");
		}

	}

	/**
	 * 导出
	 * 
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping("/export")
	@SystemControllerLog(description = "4")
	@RequiresPermissions("account:account:expexcel")
	public void expExceluser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("searchName", request.getParameter("searchName"));
		parameterMap.put("state", request.getParameter("state"));

		// 1.获取数据源
		List<AccountDO> list = accountService.list(parameterMap);

		// 2.要导出的字段和对应的标题
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("账号", "accountno");
		map.put("类型", "accountTypeName");
		map.put("账户状态", "stateName");
		map.put("手机号码", "mobilephone");
		map.put("注册时间", "createddate");
		map.put("账户余额", "balance");

		map.put("赠送余额", "freebalance");
		map.put("最后消费时间", "lastdebittime");
		map.put("最后消费金额", "lastdebitamount");

		// 3.标题
		String reportTitle = "二维码账号列表";
		export(response, reportTitle, map, list);

	}

}
