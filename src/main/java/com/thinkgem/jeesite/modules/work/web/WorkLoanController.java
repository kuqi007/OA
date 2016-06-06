package com.thinkgem.jeesite.modules.work.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.modules.work.form.WorkLeaveForm;
import com.thinkgem.jeesite.modules.work.form.WorkLoanForm;
import com.thinkgem.jeesite.modules.work.service.WorkLoanService;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dto.SignVo;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.entity.WorkLoan;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;


@Controller("workLoanController")
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/loan")
public class WorkLoanController extends BaseController {

	@Resource(name = "workLoanServiceImpl")
	private WorkLoanService workLoanService;

	@Autowired
	private OfficeService officeService;
	@Autowired
	private SystemService systemService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;

	@RequiresPermissions("work:loan:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkLoan> page=workLoanForm.getPage();// 获取分页对象
		WorkLoanCondition condition=workLoanForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workLoanService.listWorkLoanByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workLoanList";
	}
	@RequiresPermissions("work:loan:list")
	@RequestMapping(value = "/list")
	public String index1(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkLoan> page=workLoanForm.getPage();// 获取分页对象
		WorkLoanCondition condition=workLoanForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workLoanService.listWorkLoanByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workLoanList";
	}
	
	@RequiresPermissions("work:loan:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkLoan> page=workLoanForm.getPage();// 获取分页对象
		WorkLoanCondition condition=workLoanForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workLoanService.listWorkLoanByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workLoanList";
	}
	
	@RequiresPermissions("work:loan:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkLoan> page=workLoanForm.getPage();// 获取分页对象
		WorkLoanCondition condition=workLoanForm.getCondition();
		workLoanService.listWorkLoanByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workLoanList";
	}
	
	@RequiresPermissions("work:loan:list6")
	@RequestMapping(value = "/list6")
	public String index6(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkLoan> page=workLoanForm.getPage();// 获取分页对象
		WorkLoanCondition condition=workLoanForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workLoanService.listWorkLoanByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workLoanList";
	}
	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(workLoanForm.getItem().getId())){
			WorkLoan item = workLoanService.getWorkLoanById(workLoanForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			// 审批情况显示对象
			List<SignVo> listSign=new ArrayList<SignVo>();
			if (!item.getPeople4().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate4());
				signVo.setOperation(item.getOpinion4());
				signVo.setText(item.getText4());
				signVo.setSign(item.getSign4());
				signVo.setSignName("经理审批");
				listSign.add(signVo);
			}
			if (!item.getPeople1().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate1());
				signVo.setOperation(item.getOpinion1());
				signVo.setText(item.getText1());
				signVo.setSign(item.getSign1());
				signVo.setSignName("分管领导审批");
				listSign.add(signVo);
			}
			if (!item.getPeople2().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate2());
				signVo.setOperation(item.getOpinion2());
				signVo.setText(item.getText2());
				signVo.setSign(item.getSign2());
				signVo.setSignName("财务经理审批");
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
			if (office!=null) {
				item.setDepartmentName(office.getName());
				List<Role> listRole=systemService.listRole();
				model.addAttribute("listRole",listRole);//职务列表
			}
			
			model.addAttribute("addFlag",0);// 表示查看单
			if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);
			if(workLoanForm.getState()!=null&&workLoanForm.getState()==100)model.addAttribute("state", 0);
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workLoanForm.setItem(item);
			model.addAttribute("workLoanForm",workLoanForm);
			if (item.getState()!=100) {
				WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),14);// 创建人流程信息
				Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
				model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkLoan item=new WorkLoan();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加加班单
			model.addAttribute("workLoanForm",workLoanForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workLoanForm";
	}
	
	// 保存
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute WorkLoanForm workLoanForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes) {
		Integer state=0;
		String url="";
		try {
			WorkLoan item = workLoanForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),14);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				workLoanService.add(item);
				url="redirect:" + adminPath + "/work/loan/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),14);// 创建人流程信息
				state=Integer.valueOf(workLoanForm.getItem().getState());// 订单当前步奏
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
					if(item.getOpinion4()==1){
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						workLoanService.changeLoan(item.getId(), 1);// 已付款
					}else{
						item.setFlag(2);
					}
					break;
				}
				workLoanService.update(item);
				url="redirect:" + adminPath + "/work/loan/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;
	}
	
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkLoanForm workLoanForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workLoanService.delByIds(workLoanForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workLoanForm,request, response, model);
	}
	
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkLoanForm workLoanForm,HttpServletRequest request,HttpServletResponse response,Model model){
		workLoanService.termination(workLoanForm.getItem().getId());
		return index0(workLoanForm,request, response, model);
	}
}

