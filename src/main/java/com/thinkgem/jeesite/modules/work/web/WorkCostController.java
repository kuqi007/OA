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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.modules.work.form.WorkCostForm;
import com.thinkgem.jeesite.modules.work.form.WorkLeaveForm;
import com.thinkgem.jeesite.modules.work.form.WorkShoppingForm;
import com.thinkgem.jeesite.modules.work.service.WorkCostService;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.modules.work.utils.ExcelUtil;
import com.thinkgem.jeesite.modules.work.utils.WorkUtils;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dto.SignVo;
import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkCost;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/cost")
public class WorkCostController extends BaseController {

	@Resource(name = "workCostServiceImpl")
	private WorkCostService workCostService;
	@Autowired
	private OfficeService officeService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;
	

	@RequiresPermissions("work:cost:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response,Model model){
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkCost> page=workCostForm.getPage();// 获取分页对象
		WorkCostCondition condition=workCostForm.getCondition();
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workCostService.listWorkCostByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workCostList";
	}
	
	@RequiresPermissions("work:cost:list")
	@RequestMapping(value = "/list")
	public String index1(@ModelAttribute WorkCostForm workCostForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkCost> page=workCostForm.getPage();// 获取分页对象
		WorkCostCondition condition=workCostForm.getCondition();
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workCostService.listWorkCostByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workCostList";
	}
	@RequiresPermissions("work:cost:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkCostForm workCostForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkCost> page=workCostForm.getPage();// 获取分页对象
		WorkCostCondition condition=workCostForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workCostService.listWorkCostByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workCostList";
	}
	
	@RequiresPermissions("work:cost:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkCostForm workCostForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkCost> page=workCostForm.getPage();// 获取分页对象
		WorkCostCondition condition=workCostForm.getCondition();
		workCostService.listWorkCostByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workCostList";
	}
	// 已完成工作
	@RequiresPermissions("work:cost:list6")
	@RequestMapping(value = "/list6")
	public String list6(@ModelAttribute WorkCostForm workCostForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkCost> page=workCostForm.getPage();// 获取分页对象
		WorkCostCondition condition=workCostForm.getCondition();
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workCostService.listWorkCostByPage(page,condition);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("page",page);
		model.addAttribute("condition", condition);
		return "modules/work/workCostList";
	}
		

