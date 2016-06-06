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
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;
import com.thinkgem.jeesite.modules.work.form.WorkLeaveForm;
import com.thinkgem.jeesite.modules.work.form.WorkRestForm;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.modules.work.service.WorkRestService;



@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/rest")
public class WorkRestController extends BaseController {

	@Resource(name = "workRestServiceImpl")
	private WorkRestService workRestService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private SystemService systemService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;

	@RequiresPermissions("work:rest:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkRest> page=workRestForm.getPage();// 获取分页对象
		WorkRestCondition condition=workRestForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workRestService.listWorkRestByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workRestList";
	}
	// 部门主管
	@RequiresPermissions("work:rest:list")
	@RequestMapping(value = "/list")
	public String index(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkRest> page=workRestForm.getPage();// 获取分页对象
		WorkRestCondition condition=workRestForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workRestService.listWorkRestByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workRestList";
	}
	
	@RequiresPermissions("work:rest:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkRest> page=workRestForm.getPage();// 获取分页对象
		WorkRestCondition condition=workRestForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workRestService.listWorkRestByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workRestList";
	}
	
	@RequiresPermissions("work:rest:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkRest> page=workRestForm.getPage();// 获取分页对象
		WorkRestCondition condition=workRestForm.getCondition();
		workRestService.listWorkRestByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workRestList";
	}
	
	@RequiresPermissions("work:rest:list6")
	@RequestMapping(value = "/list6")
	public String index6(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkRest> page=workRestForm.getPage();// 获取分页对象
		WorkRestCondition condition=workRestForm.getCondition(); 
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workRestService.listWorkRestByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workRestList";
	}
	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(workRestForm.getItem().getId())){
			WorkRest item = workRestService.getWorkRestById(workRestForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			List<SignVo> listSign=new ArrayList<SignVo>();
			if (!item.getPeople1().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate1());
				signVo.setOperation(item.getOpinion1());
				signVo.setText(item.getText1());
				signVo.setSign(item.getSign1());
				signVo.setSignName("主管审批");
				listSign.add(signVo);
			}
			if (!item.getPeople2().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate2());
				signVo.setOperation(item.getOpinion2());
				signVo.setText(item.getText2());
				signVo.setSign(item.getSign2());
				signVo.setSignName("经理审批");
				listSign.add(signVo);
			}
			if (!item.getPeople3().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate3());
				signVo.setOperation(item.getOpinion3());
				signVo.setText(item.getText3());
				signVo.setSign(item.getSign3());
				signVo.setSignName("分管领导审批");
				listSign.add(signVo);
			}
			if (!item.getPeople4().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate4());
				signVo.setOperation(item.getOpinion4());
				signVo.setText(item.getText4());
				signVo.setSign(item.getSign4());
				signVo.setSignName("人力行政经理审批");
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
			model.addAttribute("addFlag",0);// 表示查看
			if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);
			if(workRestForm.getState()!=null&&workRestForm.getState()==100)model.addAttribute("state", 0);
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workRestForm.setItem(item);
			model.addAttribute("workRestForm",workRestForm);
			if (item.getState()!=100) {
			WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),1);// 创建人流程信息
			Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
			model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkRest item=new WorkRest();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("postName",user.getRoleList().get(0).getName());
			item.setPost(user.getRoleList().get(0).getId());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加加班单
			model.addAttribute("workRestForm",workRestForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workRestForm";
	}
	
	// 保存
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute WorkRestForm workRestForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes) {
		Integer state=0;
		String url="";
		try {
			WorkRest item = workRestForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),1);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				workRestService.add(item);
				url="redirect:" + adminPath + "/work/rest/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),1);// 创建人流程信息
				state=Integer.valueOf(workRestForm.getItem().getState());// 订单当前步奏
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
				}
				workRestService.update(item);
				url="redirect:" + adminPath + "/work/rest/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;
	}
	
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkRestForm workRestForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workRestService.delByIds(workRestForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workRestForm,request,response,model);
	}

	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkRestForm workRestForm,HttpServletRequest request,HttpServletResponse response,Model model){
			workRestService.termination(workRestForm.getItem().getId());
			return index0(workRestForm,request,response,model);
	}
}

