package com.slzr.set.controller;


import com.slzr.common.annotation.Log;
import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.config.Constant;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.set.domain.CompanyDo;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.CompanyService;
import com.slzr.set.service.MerchService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/Merchant/merchantSet")
@Controller
public class MerchController extends BaseController {
    private String prefix = "set/merchant";

    @Autowired
    private CompanyService companyService;

    @Autowired
    MerchService merchService;

    @RequiresPermissions("set:merchantSet:merchantSet")
    @SystemControllerLog(description = "0")
    @GetMapping("")
    String merch(Model model) {
        return prefix + "/merchant";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<MerchDo> sysUserList = merchService.list(query);

        for (int i = 0; i < sysUserList.size(); i++) {
            //sysUserList.get(i).setId(2);
            Integer settlePeriod = sysUserList.get(i).getSettlePeriod();
            String settlePeriodUnit = sysUserList.get(i).getSettlePeriodUnit();
            if (settlePeriodUnit.equals("D")) {
                settlePeriodUnit = "天";
            } else if (settlePeriodUnit.equals("W")) {
                settlePeriodUnit = "周";
            } else if (settlePeriodUnit.equals("M")) {
                settlePeriodUnit = "月";
            } else if (settlePeriodUnit.equals("Q")) {
                settlePeriodUnit = "季";

            }
            String newSettlePeriod = settlePeriod + settlePeriodUnit;
            sysUserList.get(i).setSettlePeriodUnit(newSettlePeriod);
        }

        int total = merchService.count(query);
        PageUtils pageUtil = new PageUtils(sysUserList, total);
        return pageUtil;
    }