	/**
	 * 编辑费用报销单
	 * @return 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(workCostForm.getItem().getId())){
			WorkCost item = workCostService.getWorkCostById(workCostForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			// 审批情况显示对象
			List<SignVo> listSign=listSignVo(item);
			if (office!=null) {
				item.setDepartmentName(office.getName());
			}
			
			model.addAttribute("addFlag",0);// 表示查看单
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);
			if(workCostForm.getState()!=null&&workCostForm.getState()==100)model.addAttribute("state", 0);
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workCostForm.setItem(item);
			model.addAttribute("workCostForm",workCostForm);
			if (item.getState()!=100) {
				WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),10);// 创建人流程信息
				Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
				model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkCost item=new WorkCost();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("postName",user.getRoleList().get(0).getName());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加请假单
			model.addAttribute("workCostForm",workCostForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workCostForm";
	}

	/**
	 * 保存费用报销单
	 * @return 
	 */
	@RequestMapping(value = "/saveWorkCost", method = RequestMethod.POST)
	public String saveWorkCost(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		Integer state=0;
		String url="";
		try {
			WorkCost item = workCostForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),10);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid());
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				workCostService.add(item);
				url="redirect:" + adminPath + "/work/cost/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),10);// 创建人流程信息
				state=Integer.valueOf(workCostForm.getItem().getState());// 订单当前步奏
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
					}else{
						item.setFlag(2);
					}
					break;
				case 5:
					item.setDate5(new Date());
					item.setPeople5(user.getId());
					item.setSign5(user.getUserSign());
					if (item.getOpinion5()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setFlag(2);
					}
					break;
				case 6:
					item.setDate6(new Date());
					item.setPeople6(user.getId());
					item.setSign6(user.getUserSign());
					if (item.getOpinion6()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setFlag(2);
					}
					workCostService.changePayment(item.getId(), 1);// 已付款
					break;
				}
				workCostService.update(item);
				url="redirect:" + adminPath + "/work/cost/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存请假单表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;
	}
	/**
	 * 删除WorkCost
	 * @return 
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workCostService.delByIds(workCostForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除费用报销单时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workCostForm,request,response,model);
	}

	/**
	 * 终止
	 */
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response,Model model){
		workCostService.termination(workCostForm.getItem().getId());
		return index0(workCostForm,request,response,model);
	}
	/**采购单导出*/
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/exportCost")
	public void exportShopping(@ModelAttribute WorkCostForm workCostForm,HttpServletRequest request,HttpServletResponse response){
		WorkCost item = workCostService.getWorkCostById(workCostForm.getItem().getId());
		// 创建一个工作薄   
        HSSFWorkbook wb = new HSSFWorkbook();   
        HSSFSheet sheet1 = wb.createSheet("sheet1"); 
        // 列宽
        sheet1.setColumnWidth(0, 12 * 256);
        sheet1.setColumnWidth(1, 26 * 256);
        for (int i = 2; i < 10; i++) {
        	sheet1.setColumnWidth(i, 5 * 256);
		}
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();  // 将图片写入Excel的东西 
        // 表格样式
        HSSFCellStyle cellStyles1=ExcelUtil.createHSSFCellStyle1(wb); 
        HSSFCellStyle cellStyles2= ExcelUtil.createHSSFCellStyle2(wb);
        HSSFCellStyle cellStyles3= ExcelUtil.createHSSFCellStyle3(wb);
        HSSFCellStyle cellStyles4= ExcelUtil.createHSSFCellStyle4(wb);
        // 标题
  		sheet1.addMergedRegion(new Region(0,(short)0,1,(short)6));// 合并单元格
  	    HSSFRow row = sheet1.createRow(0);
  	    ExcelUtil.createCell(cellStyles3, row,0).setCellValue("费用报销单");
  	    
		 row=sheet1.createRow(2);
		 ExcelUtil.createCell(cellStyles2, row,0).setCellValue("所在部门：");
		 ExcelUtil.createCell(cellStyles2, row,1).setCellValue(officeService.getOfficeById(item.getDepartment()).getName());
		 row=sheet1.createRow(3);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("姓名：");
         ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getName());
         row=sheet1.createRow(4);
         ExcelUtil.createCell(cellStyles2, row,0).setCellValue("费用详情：");
         sheet1.addMergedRegion(new Region(4,(short)1,5,(short)1));// 合并单元格
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue("摘要");
         sheet1.addMergedRegion(new Region(4,(short)2,4,(short)9));// 合并单元格
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue("金额");
         ExcelUtil.createCell(cellStyles1, row,3);
         ExcelUtil.createCell(cellStyles1, row,4);
         ExcelUtil.createCell(cellStyles1, row,5);
         ExcelUtil.createCell(cellStyles1, row,6);
         ExcelUtil.createCell(cellStyles1, row,7);
         ExcelUtil.createCell(cellStyles1, row,8);
         ExcelUtil.createCell(cellStyles1, row,9);
         sheet1.addMergedRegion(new Region(4,(short)10,5,(short)10));// 合并单元格
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue("科目");
         sheet1.addMergedRegion(new Region(4,(short)11,5,(short)11));// 合并单元格
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue("单据张数");
         row=sheet1.createRow(5);
         ExcelUtil.createCell(cellStyles1, row,1);
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue("十");
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue("万");
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue("千");
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue("百");
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue("十");
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue("元");
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue("角");
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue("分");
         ExcelUtil.createCell(cellStyles1, row,10);
         ExcelUtil.createCell(cellStyles1, row,11);
         row=sheet1.createRow(6);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract1()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney11()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney12()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney13()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney14()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney15()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney16()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney17()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney18()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject1()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum1()));
         row=sheet1.createRow(7);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract2()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney21()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney22()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney23()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney24()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney25()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney26()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney27()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney28()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject2()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum2()));
         row=sheet1.createRow(8);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract3()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney31()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney32()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney33()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney34()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney35()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney36()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney37()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney38()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject3()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum3()));
         row=sheet1.createRow(9);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract4()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney41()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney42()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney43()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney44()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney45()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney46()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney47()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney48()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject4()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum4()));
         row=sheet1.createRow(10);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract5()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney51()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney52()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney53()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney54()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney55()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney56()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney57()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney58()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject5()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum5()));
         row=sheet1.createRow(11);
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue(isNull(item.getAbstract6()));
         ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney61()));
         ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getMoney62()));
         ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getMoney63()));
         ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getMoney64()));
         ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getMoney65()));
         ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getMoney66()));
         ExcelUtil.createCell(cellStyles1, row,8).setCellValue(isNull(item.getMoney67()));
         ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getMoney68()));
         ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getSubject6()));
         ExcelUtil.createCell(cellStyles1, row,11).setCellValue(isNull(item.getNum6()));
         row=sheet1.createRow(12);
         sheet1.addMergedRegion(new Region(12,(short)1,12,(short)11));// 合并单元格
         ExcelUtil.createCell(cellStyles1, row,1).setCellValue("合计："+item.getCapital()+"￥");
         for (int i = 2; i < 12; i++) {
        	 ExcelUtil.createCell(cellStyles1, row,i);
		}
         //-----------------------------------------------
         row=sheet1.createRow(14);
	     ExcelUtil.createCell(cellStyles2, row,0).setCellValue("审批情况：");
	     ExcelUtil.createCell(cellStyles4, row,1).setCellValue("序号");
	     sheet1.addMergedRegion(new Region(14,(short)2,14,(short)3));// 合并单元格
	     ExcelUtil.createCell(cellStyles4, row,2).setCellValue("处理步奏");
	     ExcelUtil.createCell(cellStyles1, row,3);
	     sheet1.addMergedRegion(new Region(14,(short)4,14,(short)5));// 合并单元格
	     ExcelUtil.createCell(cellStyles4, row,4).setCellValue("签名");
	     ExcelUtil.createCell(cellStyles1, row,5);
	     sheet1.addMergedRegion(new Region(14,(short)6,14,(short)7));// 合并单元格
	     ExcelUtil.createCell(cellStyles4, row,6).setCellValue("情况");
	     ExcelUtil.createCell(cellStyles1, row,7);
	     sheet1.addMergedRegion(new Region(14,(short)8,14,(short)9));// 合并单元格
	     ExcelUtil.createCell(cellStyles4, row,8).setCellValue("审批日期");
	     ExcelUtil.createCell(cellStyles1, row,9);
	     sheet1.addMergedRegion(new Region(14,(short)10,14,(short)11));// 合并单元格
	     ExcelUtil.createCell(cellStyles4, row,10).setCellValue("审批意见");
	     ExcelUtil.createCell(cellStyles1, row,11);
         // 签名情况
         List<SignVo> listSignVo=listSignVo(item);
         ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); 
         String path=request.getSession().getServletContext().getRealPath("/").replaceAll("\\\\", "/");// 项目路径
         String signPath="";// 签名路径
         String type="";// 图片类型
	         for (int i = 0; i < listSignVo.size(); i++) {// 签名
	        	 row=sheet1.createRow(i+15);
	        	 row.setHeight((short)(40*20));
	        	 ExcelUtil.createCell(cellStyles1, row,1).setCellValue(i+1);
	        	 sheet1.addMergedRegion(new Region(i+15,(short)2,i+15,(short)3));// 合并单元格
	        	 ExcelUtil.createCell(cellStyles1, row,2).setCellValue(listSignVo.get(i).getSignName());
	        	 ExcelUtil.createCell(cellStyles1, row,3);
	        	 ExcelUtil.createCell(cellStyles1, row,4);
	        	 ExcelUtil.createCell(cellStyles1, row,5);
	        	 sheet1.addMergedRegion(new Region(i+15,(short)4,i+15,(short)5));// 合并单元格
	        	 try {
		        	 signPath=listSignVo.get(i).getSign().replace("/jeesite", "");//去掉项目前缀
		        	 if (signPath!=null&&!signPath.equals("")) {
		        		 type=signPath.substring(signPath.lastIndexOf(".")+1);
			        	 ImageIO.write(ImageIO.read(new File(path+signPath)), type, byteArrayOut);
			        	 HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 4, (i+15), (short)6, (i+16));// 设置图片插入位置   
			             anchor.setAnchorType(3);
			             patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), WorkUtils.getPictureType(type))); 
			             byteArrayOut.reset();
		        	 }
	        	 } catch (IOException e) { 
	       			e.printStackTrace();
	       		 }   
	        	 sheet1.addMergedRegion(new Region(i+15,(short)6,i+15,(short)7));// 合并单元格
	        	 ExcelUtil.createCell(cellStyles1, row,6).setCellValue(listSignVo.get(i).getOperation()==1?"同意":"不同意" );
	        	 ExcelUtil.createCell(cellStyles1, row,7);
	        	 sheet1.addMergedRegion(new Region(i+15,(short)8,i+15,(short)9));// 合并单元格
	        	 ExcelUtil.createCell(cellStyles1, row,8).setCellValue(DateUtils.formatDate(listSignVo.get(i).getDateTime(), "yyyy-MM-dd HH:mm:ss"));
	        	 ExcelUtil.createCell(cellStyles1, row,9);
	        	 sheet1.addMergedRegion(new Region(i+15,(short)10,i+15,(short)11));// 合并单元格
	        	 ExcelUtil.createCell(cellStyles1, row,10).setCellValue(listSignVo.get(i).getText());
	        	 ExcelUtil.createCell(cellStyles1, row,11);
	        	
			}
         
         ExcelUtil.exportExcelData("费用报销单",response,wb);
	}
	private List<SignVo> listSignVo(WorkCost item){
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
			signVo.setSignName("人事经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople3().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate3());
			signVo.setOperation(item.getOpinion3());
			signVo.setText(item.getText3());
			signVo.setSign(item.getSign3());
			signVo.setSignName("财务经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople4().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate4());
			signVo.setOperation(item.getOpinion4());
			signVo.setText(item.getText4());
			signVo.setSign(item.getSign4());
			signVo.setSignName("总经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople5().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate5());
			signVo.setOperation(item.getOpinion5());
			signVo.setText(item.getText5());
			signVo.setSign(item.getSign5());
			signVo.setSignName("预留审批");
			listSign.add(signVo);
		}
		if (!item.getPeople6().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate6());
			signVo.setOperation(item.getOpinion6());
			signVo.setText(item.getText6());
			signVo.setSign(item.getSign6());
			signVo.setSignName("预留");
			listSign.add(signVo);
		}
		return 	listSign;
	}
}

