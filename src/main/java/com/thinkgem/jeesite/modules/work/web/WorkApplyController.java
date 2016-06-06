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

import com.thinkgem.jeesite.modules.work.form.WorkApplyForm;
import com.thinkgem.jeesite.modules.work.form.WorkLeaveForm;
import com.thinkgem.jeesite.modules.work.service.WorkApplyDetailsService;
import com.thinkgem.jeesite.modules.work.service.WorkApplyService;
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
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkApply;
import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/apply")
public class WorkApplyController extends BaseController {

	@Resource(name = "workApplyServiceImpl")
	private WorkApplyService workApplyService;
	@Resource(name = "workApplyDetailsServiceImpl")
	private WorkApplyDetailsService workApplyDetailsService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private SystemService systemService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;

	@RequiresPermissions("work:apply:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model){
		Page<WorkApply> page=workApplyForm.getPage();// 获取分页对象
		WorkApplyCondition condition=workApplyForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workApplyService.listWorkApplyByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workApplyList";
	}

	@RequiresPermissions("work:apply:list")
	@RequestMapping(value = "/list")
	public String index1(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkApply> page=workApplyForm.getPage();// 获取分页对象
		WorkApplyCondition condition=workApplyForm.getCondition();
		condition.setFlag(0);//审批中
		condition.setExamination(user.getRoleList().get(0).getId());
		workApplyService.listWorkApplyByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workApplyList";
	}
	
	@RequiresPermissions("work:apply:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkApply> page=workApplyForm.getPage();// 获取分页对象
		WorkApplyCondition condition=workApplyForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workApplyService.listWorkApplyByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workApplyList";
	}
	
	@RequiresPermissions("work:apply:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkApply> page=workApplyForm.getPage();// 获取分页对象
		WorkApplyCondition condition=workApplyForm.getCondition();
		workApplyService.listWorkApplyByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workApplyList";
	}
	
	// 已完成工作
	@RequiresPermissions("work:apply:list6")
	@RequestMapping(value = "/list6")
	public String list6(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkApply> page=workApplyForm.getPage();// 获取分页对象
		WorkApplyCondition condition=workApplyForm.getCondition();
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workApplyService.listWorkApplyByPage(page,condition);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("page",page); 
		model.addAttribute("condition", condition);
		return "modules/work/workApplyList";
	}
	/**
	 * 保存办公用品申请表
	 * @return 
	 */
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model,Integer flowType){
		if(StringUtils.isNotBlank(workApplyForm.getItem().getId())){
			WorkApply item = workApplyService.getWorkApplyById(workApplyForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
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
				signVo.setSignName("人力行政经理审批");
				listSign.add(signVo);
			}
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
			// 申请详情列表
			List<WorkApplyDetails> list=workApplyDetailsService.listApplyDetails(item.getId());
			model.addAttribute("list", list);
			model.addAttribute("addFlag",0);// 表示查看单
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			/*if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);*/
			if(workApplyForm.getState()!=null&&workApplyForm.getState()==100)model.addAttribute("state", 0);
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workApplyForm.setItem(item);
			model.addAttribute("workApplyForm", workApplyForm);
			if (item.getState()!=100) {
				WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),11);// 创建人流程信息
				Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
				model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkApply item=new WorkApply();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("postName",user.getRoleList().get(0).getName());
			item.setPost(user.getRoleList().get(0).getId());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加请假单
			model.addAttribute("workApplyForm", workApplyForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workApplyForm";
	}

	/**
	 * 保存办公用品申请表
	 * @return 
	 */
	@RequestMapping(value = "/saveWorkApply")
	public String saveWorkApply(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes){
		Integer state=0;
		String url="";
		try {
			WorkApply item = workApplyForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),11);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				// 添加采购详情
				String []mode=workApplyForm.getProducts().split(",");
				if(mode[0].equals("")){
					return "error/numError2";
				}
				workApplyService.addPrevent(mode,item);
				url="redirect:" + adminPath + "/work/apply/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),11);// 创建人流程信息
				state=Integer.valueOf(workApplyForm.getItem().getState());// 订单当前步奏
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
				}
				workApplyService.update(item);
				url="redirect:" + adminPath + "/work/apply/list";//根据单据状态，参看对应单据信息
			}
		} catch (Exception e) {
			String msg = "保存请假单表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;	
	}
	/**
	 * 删除WorkApply
	 * @return 
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkApplyForm workApplyForm, HttpServletRequest request, HttpServletResponse response, Model model,Integer flowType){
		try {
			workApplyService.delByIds(workApplyForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除办公用品申请表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
			return index0(workApplyForm,request,response,model);
	}
	// 终止
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkApplyForm workApplyForm,HttpServletRequest request,HttpServletResponse response,Model model){
		workApplyService.termination(workApplyForm.getItem().getId());
		return index0(workApplyForm,request,response,model);
	}
}

