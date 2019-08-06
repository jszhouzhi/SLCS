package com.slzr.set.controller;


import com.slzr.common.annotation.Log;
import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.set.domain.CompanyDo;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.domain.Share;
import com.slzr.set.service.CompanyService;
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

@RequestMapping("/company/companySet")
@Controller
public class CompanyController {

    private String prefix="set/company"  ;

    @Autowired
    private CompanyService companyService;

    @RequiresPermissions("set:companySet:companySet")
    @SystemControllerLog(description="0")
    @GetMapping("")
    String merch(Model model) {
        return prefix + "/company";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<CompanyDo> sysUserList = companyService.list(query);

        int total = companyService.count(query);
        PageUtils pageUtil = new PageUtils(sysUserList, total);
        return pageUtil;
    }


    @RequiresPermissions("set:companySet:add")
    @Log("添加机构")
    @GetMapping("/add")
    String add(Model model) {
       Share share=new Share();
       share.setShareWxPay(1);
        model.addAttribute("share", share);
        return prefix + "/add";
    }

    //判断机构代码是否存在
    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !companyService.exit(params);
    }

    @RequiresPermissions("set:companySet:add")
    @Log("保存机构")
    @SystemControllerLog(description="1")
    @PostMapping("/save")
    @ResponseBody
    public R save(CompanyDo companyDo){
        companyDo.setParentID(1);
        companyDo.setTradeCode("8888");
        if(companyService.save(companyDo)>0){
            return R.ok();
        }
        return R.error();
    }



    /**
     * 编辑机构
     * @param
     * @return
     */
    @RequiresPermissions("set:companySet:edit")
    @Log("编辑机构")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Integer id) {
        CompanyDo company = companyService.get(id);
        model.addAttribute("company", company);

        return prefix+"/edit";
    }

    /**
     * 更新机构
     * @param
     * @return
     */
    @RequiresPermissions("set:companySet:edit")
    @Log("更新机构")
    @PostMapping("/update")
    @SystemControllerLog(description="2")
    @ResponseBody
    public R update( CompanyDo company){
        if(companyService.update(company)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 对商户表导出excel操作
     */

    @RequiresPermissions("set:merchantSet:import")
    @Log("导出机构")
    @SystemControllerLog(description="4")
    @GetMapping("/import")
    public void expExceluser(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("keyWord", request.getParameter("keyWord"));
        String fileName = "机构设置.xls";

        String[] title = new String[]{"机构代码","城市代码","机构名称","机构简称","机构拼音","城市名称","城市拼音"};

        List<CompanyDo> list = null;
        try {
            list = companyService.list(parameterMap);

            List<Object[]> data = new ArrayList<Object[]>();
            for(int i=0; i<list.size();i++){
                Object[] str = new Object[7];
                if(null!=list.get(i).getCode() && !list.get(i).getCode().equals("")){
                    str[0]=list.get(i).getCode().toString();
                }else{
                    str[0]="";
                }
                if(null!=list.get(i).getCityCode()+""){
                    str[1]=list.get(i).getCityCode()+"";
                }else{
                    str[1]="";
                }
                if(null!=list.get(i).getName()+""){
                    str[2]=list.get(i).getName()+"";
                }else{
                    str[2]="";
                }
                if(null!=list.get(i).getShortName() && !list.get(i).getShortName().equals("")){
                    str[3]=list.get(i).getShortName().toString();
                }else{
                    str[3]="";
                }
                if(null!=list.get(i).getPinYin() && !list.get(i).getPinYin().equals("")){
                    str[4]=list.get(i).getPinYin().toString();
                }else{
                    str[4]="";
                }
                if(null!=list.get(i).getCityName()+""){
                    str[5]=list.get(i).getCityName()+"";
                }else{
                    str[5]="";
                }
                if(null!=list.get(i).getCityPinYin() && !list.get(i).getCityPinYin().equals("")){
                    str[6]=list.get(i).getCityPinYin().toString();
                }else{
                    str[6]="";
                }

                data.add(str);
            }
            String sheetName = "expExcel";
            byte[] b = fileName.getBytes("UTF-8");
            String formatFileName = new String(b,"ISO-8859-1");
            response.setContentType("application/ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+formatFileName);
            ExcelExportTool.exportExcel(formatFileName, sheetName, title, data, response);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            list=null;
        }
    }

}
