package com.thinkgem.jeesite.modules.work.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.service.ProductTypeService;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dto.SignVo;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;
import com.thinkgem.jeesite.modules.work.form.WorkShoppingForm;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.modules.work.service.WorkShoppingDetailsService;
import com.thinkgem.jeesite.modules.work.service.WorkShoppingService;
import com.thinkgem.jeesite.modules.work.utils.ExcelUtil;
import com.thinkgem.jeesite.modules.work.utils.WorkUtils;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/shopping")
public class WorkShoppingController extends BaseController {

	@Resource(name = "workShoppingServiceImpl")
	private WorkShoppingService workShoppingService;
	
	@Resource(name = "productTypeServiceImpl")
	private ProductTypeService productTypeService;
	
	@Resource(name = "workShoppingDetailsServiceImpl")
	private WorkShoppingDetailsService workShoppingDetailsService;

	@Autowired
	private OfficeService officeService;
	@Autowired
	private SystemService systemService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;

	@RequiresPermissions("work:shopping:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkShopping> page=workShoppingForm.getPage();// 获取分页对象
		WorkShoppingCondition condition=workShoppingForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workShoppingService.listWorkShoppingByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workShoppingList";
	}
	@RequiresPermissions("work:shopping:list")
	@RequestMapping(value = "/list")
	public String index1(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkShopping> page=workShoppingForm.getPage();// 获取分页对象
		WorkShoppingCondition condition=workShoppingForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workShoppingService.listWorkShoppingByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workShoppingList";
	}
	@RequiresPermissions("work:shopping:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkShopping> page=workShoppingForm.getPage();// 获取分页对象
		WorkShoppingCondition condition=workShoppingForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workShoppingService.listWorkShoppingByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workShoppingList";
	}
	
	@RequiresPermissions("work:shopping:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkShopping> page=workShoppingForm.getPage();// 获取分页对象
		WorkShoppingCondition condition=workShoppingForm.getCondition();
		workShoppingService.listWorkShoppingByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workShoppingList";
	}
	
