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

import com.thinkgem.jeesite.modules.work.form.WorkIntegralForm;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dto.SignVo;
import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.service.WorkIntegralService;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;


@Controller("workIntegralController")
@Scope("prototype")
@RequestMapping(value = "${adminPath}/work/integral")
public class WorkIntegralController extends BaseController {

	@Resource(name = "workIntegralServiceImpl")
	private WorkIntegralService workIntegralService;
	@Autowired
	private OfficeService officeService;
	@Resource(name = "workProcessServiceImpl")
	private WorkProcessService workProcessService;
	
	// 会服部发起记分撤销申请
	@RequiresPermissions("work:integral:list:flowType")
	@RequestMapping(value = "/listflowType")
	public String index0(WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkIntegral> page=workIntegralForm.getPage();// 获取分页对象
		WorkIntegralCondition condition=workIntegralForm.getCondition();
		// 根据用户id  查询用户所写单据
		condition.setCreateBy(user.getId());
		condition.setFlag(0);
		workIntegralService.listWorkIntegralByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workIntegralList";
	}
	@RequiresPermissions("work:integral:list")
	@RequestMapping(value = "/list")
	public String index1(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkIntegral> page=workIntegralForm.getPage();// 获取分页对象
		WorkIntegralCondition condition=workIntegralForm.getCondition();
		User user=UserUtils.getUser();// 获取当前用户
		condition.setExamination(user.getRoleList().get(0).getId());
		condition.setFlag(0);//审批中
		workIntegralService.listWorkIntegralByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 1);
		model.addAttribute("condition", condition);
		return "modules/work/workIntegralList";
	}
	
	@RequiresPermissions("work:integral:listAllof")
	@RequestMapping(value = "/listAllof")
	public String listAllof(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();// 获取当前用户
		Page<WorkIntegral> page=workIntegralForm.getPage();// 获取分页对象
		WorkIntegralCondition condition=workIntegralForm.getCondition();
		condition.setDepartment(user.getOffice().getId());
		condition.setDepartmentName(user.getOffice().getName());
		workIntegralService.listWorkIntegralByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workIntegralList";
	}
	
	@RequiresPermissions("work:integral:listAll")
	@RequestMapping(value = "/listAll")
	public String listAll(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkIntegral> page=workIntegralForm.getPage();// 获取分页对象
		WorkIntegralCondition condition=workIntegralForm.getCondition();
		workIntegralService.listWorkIntegralByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("state", 6);
		model.addAttribute("saveBut", 0);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("condition", condition);
		return "modules/work/workIntegralList";
	}
	
	// 已完成工作
	@RequiresPermissions("work:integral:list6")
	@RequestMapping(value = "/list6")
	public String list6(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkIntegral> page=workIntegralForm.getPage();// 获取分页对象
		WorkIntegralCondition condition=workIntegralForm.getCondition();
		User user=UserUtils.getUser();// 获取当前用户
		condition.setSignPeople(user.getId());
		workIntegralService.listWorkIntegralByPage(page,condition);
		model.addAttribute("state", 6);
		model.addAttribute("bossFlag", 0);
		model.addAttribute("page",page); 
		model.addAttribute("condition", condition);
		return "modules/work/workIntegralList";
	}
	
	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(workIntegralForm.getItem().getId())){
			WorkIntegral item = workIntegralService.getWorkIntegralById(workIntegralForm.getItem().getId());
			if(!item.getCreateBy().equals(UserUtils.getUser().getId())&&item.getExamination().equals(UserUtils.getUser().getId()) && item.getState()!=0 && item.getState()!=100){return "error/numError";}// 过期单据
			Office office=officeService.getOfficeById(item.getDepartment());// 查询所属部门信息
			List<SignVo> listSign=new ArrayList<SignVo>();
			if (!item.getPeople1().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate1());
				signVo.setOperation(item.getOpinion1());
				signVo.setText(item.getText1());
				signVo.setSign(item.getSign1());
				signVo.setSignName("IT部冻结账户");
				listSign.add(signVo);
			}
			if (!item.getPeople2().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate2());
				signVo.setOperation(item.getOpinion2());
				signVo.setText(item.getText2());
				signVo.setSign(item.getSign2());
				signVo.setSignName("客服电话回访");
				listSign.add(signVo);
			}
			if (!item.getPeople2_5().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate2_5());
				signVo.setOperation(item.getOpinion2_5());
				signVo.setText(item.getText2_5());
				signVo.setSign(item.getSign2_5());
				signVo.setSignName("客服经理");
				listSign.add(signVo);
			}
			if (!item.getPeople3().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate3());
				signVo.setOperation(item.getOpinion3());
				signVo.setText(item.getText3());
				signVo.setSign(item.getSign3());
				signVo.setSignName("IT部解冻账户");
				
			}
			if (!item.getPeople4().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate4());
				signVo.setOperation(item.getOpinion4());
				signVo.setText(item.getText4());
				signVo.setSign(item.getSign4());
				signVo.setSignName("分管领导审批");
				listSign.add(signVo);
			}
			if (!item.getPeople5().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate5());
				signVo.setOperation(item.getOpinion5());
				signVo.setText(item.getText5());
				signVo.setSign(item.getSign5());
				signVo.setSignName("财务确认并退款");
				listSign.add(signVo);
			}
			if (!item.getPeople6().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate6());
				signVo.setOperation(item.getOpinion6());
				signVo.setText(item.getText6());
				signVo.setSign(item.getSign6());
				signVo.setSignName("积分清零并解冻账户");
				listSign.add(signVo);
			}
			if (!item.getPeople7().equals("")) {
				SignVo signVo=new SignVo();
				signVo.setDateTime(item.getDate7());
				signVo.setOperation(item.getOpinion7());
				signVo.setText(item.getText7());
				signVo.setSign(item.getSign7());
				signVo.setSignName("会服入档确认");
				listSign.add(signVo);
			}
			if (office!=null) {
				item.setDepartmentName(office.getName());
			}
			model.addAttribute("addFlag",0);// 表示查看单
			if(!item.getExamination().equals(UserUtils.getUser().getRoleList().get(0).getId())){model.addAttribute("saveBut", 0);};
			/*if(item.getCreateBy().equals(UserUtils.getUser().getId()))model.addAttribute("state", 0);*/
			if(workIntegralForm.getState()!=null&&workIntegralForm.getState()==100)model.addAttribute("state", 0);
			model.addAttribute("item",item);// 单对象
			model.addAttribute("listSign", listSign);// 审核信息集合
			model.addAttribute("userSign", UserUtils.getUser().getUserSign());
			workIntegralForm.setItem(item);
			model.addAttribute("workIntegralForm", workIntegralForm);
			if (item.getState()!=100) {
				WorkProcess workProcess=workProcessService.listWorkProcess(item.getCreateBy(),13);// 创建人流程信息
				Integer processState=workProcess.getListProcessDetails().get(item.getState()-1).getState();
				model.addAttribute("processState", processState);
			}
		}else{
			User user=UserUtils.getUser();// 获取当前用户
			Office office=officeService.getOfficeById(user.getOffice().getId());// 查询所属部门信息
			WorkIntegral item=new WorkIntegral();
			item.setDepartment(office.getId());
			item.setDepartmentName(office.getName());
			item.setName(user.getName());
			model.addAttribute("item",item);
			model.addAttribute("addFlag",1);// 表示添加
			model.addAttribute("workIntegralForm", workIntegralForm);
			model.addAttribute("state", 0);
		}
		return "modules/work/workIntegralForm";
	}
	
	// 保存
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute WorkIntegralForm workIntegralForm, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirectAttributes) {
		Integer state=0;
		String url="";
		try {
			WorkIntegral item = workIntegralForm.getItem();
			User user=UserUtils.getUser();// 获取当前用户
			WorkProcess workProcess=null;
			if(StringUtils.isBlank(item.getId())){
				workProcess=workProcessService.listWorkProcess(user.getId(),13);// 当前登录用户流程信息
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(1);
				item.setFlag(0);
				item.setExamination(workProcess.getListProcessDetails().get(0).getRoleid()); 
				item.setFrozen(0);// 未冻结
				item.setRecord(0);// 未入档
				item.setTransaction(user.getOffice().getCode()+user.getNo());// 公司内部编号（机构编码+用户编号（工号））
				workIntegralService.add(item);
				url="redirect:" + adminPath + "/work/integral/listflowType";
			}else{
				workProcess=workProcessService.listWorkProcess(item.getCreateBy(),13);// 创建人流程信息
				state=Integer.valueOf(workIntegralForm.getItem().getState());// 订单当前步奏
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
						workIntegralService.updateFrozen(item.getId(), 1);// 1冻结0解冻
					}else{
						item.setFlag(2);
					}
					break;
				case 2:
					item.setDate2(new Date());
					item.setPeople2(user.getId());
					item.setSign2(user.getUserSign());
					if (item.getOpinion2()==1) {
						item.setState(3+step);// 下一步
						item.setExamination(workProcess.getListProcessDetails().get(state+2).getRoleid());
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						item.setFlag(2);
					}			
					break;
				case 3:
					item.setDate3(new Date());
					item.setPeople3(user.getId());
					item.setSign3(user.getUserSign());
					if (item.getOpinion3()==1) {
						item.setState(++step);// 下一步
						item.setExamination("");
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						workIntegralService.updateFrozen(item.getId(), 0);// 解冻
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
						workIntegralService.updateRefund(item.getId(), item.getRefund());// 更新退款数量
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
						workIntegralService.updateFrozen(item.getId(), 0);// 解冻
					}else{
						item.setFlag(2);
					}
					break;
				case 7:
					item.setDate7(new Date());
					item.setPeople7(user.getId());
					item.setSign7(user.getUserSign());
					if (item.getOpinion7()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
						workIntegralService.updateRecord(item.getId(), 1);// 已入档
					}else{
						item.setFlag(2);
					}
					break;
				case 25:
					item.setDate2_5(new Date());
					item.setPeople2_5(user.getId());
					item.setSign2_5(user.getUserSign());
					if (item.getOpinion2_5()==1) {
						item.setState(++step);// 下一步
						item.setExamination(id);
						if(state>=workProcess.getListProcessDetails().size()){item.setFlag(1);item.setState(100);}
					}else{
						item.setState(100);// 下一步
						item.setExamination("");
						item.setFlag(2);
					}
					break;
				}
				workIntegralService.update(item);
				url="redirect:" + adminPath + "/work/integral/list";//根据单据状态，参看对应单据信息	
			}
		} catch (Exception e) {
			String msg = "保存请假单表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		addMessage(redirectAttributes, "保存成功");
		return url;
	}
	
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute WorkIntegralForm workIntegralForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			workIntegralService.delByIds(workIntegralForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除请假单表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return index0(workIntegralForm,request,response,model);
	}
	/**
	 * 终止
	 */
	@RequestMapping(value = "/termination")
	public String termination(@ModelAttribute WorkIntegralForm workIntegralForm,HttpServletRequest request,HttpServletResponse response,Model model){
		workIntegralService.termination(workIntegralForm.getItem().getId());
		return index0(workIntegralForm,request,response,model);
	}

}

