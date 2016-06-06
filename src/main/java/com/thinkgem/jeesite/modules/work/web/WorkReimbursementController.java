package com.thinkgem.jeesite.modules.work.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dto.SignVo;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;
import com.thinkgem.jeesite.modules.work.form.WorkReimbursementForm;
import com.thinkgem.jeesite.modules.work.form.WorkShoppingForm;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.modules.work.service.WorkReimbursementService;
import com.thinkgem.jeesite.modules.work.utils.ExcelUtil;
import com.thinkgem.jeesite.modules.work.utils.WorkUtils;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/reimbursement")
public class WorkReimbursementController extends BaseController {

	@Resource(name = "workReimbursementServiceImpl")
	private WorkReimbursementService workReimbursementService;
	@Autowired
	private OfficeService officeService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;

	@RequiresPermissions("work:reimbursement:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkReimbursement> page=workReimbursementForm.getPage();// 获取分页对象
		WorkReimbursementCondition condition=workReimbursementForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workReimbursementService.listWorkReimbursementByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workReimbursementList";
	}
	@RequiresPermissions("work:reimbursement:list")
	@RequestMapping(value = "/list")
	public String index(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkReimbursement> page=workReimbursementForm.getPage();// 获取分页对象
		WorkReimbursementCondition condition=workReimbursementForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workReimbursementService.listWorkReimbursementByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workReimbursementList";
	}
	
	@RequiresPermissions("work:reimbursement:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkReimbursement> page=workReimbursementForm.getPage();// 获取分页对象
		WorkReimbursementCondition condition=workReimbursementForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workReimbursementService.listWorkReimbursementByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workReimbursementList";
	}
	
	@RequiresPermissions("work:reimbursement:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkReimbursement> page=workReimbursementForm.getPage();// 获取分页对象
		WorkReimbursementCondition condition=workReimbursementForm.getCondition();
		workReimbursementService.listWorkReimbursementByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workReimbursementList";
	}
	
	// 已完成单据  
	@RequiresPermissions("work:reimbursement:list7")
	@RequestMapping(value = "/list7")
	public String list7(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkReimbursement> page=workReimbursementForm.getPage();// 获取分页对象
		WorkReimbursementCondition condition=workReimbursementForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workReimbursementService.listWorkReimbursementByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workReimbursementList";
	}
	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(workReimbursementForm.getItem().getId())){
			WorkReimbursement item = workReimbursementService.getWorkReimbursementById(workReimbursementForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			// 审批情况显示对象
			List<SignVo> listSign=listSignVo(item);
			if (office!=null) {
				item.setDepartmentName(office.getName());
			}
			model.addAttribute("addFlag",0);// 表示查看单
			if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);
			if(workReimbursementForm.getState()!=null&&workReimbursementForm.getState()==100)model.addAttribute("state", 0);
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workReimbursementForm.setItem(item);
			model.addAttribute("workReimbursementForm",workReimbursementForm);
			if (item.getState()!=100) {
			WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),8);// 创建人流程信息
			Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
			model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkReimbursement item=new WorkReimbursement();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加加班单
			model.addAttribute("workReimbursementForm",workReimbursementForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workReimbursementForm";
	}
	
	// 保存
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute WorkReimbursementForm workReimbursementForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes) {
		Integer state=0;
		String url="";
		try {
			WorkReimbursement item = workReimbursementForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),8);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				workReimbursementService.add(item);
				url="redirect:" + adminPath + "/work/reimbursement/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),8);// 创建人流程信息
				state=Integer.valueOf(workReimbursementForm.getItem().getState());// 订单当前步奏
				String id="";
				if(state<workProcess.getListProcessDetails().size()){
					id=workProcess.getListProcessDetails().get(state).getRoleid(); // 从集合中取出下一步的审批角色id
				}
				Integer step=workProcess.getListProcessDetails().get(state-1).getStep();// 这一步是第几步
				Integer stater=workProcess.getListProcessDetails().get(state-1).getState();
				switch (stater) {
				case 0:
					item.setFill(user.getId());// 执勤人员id
					item.setFillTime(new Date());
					item.setState(++step);
					item.setExamination(id);
					workReimbursementService.updateDate(item.getId(), item.getActualBegin(), item.getActualEnd());
					if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					break;
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
						WorkReimbursement workReimbursement = workReimbursementService.getWorkReimbursementById(workReimbursementForm.getItem().getId());
						if (workReimbursement.getMoney()<=10000) {
							item.setState(++step);// 下一步
							item.setExamination("");
							item.setFlag(1);
							item.setState(100);
						}else{
							item.setState(++step);// 下一步
							item.setExamination(id);
							if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						}
					}else{
						item.setFlag(2);
					}
					break;
				case 5:
					item.setDate5(new Date());
					item.setPeople5(user.getId());
					item.setSign5(user.getUserSign());
					if (item.getOpinion5()==1) {
						WorkReimbursement workReimbursement = workReimbursementService.getWorkReimbursementById(workReimbursementForm.getItem().getId());
						if (workReimbursement.getMoney()<=50000) {
							item.setState(++step);// 下一步
							item.setExamination("");
							item.setFlag(1);
							item.setState(100);
						}else{
							item.setState(++step);// 下一步
							item.setExamination(id);
							if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						}
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
					workReimbursementService.changePayment(item.getId(), 1);// 已付款
					break;
				}
				workReimbursementService.update(item);
				url="redirect:" + adminPath + "/work/reimbursement/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;
	}
	// 获取所有角色信息