	/**已完成单据*/
	@RequiresPermissions("work:shopping:list6")
	@RequestMapping(value = "/list6")
	public String index6(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkShopping> page=workShoppingForm.getPage();// 获取分页对象
		WorkShoppingCondition condition=workShoppingForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workShoppingService.listWorkShoppingByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workShoppingList";
	}
	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(workShoppingForm.getItem().getId())){
			WorkShopping item = workShoppingService.getWorkShoppingById(workShoppingForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			// 审批情况显示对象
			List<SignVo> listSign=listSignVo(item);
			if (office!=null) {
				item.setDepartmentName(office.getName());
				List<Role> listRole=systemService.listRole();
				model.addAttribute("listRole",listRole);//职务列表
				for (Role role : listRole) {
					if (role.getId().equals(item.getPost())) {
						model.addAttribute("postName",role.getName());
					}
				}
			}
			// 采购详情列表
			List<WorkShoppingDetails> list=workShoppingDetailsService.listShoppingDetails(item.getId());
			model.addAttribute("list", list);
			model.addAttribute("addFlag",0);// 表示查看
			if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);
			if(workShoppingForm.getState()!=null&&workShoppingForm.getState()==6)model.addAttribute("state", 0);
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workShoppingForm.setItem(item);
			model.addAttribute("workShoppingForm",workShoppingForm);
			if (item.getState()!=100) {
			WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),5);// 创建人流程信息
			Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
			model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkShopping item=new WorkShopping();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("postName",user.getRoleList().get(0).getName());
			item.setPost(user.getRoleList().get(0).getId());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加
			model.addAttribute("workShoppingForm",workShoppingForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workShoppingForm";
	}
	// 保存
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute WorkShoppingForm workShoppingForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes) {
		Integer state=0;
		String url="";
		try {
			WorkShopping item = workShoppingForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),5);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				item.setSerialNumber(DateUtils.getDate("yyyyMMddHHmmss")+(Integer.valueOf((int) (Math.random()*900+100))));// 采购单唯一流水号(年月日+随机数)
				// 添加采购详情
				String []mode=workShoppingForm.getProducts().split(",");
				if(mode[0].equals("")){
					return "error/numError2";
				}
				workShoppingService.addPrevent(mode,item);
				url="redirect:" + adminPath + "/work/shopping/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),5);// 创建人流程信息
				state=Integer.valueOf(workShoppingForm.getItem().getState());// 订单当前步奏
				String id="";
				if(state<workProcess.getListProcessDetails().size()){
					id=workProcess.getListProcessDetails().get(state).getRoleid(); // 从集合中取出下一步的审批角色id
				}
				Integer step=workProcess.getListProcessDetails().get(state-1).getStep();// 这一步是第几步
				Integer stater=workProcess.getListProcessDetails().get(state-1).getState();
				switch (stater) {
				case 1:
					item.setDate1(new Date());// 签字时间
					item.setPeople1(user.getId());// 签字人
					item.setSign1(user.getUserSign());
					if (item.getOpinion1()==1) {// 1-同意，2-不同意
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(item.getPrice()<=2000){
							item.setFlag(1);
							item.setState(100);// 下一步
							item.setExamination("");
						}
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setFlag(2);
					}
					break;
				case 2:
					item.setDate2(new Date());
					item.setPeople2(user.getId());
					item.setSign2(user.getUserSign());
					if (item.getOpinion2()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(item.getPrice()<=10000){
							item.setFlag(1);
							item.setState(100);// 下一步
							item.setExamination("");
							}
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setFlag(2);
					}			
					break;
				case 3:
					item.setDate3(new Date());
					item.setPeople3(user.getId());
					item.setSign3(user.getUserSign());
					if (item.getOpinion3()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(item.getPrice()<=50000){
						item.setFlag(1);
						item.setState(100);// 下一步
						item.setExamination("");}
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setFlag(2);
					}
					break;
				case 4:
					item.setDate4(new Date());
					item.setPeople4(user.getId());
					item.setSign4(user.getUserSign());
					if (item.getOpinion4()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						workShoppingService.changePayment(item.getId(), 1);// 已付款
					}else{
						item.setFlag(2);
					}
					break;
					
				}
				workShoppingService.update(item);
				url="redirect:" + adminPath + "/work/shopping/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return url;	
	}
	
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkShoppingForm workShoppingForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workShoppingService.delByIds(workShoppingForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workShoppingForm,request,response,model);
	}
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkShoppingForm workShoppingForm,HttpServletRequest request,HttpServletResponse response,Model model){
			workShoppingService.termination(workShoppingForm.getItem().getId());
			return index0(workShoppingForm,request,response,model);
	}
	/**查询所有已审批，但未入库的采购订单*/
	@ResponseBody
	@RequestMapping(value = "/listShopping")
	public List<WorkShopping> listShopping() {
		return workShoppingService.listShopping();
	}
	/**采购单导出*/
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/exportShopping")
	public void exportShopping(@ModelAttribute WorkShoppingForm workShoppingForm,HttpServletRequest request,HttpServletResponse response){
		WorkShopping item = workShoppingService.getWorkShoppingById(workShoppingForm.getItem().getId());
		List<WorkShoppingDetails> list=workShoppingDetailsService.listShoppingDetails(item.getId());
        // 创建一个工作薄   
        HSSFWorkbook wb = new HSSFWorkbook();   
        HSSFSheet sheet1 = wb.createSheet("sheet1"); 
        // 列宽
        sheet1.setColumnWidth(0, 12 * 256);
        sheet1.setColumnWidth(1, 13 * 256);
        sheet1.setColumnWidth(5, 18 * 256);
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();  // 将图片写入Excel的东西 
        // 表格样式
        HSSFCellStyle cellStyles1=ExcelUtil.createHSSFCellStyle1(wb); 
        HSSFCellStyle cellStyles2= ExcelUtil.createHSSFCellStyle2(wb);
        HSSFCellStyle cellStyles3= ExcelUtil.createHSSFCellStyle3(wb);
        HSSFCellStyle cellStyles4= ExcelUtil.createHSSFCellStyle4(wb);
        // 标题
 		sheet1.addMergedRegion(new Region(0,(short)0,1,(short)6));// 合并单元格
 	    HSSFRow row = sheet1.createRow(0);
 	    ExcelUtil.createCell(cellStyles3, row,0).setCellValue("办公用品采购单");
         
         row=sheet1.createRow(2);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("采购单流水号：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getSerialNumber());
         row=sheet1.createRow(3);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("发起人部门：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getDepartmentName());
         row=sheet1.createRow(4);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("发起人：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getName());
         row=sheet1.createRow(5);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("需求部门：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getOfficeName());
         row=sheet1.createRow(6);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("合计：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getPrice());
         row=sheet1.createRow(7);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("备注：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getRemarks());
         row=sheet1.createRow(8);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("采购详情：");
         ExcelUtil.createCell(cellStyles4, row,1).setCellValue("物品名字");
         ExcelUtil.createCell(cellStyles4, row,2).setCellValue("计量单位");
         ExcelUtil.createCell(cellStyles4, row,3).setCellValue("数量");
         ExcelUtil.createCell(cellStyles4, row,4).setCellValue("单价");
         for (int i = 0; i < list.size(); i++) {// 采购详情
        	 row=sheet1.createRow(i+9);
        	 WorkShoppingDetails workShoppingDetails=list.get(i);
        	 ExcelUtil.createCell(cellStyles1, row,1).setCellValue(workShoppingDetails.getArticlesName());
        	 ExcelUtil.createCell(cellStyles1, row,2).setCellValue(workShoppingDetails.getCompany());
        	 ExcelUtil.createCell(cellStyles1, row,3).setCellValue(workShoppingDetails.getNum());
        	 ExcelUtil.createCell(cellStyles1, row,4).setCellValue(workShoppingDetails.getPrice()+"元");
		}
         //----------------------------------------------------------------------------
	     row=sheet1.createRow(list.size()+12);
	     ExcelUtil.createCell(cellStyles2, row,0).setCellValue("审批情况：");
	     ExcelUtil.createCell(cellStyles4, row,1).setCellValue("序号");
	     ExcelUtil.createCell(cellStyles4, row,2).setCellValue("处理步奏");
	     ExcelUtil.createCell(cellStyles4, row,3).setCellValue("签名");
	     ExcelUtil.createCell(cellStyles4, row,4).setCellValue("情况");
	     ExcelUtil.createCell(cellStyles4, row,5).setCellValue("审批日期");
	     ExcelUtil.createCell(cellStyles4, row,6).setCellValue("审批意见");
         // 签名情况
         List<SignVo> listSignVo=listSignVo(item);
         ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); 
         String path=request.getSession().getServletContext().getRealPath("/").replaceAll("\\\\", "/");// 项目路径
         String signPath="";// 签名路径
         String type="";// 图片类型
	         for (int i = 0; i < listSignVo.size(); i++) {// 签名
	        	 row=sheet1.createRow(i+(list.size()+13));
	        	 row.setHeight((short)(40*20));
	        	 ExcelUtil.createCell(cellStyles1, row,1).setCellValue(i+1);
	        	 ExcelUtil.createCell(cellStyles1, row,2).setCellValue(listSignVo.get(i).getSignName());
	        	 ExcelUtil.createCell(cellStyles1, row,3);
	        	 try {
		        	 signPath=listSignVo.get(i).getSign().replace("/jeesite", "");//去掉项目前缀
		        	 if (signPath!=null&&!signPath.equals("")) {
		        		 type=signPath.substring(signPath.lastIndexOf(".")+1);
			        	 ImageIO.write(ImageIO.read(new File(path+signPath)), type, byteArrayOut);
			        	 HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 3, (i+list.size()+13), (short)4, (i+list.size()+14));// 设置图片插入位置   
			             anchor.setAnchorType(3);
			             patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), WorkUtils.getPictureType(type))); 
			             byteArrayOut.reset();
		        	 }
	        	 } catch (IOException e) {
	       			e.printStackTrace();
	       		 }   
	        	 ExcelUtil.createCell(cellStyles1, row,4).setCellValue(listSignVo.get(i).getOperation()==1?"同意":"不同意" );
	        	 ExcelUtil.createCell(cellStyles1, row,5).setCellValue(DateUtils.formatDate(listSignVo.get(i).getDateTime(), "yyyy-MM-dd HH:mm:ss"));
	        	 ExcelUtil.createCell(cellStyles1, row,6).setCellValue(listSignVo.get(i).getText());
	        	
			}
         ExcelUtil.exportExcelData("办公用品采购单",response,wb);
	}
	/**获取签名信息*/
	private List<SignVo> listSignVo(WorkShopping item){
		List<SignVo> listSign=new ArrayList<SignVo>();
		if (!item.getPeople1().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate1());
			signVo.setOperation(item.getOpinion1());
			signVo.setText(item.getText1());
			signVo.setSign(item.getSign1());
			signVo.setSignName("经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople2().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate2());
			signVo.setOperation(item.getOpinion2());
			signVo.setText(item.getText2());
			signVo.setSign(item.getSign2());
			signVo.setSignName("分管领导审批");
			listSign.add(signVo);
		}
		if (!item.getPeople3().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate3());
			signVo.setOperation(item.getOpinion3());
			signVo.setText(item.getText3());
			signVo.setSign(item.getSign3());
			signVo.setSignName("总经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople4().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate4());
			signVo.setOperation(item.getOpinion4());
			signVo.setText(item.getText4());
			signVo.setSign(item.getSign4());
			signVo.setSignName("财务确认并付款");
			listSign.add(signVo);
		}
		return listSign;
	}
}

