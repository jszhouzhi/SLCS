package com.slzr.operation.controller;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.PathUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.operation.domain.ArticleDO;
import com.slzr.operation.domain.OPTDepartmentDO;
import com.slzr.operation.domain.OPTDriverDO;
import com.slzr.operation.domain.OPTLineDO;
import com.slzr.operation.domain.OptBranchDO;
import com.slzr.operation.service.ArticleService;
import com.slzr.operation.service.OPTDepartmentService;
import com.slzr.operation.service.OPTLineService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import net.sf.ehcache.transaction.xa.EhcacheXAException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@RequestMapping("/operation/optline")
@Controller
public class OPTLineController extends BaseController{
	private String prefix = "operation/optline";
	@Autowired
	private OPTLineService oPTLineService;


	@Autowired
	private OPTDepartmentService oPTDepartmentService;

	@Autowired
	private UserService userService;

	@Autowired
	private MerchService merchService;
	
	@GetMapping("/list")
	@SystemControllerLog(description="0")
	public String list(Model model) {
		HashMap<String,Object> params=new HashMap<>();
		UserDO userDO = userService.get(getId());
		List<MerchDo> merchantList=null;
		if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
			merchantList=merchService.list(params);
		}else{
			params.put("merchantCode",userDO.getMerchantCode());
			merchantList=merchService.list(params);
		}
		model.addAttribute("merchantList",merchantList);
		return prefix + "/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Query query = new Query();
/*		List<OPTDepartmentDO>  departmentList = oPTDepartmentService.list(query);
		model.addAttribute("departmentList",departmentList);*/
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);

		return prefix + "/add";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") String id) {

		OPTLineDO oPTLineDO = oPTLineService.getByID(Integer.valueOf(id));
		model.addAttribute("model",oPTLineDO);
 
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);

		return prefix + "/edit";
	}
	
	@ResponseBody
	@GetMapping("api/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		UserDO userDO = userService.get(getId());
		PageUtils pageUtil=null;
		if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
			//查询列表数据
			Query query = new Query(params);
			List<OPTLineDO> list = oPTLineService.list(query);
			int total = oPTLineService.count(query);
			pageUtil = new PageUtils(list, total);
		}else{
			params.put("merchantCode",userDO.getMerchantCode());
			//查询列表数据
			Query query = new Query(params);
			List<OPTLineDO> list = oPTLineService.list(query);
			int total = oPTLineService.count(query);
			pageUtil = new PageUtils(list, total);
		}


		return pageUtil;
	}
	
	@ResponseBody
	@SystemControllerLog(description="1")
	@PostMapping("api/add")
	public R apiadd(OPTLineDO lineDO){
		lineDO.setCreatedDate(new Date());
		lineDO.setCreatedBy(getUser().getId()+"");
		
		if(getMerchantCode()!=null&&!getMerchantCode().equals("")){
			lineDO.setMerchantCode(getMerchantCode());
		}
		if(oPTLineService.save(lineDO)>0){
			return R.ok("添加成功");
		}
		return R.error("添加失败");
	}
	
	@ResponseBody
	@SystemControllerLog(description="2")
	@PostMapping("api/edit")
	public R apiedit(OPTLineDO lineDO){
		lineDO.setUpdatedDate(new Date());
		lineDO.setUpdatedBy( getUser().getId()+"");
		oPTLineService.update(lineDO);
		return R.ok();
	}
	
	/*@ResponseBody
	@PostMapping("api/uploadImg")
	public R apiuploadImg(@RequestParam("files") MultipartFile file){
        if (!file.isEmpty()) {
        	String nid=UUID.randomUUID().toString();
        	String extname = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."),file.getOriginalFilename().length());
            String nname=nid+extname;
            try {
            	BufferedOutputStream out = new BufferedOutputStream(
                		new FileOutputStream(new File(PathUtils.AbsolutePath("static\\upload\\")+"\\"+nname)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return R.error("上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return R.error("上传失败," + e.getMessage());
            }

            Map<String, Object> params=new HashMap<String, Object>();
            params.put("msg", "上传成功");
            params.put("id", nname);
            return R.ok(params);
        } else {
            return R.error("上传失败，因为文件是空的.");
        }
	}
*/

	/**
	 * 标记 删除
	 */
	@PostMapping("/deleteline")
	@ResponseBody
	//	@RequiresPermissions("operation:GuestMessage:remove")
	public R deleteart(Integer id){
		try {
//			GuestMessageDO Do = GuestMessageService.getByID(id);
			oPTLineService.remove(id);
			return R.ok();
		}catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
	
}