    /**
     * 添加用户
     *
     * @param
     * @return
     */
    @RequiresPermissions("set:merchantSet:add")
    @Log("添加用户")
    @GetMapping("/add")
    String add(Model model) {
        Map<String,Object> param=new HashMap<>();
        List<CompanyDo> companys = companyService.list(param);
        List<Integer> options = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            options.add(i);
        }
        model.addAttribute("options", options);
        model.addAttribute("company",companys);
        return prefix + "/add";
    }

    @RequiresPermissions("set:merchantSet:add")
    @Log("保存商户")
    @SystemControllerLog(description = "1")
    @PostMapping("/save")
    @ResponseBody
    public R save(MerchDo merchant) {
        merchant.setCreatedBy(getId());
        merchant.setCreatedDate(new Date());
        merchant.setEnableStatus("1");
        if (merchService.save(merchant) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 编辑商户
     *
     * @param
     * @return
     */
    @RequiresPermissions("set:merchantSet:edit")
    @Log("编辑商户")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Integer id) {
        MerchDo merchDo = merchService.get(id);
        model.addAttribute("merchant", merchDo);

        List<Integer> options = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            options.add(i);
        }
        model.addAttribute("options", options);
        return prefix + "/edit";
    }

    /**
     * 更新商户
     *
     * @param
     * @return
     */
    @RequiresPermissions("set:merchantSet:edit")
    @Log("更新商户")
    @SystemControllerLog(description = "2")
    @PostMapping("/update")
    @ResponseBody
    public R update(MerchDo merchant) {
        merchant.setUpdatedBy(getId());
        merchant.setUpdatedDateTime(new Date());
        if (merchService.update(merchant) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !merchService.exit(params);
    }

    @PostMapping("/check")
    @ResponseBody
    boolean check(@RequestParam Map<String, Object> params) {
        String cityCode = params.get("cityCode").toString().trim();

        // String str = "java怎么把asdasd字符串中的asdasd的汉字取出来";
        String reg = "[^\u4e00-\u9fa5]";
        String number = cityCode.replaceAll(reg, "").trim();//提取汉字
        String Letter = cityCode.replaceAll("[^a-z^A-Z^0-9]", "");//提取字母
        System.out.println(cityCode.length() * 2);
        int length = number.length() * 2 + Letter.length();
        return !(length > 6);
    }

    /**
     * 对商户表导出excel操作
     */

    @RequiresPermissions("set:merchantSet:import")
    @Log("导出用户")
    @SystemControllerLog(description = "4")
    @GetMapping("/import")
    public void expExceluser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("keyWord", request.getParameter("keyWord"));
        parameterMap.put("settleMethod", request.getParameter("settleMethod"));

        String fileName = "商户设置.xls";

        String[] title = new String[]{"商户代码", "商户简介", "城市代码", "结算费率", "结算方式", "结算周期", "服务费", "最后结算时间", "联系人", "联系电话"};

        List<MerchDo> list = null;

        try {
            list = merchService.list(parameterMap);
            for (int i = 0; i < list.size(); i++) {
                String settleMethod = list.get(i).getSettleMethod();
                if (settleMethod.equals("1")) {
                    list.get(i).setSettleMethod("充值金额");
                } else if (settleMethod.equals("2")) {
                    list.get(i).setSettleMethod("消费金额");
                }
            }

            List<Object[]> data = new ArrayList<Object[]>();
            for (int i = 0; i < list.size(); i++) {
                Object[] str = new Object[10];
                if (null != list.get(i).getMerchantCode() && !list.get(i).getMerchantCode().equals("")) {
                    str[0] = list.get(i).getMerchantCode().toString();
                } else {
                    str[0] = "";
                }
                if (null != list.get(i).getShortName() + "") {
                    str[1] = list.get(i).getShortName() + "";
                } else {
                    str[1] = "";
                }
                if (null != list.get(i).getCityCode() + "") {
                    str[2] = list.get(i).getCityCode() + "";
                } else {
                    str[2] = "";
                }
                if (null != list.get(i).getSettleRate() && !list.get(i).getSettleRate().equals("")) {
                    str[3] = list.get(i).getSettleRate().toString();
                } else {
                    str[3] = "";
                }
                if (null != list.get(i).getSettleMethod() && !list.get(i).getSettleMethod().equals("")) {
                    str[4] = list.get(i).getSettleMethod().toString();
                } else {
                    str[4] = "";
                }
                if (null != list.get(i).getSettlePeriod() && list.get(i).getSettlePeriod() != 0 && list.get(i).getSettlePeriod() != null && !list.get(i).getSettlePeriod().equals("")) {
                    if (list.get(i).getSettlePeriodUnit().equals("D")) {
                        list.get(i).setSettlePeriodUnit("天");
                    } else if (list.get(i).getSettlePeriodUnit().equals("W")) {
                        list.get(i).setSettlePeriodUnit("周");
                    } else if (list.get(i).getSettlePeriodUnit().equals("M")) {
                        list.get(i).setSettlePeriodUnit("月");
                    } else {
                        list.get(i).setSettlePeriodUnit("季");
                    }
                    str[5] = list.get(i).getSettlePeriod() + list.get(i).getSettlePeriodUnit();
                } else {
                    str[5] = "";
                }
                if (null != list.get(i).getServiceFee() + "") {
                    str[6] = list.get(i).getServiceFee() + "";
                } else {
                    str[6] = "";
                }
                if (null != list.get(i).getLastSettleDateTime() && !list.get(i).getLastSettleDateTime().equals("")) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    str[7] = df.format(list.get(i).getLastSettleDateTime()).toString();
                } else {
                    str[7] = "";
                }
                if (null != list.get(i).getContactPerson() && !list.get(i).getContactPerson().equals("")) {
                    str[8] = list.get(i).getContactPerson().toString();
                } else {
                    str[8] = "";
                }
                if (null != list.get(i).getContactPhone() && !list.get(i).getContactPhone().equals("")) {
                    str[9] = list.get(i).getContactPhone().toString();
                } else {
                    str[9] = "";
                }

                data.add(str);
            }
            String sheetName = "expExcel";
            byte[] b = fileName.getBytes("UTF-8");
            String formatFileName = new String(b, "ISO-8859-1");
            response.setContentType("application/ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + formatFileName);
            ExcelExportTool.exportExcel(formatFileName, sheetName, title, data, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            list = null;
        }
    }


    @RequiresPermissions("set:merchantSet:remove")
    @Log("删除商户")
    @SystemControllerLog(description = "3")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUserName())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (merchService.remove(id) > 0) {
            return R.ok();
        }
        // merchService.remove(id);
        return R.error();
    }
}