/*	@RequestMapping(value = "/listRole")
	public String listRole(@ModelAttribute WorkReimbursementForm workReimbursementForm,HttpServletRequest request,HttpServletResponse response,Model model){
		List<Role> listrole=systemService.listRole();
		return renderString(response,listrole);
	}
	*/
	
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkReimbursementForm workReimbursementForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workReimbursementService.delByIds(workReimbursementForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workReimbursementForm,request,response,model);
	}
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkReimbursementForm workReimbursementForm,HttpServletRequest request,HttpServletResponse response,Model model){
			workReimbursementService.termination(workReimbursementForm.getItem().getId());
			return index0(workReimbursementForm,request,response,model);
	}
	/**差旅单导出*/
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/exportReimbursement")
	public void exportShopping(@ModelAttribute WorkReimbursementForm workReimbursementForm,HttpServletRequest request,HttpServletResponse response){
		WorkReimbursement item = workReimbursementService.getWorkReimbursementById(workReimbursementForm.getItem().getId());
		// 创建一个工作薄   
        HSSFWorkbook wb = new HSSFWorkbook();   
        HSSFSheet sheet1 = wb.createSheet("sheet1"); 
        // 列宽
        sheet1.setColumnWidth(0, 14 * 256);
        sheet1.setColumnWidth(1, 13 * 256);
        sheet1.setColumnWidth(2, 13 * 256);
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();  // 将图片写入Excel的东西
		 // 表格样式
        HSSFCellStyle cellStyles1=ExcelUtil.createHSSFCellStyle1(wb); 
        HSSFCellStyle cellStyles2= ExcelUtil.createHSSFCellStyle2(wb);
        HSSFCellStyle cellStyles3= ExcelUtil.createHSSFCellStyle3(wb);
        HSSFCellStyle cellStyles4= ExcelUtil.createHSSFCellStyle4(wb);
        // 标题
 		sheet1.addMergedRegion(new Region(0,(short)0,1,(short)6));
 	    HSSFRow row = sheet1.createRow(0);
 	    ExcelUtil.createCell(cellStyles3, row,0).setCellValue("差旅报销单");

 	    row=sheet1.createRow(1);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("所在部门：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getDepartmentName());
        row=sheet1.createRow(2);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("出差人：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getName());
        row=sheet1.createRow(3);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("出差地点：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getPlace());
        row=sheet1.createRow(4);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("出差时间：");
        String pattern="yyyy-MM-dd";
        sheet1.addMergedRegion(new Region(4,(short)1,4,(short)2));// 合并单元格
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(DateUtils.formatDate(item.getTimeBegin(), pattern)+"——"+DateUtils.formatDate(item.getTimeEnd(), pattern));
        row=sheet1.createRow(5);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("总共出差时长：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getDay());
        row=sheet1.createRow(6);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("出差事由：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(item.getDay());
        row=sheet1.createRow(7);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("费用详情：");
        ExcelUtil.createCell(cellStyles1, row,1).setCellValue("出发");
        ExcelUtil.createCell(cellStyles1, row,2).setCellValue("到达");
        sheet1.addMergedRegion(new Region(7,(short)3,8,(short)3));// 合并单元格
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue("交通工具");
        sheet1.addMergedRegion(new Region(7,(short)4,7,(short)5));// 合并单元格
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue("交通费");
        ExcelUtil.createCell(cellStyles1, row,5);
        sheet1.addMergedRegion(new Region(7,(short)6,7,(short)7));// 合并单元格
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue("出差补贴");
        ExcelUtil.createCell(cellStyles1, row,7);
        sheet1.addMergedRegion(new Region(7,(short)8,7,(short)10));// 合并单元格
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("其他费用");
        ExcelUtil.createCell(cellStyles1, row,9);
        ExcelUtil.createCell(cellStyles1, row,10);
        row=sheet1.createRow(8);
        ExcelUtil.createCell(cellStyles1, row,1).setCellValue("日期");
        ExcelUtil.createCell(cellStyles1, row,2).setCellValue("日期");
        ExcelUtil.createCell(cellStyles1, row,3);
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue("单据张数");
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue("金额");
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue("天数");
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue("金额");
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("项目");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue("单据张数");
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue("金额");
        //----------费用详情
        row=sheet1.createRow(9);
        if (item.getTimeSetout1()==null) {
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue(DateUtils.formatDate(item.getTimeSetout1(), pattern));
        }
        if (item.getTimeArrive1()==null) {
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue(DateUtils.formatDate(item.getTimeArrive1(), pattern));
        }
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getTraffic1()));
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getTrafficBill1()));
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getTrafficAmount1()));
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getSubsidyDay1()));
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getSubsidyAmount1()));
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("住宿费");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getOtherNum1()));
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getOtherAmount1()));
        row=sheet1.createRow(10);
        if (item.getTimeSetout2()==null) {
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue(DateUtils.formatDate(item.getTimeSetout2(), pattern));
        }
        if (item.getTimeArrive2()==null) {
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue(DateUtils.formatDate(item.getTimeArrive2(), pattern));
        }
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue(item.getTraffic2());
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getTrafficBill2()));
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getTrafficAmount2()));
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getSubsidyDay2()));
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getSubsidyAmount2()));
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("室内车费");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getOtherNum2()));
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getOtherAmount2()));
        row=sheet1.createRow(11);
        if (item.getTimeSetout3()==null) {
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue(DateUtils.formatDate(item.getTimeSetout3(), pattern));
        }
        if (item.getTimeArrive3()==null) {
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue(DateUtils.formatDate(item.getTimeArrive3(), pattern));
        }
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getTraffic3()));
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getTrafficBill3()));
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getTrafficAmount3()));
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getSubsidyDay3()));
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getSubsidyAmount3()));
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("用餐费");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getOtherNum3()));
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getOtherAmount3()));
        row=sheet1.createRow(12);
        if (item.getTimeSetout4()==null) {
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue(DateUtils.formatDate(item.getTimeSetout4(), pattern));
        }
        if (item.getTimeArrive4()==null) {
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue(DateUtils.formatDate(item.getTimeArrive4(), pattern));
        }
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getTraffic4()));
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getTrafficBill4()));
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getTrafficAmount4()));
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getSubsidyDay4()));
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getSubsidyAmount4()));
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("办公用品费");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getOtherNum4()));
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getOtherAmount4()));
        row=sheet1.createRow(13);
        if (item.getTimeSetout5()==null) {
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,1).setCellValue(DateUtils.formatDate(item.getTimeSetout5(), pattern));
        }
        if (item.getTimeArrive5()==null) {
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles1, row,2).setCellValue(DateUtils.formatDate(item.getTimeArrive5(), pattern));
        }
        ExcelUtil.createCell(cellStyles1, row,3).setCellValue(isNull(item.getTraffic5()));
        ExcelUtil.createCell(cellStyles1, row,4).setCellValue(isNull(item.getTrafficBill5()));
        ExcelUtil.createCell(cellStyles1, row,5).setCellValue(isNull(item.getTrafficAmount5()));
        ExcelUtil.createCell(cellStyles1, row,6).setCellValue(isNull(item.getSubsidyDay5()));
        ExcelUtil.createCell(cellStyles1, row,7).setCellValue(isNull(item.getSubsidyAmount5()));
        ExcelUtil.createCell(cellStyles1, row,8).setCellValue("其他");
        ExcelUtil.createCell(cellStyles1, row,9).setCellValue(isNull(item.getOtherNum5()));
        ExcelUtil.createCell(cellStyles1, row,10).setCellValue(isNull(item.getOtherAmount5()));
        row=sheet1.createRow(14);
        ExcelUtil.createCell(cellStyles1, row,1).setCellValue("合计：");
        sheet1.addMergedRegion(new Region(14,(short)2,14,(short)10));// 合并单元格
        ExcelUtil.createCell(cellStyles1, row,2).setCellValue(isNull(item.getMoney())+"￥");
        ExcelUtil.createCell(cellStyles1, row,3);
        ExcelUtil.createCell(cellStyles1, row,4);
        ExcelUtil.createCell(cellStyles1, row,5);
        ExcelUtil.createCell(cellStyles1, row,6);
        ExcelUtil.createCell(cellStyles1, row,7);
        ExcelUtil.createCell(cellStyles1, row,8);
        ExcelUtil.createCell(cellStyles1, row,9);
        ExcelUtil.createCell(cellStyles1, row,10);
        row=sheet1.createRow(15);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("报销总额：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(isNull(item.getReimbursement())+"￥");
        row=sheet1.createRow(16);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("预借差旅费：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(isNull(item.getBorrow())+"￥");
        row=sheet1.createRow(17);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("补领金额：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(isNull(item.getReplacement())+"￥");
        row=sheet1.createRow(18);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("退款金额：");
        ExcelUtil.createCell(cellStyles2, row,1).setCellValue(isNull(item.getRefund())+"￥");
        row=sheet1.createRow(19);
        ExcelUtil.createCell(cellStyles2, row,0).setCellValue("实际出差日期：");
        sheet1.addMergedRegion(new Region(19,(short)1,19,(short)2));// 合并单元格
        if (item.getActualBegin()==null) {
        	ExcelUtil.createCell(cellStyles2, row,1).setCellValue("");
        }else{
        	ExcelUtil.createCell(cellStyles2, row,1).setCellValue(DateUtils.formatDate(item.getActualBegin(), pattern)+"——"+DateUtils.formatDate(item.getActualEnd(), pattern));
        }
      //----------------------------------------------------------------------------
	     row=sheet1.createRow(21);
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
	        	 row=sheet1.createRow(i+22);
	        	 row.setHeight((short)(40*20));
	        	 ExcelUtil.createCell(cellStyles1, row,1).setCellValue(i+1);
	        	 ExcelUtil.createCell(cellStyles1, row,2).setCellValue(listSignVo.get(i).getSignName());
	        	 ExcelUtil.createCell(cellStyles1, row,3);
	        	 try {
		        	 signPath=listSignVo.get(i).getSign().replace("/jeesite", "");//去掉项目前缀
		        	 if (signPath!=null&&!signPath.equals("")) {
		        		 type=signPath.substring(signPath.lastIndexOf(".")+1);
			        	 ImageIO.write(ImageIO.read(new File(path+signPath)), type, byteArrayOut);
			        	 HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 3, (i+22), (short)4, (i+23));// 设置图片插入位置   
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
        ExcelUtil.exportExcelData("差旅报销单",response,wb);
	}
	private List<SignVo> listSignVo(WorkReimbursement item){
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
			signVo.setSignName("人力经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople3().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate3());
			signVo.setOperation(item.getOpinion3());
			signVo.setText(item.getText3());
			signVo.setSign(item.getSign3());
			signVo.setSignName("人力分管领导审批");
			listSign.add(signVo);
		}
		if (!item.getPeople4().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate4());
			signVo.setOperation(item.getOpinion4());
			signVo.setText(item.getText4());
			signVo.setSign(item.getSign4());
			signVo.setSignName("财务经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople5().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate5());
			signVo.setOperation(item.getOpinion5());
			signVo.setText(item.getText5());
			signVo.setSign(item.getSign5());
			signVo.setSignName("总经理审批");
			listSign.add(signVo);
		}
		if (!item.getPeople6().equals("")) {
			SignVo signVo=new SignVo();
			signVo.setDateTime(item.getDate6());
			signVo.setOperation(item.getOpinion6());
			signVo.setText(item.getText6());
			signVo.setSign(item.getSign6());
			signVo.setSignName("董事长");
			listSign.add(signVo);
		}
		return listSign;
	}
}

