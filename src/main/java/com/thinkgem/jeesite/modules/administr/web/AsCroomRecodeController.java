package com.thinkgem.jeesite.modules.administr.web;


import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.modules.administr.form.AsCroomForm;
import com.thinkgem.jeesite.modules.administr.form.AsCroomRecodeForm;
import com.thinkgem.jeesite.modules.administr.service.AsCroomRecodeService;
import com.thinkgem.jeesite.modules.administr.service.AsCroomService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomRecodeCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsCroom;
import com.thinkgem.jeesite.modules.administr.entity.AsCroomRecode;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/recode")
public class AsCroomRecodeController extends BaseController {

	@Resource(name = "asCroomRecodeServiceImpl")
	private AsCroomRecodeService asCroomRecodeService;
	@Resource(name = "asCroomServiceImpl")
	private AsCroomService asCroomService;


	/**
	 * 分页查询（已审批）
	 * @return 
	 */
	@RequestMapping(value = "/listAsCroomRecode1", method = RequestMethod.GET)
	public String listAsCroomRecode1(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsCroomRecode> page=asCroomRecodeForm.getPage();// 获取分页对象
		AsCroomRecodeCondition condition=new AsCroomRecodeCondition();
		condition.setState(3);
		asCroomRecodeService.listAsCroomRecodeByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("urll", "listAsCroomRecode1");
		return "modules/administr/asRecodeList2";
	}
	/**
	 * 分页查询（待审）
	 * @return 
	 */
	@RequestMapping(value = "/listAsCroomRecode2", method = RequestMethod.GET)
	public String listAsCroomRecode2(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsCroomRecode> page=asCroomRecodeForm.getPage();// 获取分页对象
		AsCroomRecodeCondition condition=new AsCroomRecodeCondition();
		condition.setState(0);
		asCroomRecodeService.listAsCroomRecodeByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("urll", "listAsCroomRecode2");
		return "modules/administr/asRecodeList2";
	}
	
	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listAsCroomRecode0", method = RequestMethod.GET)
	public String listAsCroomRecode0(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsCroomRecode> page=asCroomRecodeForm.getPage();// 获取分页对象
		AsCroomRecodeCondition condition=new AsCroomRecodeCondition();
		condition.setPeopleId(UserUtils.getUser().getId());
		asCroomRecodeService.listAsCroomRecodeByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("urll", "listAsCroomRecode0");
		return "modules/administr/asRecodeList2";
	}
	
	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listCroom", method = RequestMethod.GET)
	public String listCroom(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsCroom> page=asCroomForm.getPage();// 获取分页对象
		AsCroomCondition condition=new AsCroomCondition();
		asCroomService.listAsCroomByPage(page,condition);
		model.addAttribute("page",page);
		return "modules/administr/asRecodeList";
	}

	/**
	 * 会议室申请使用记录表
	 * @return 
	 *//*
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(asCroomRecodeForm.getItem().getId())){
			AsCroomRecode item = asCroomRecodeService.getAsCroomRecodeById(asCroomRecodeForm.getItem().getId());
			model.addAttribute("item", item);
		}
		return "modules/administr/asRecodeForm";
	}*/

	/**
	 * 编辑会议室表
	 * @return 
	 */
	@RequestMapping(value = "/editCroom")
	public String editCroom(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(asCroomForm.getItem().getId())){
			AsCroom item = asCroomService.getAsCroomById(asCroomForm.getItem().getId());
			model.addAttribute("item", item);
		}
		return "modules/administr/asRecodeForm";
	}

	/**
	 * 保存会议室申请使用记录表
	 * @return 
	 */
	@RequestMapping(value = "/saveAsCroomRecode", method = RequestMethod.POST)
	public String saveAsCroomRecode(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			if(StringUtils.isBlank(asCroomRecodeForm.getItem().getId())){
				User user=UserUtils.getUser();// 获取当前用户
				AsCroomRecode item=asCroomRecodeForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(0);
				asCroomRecodeService.add(item);
			}else{
				asCroomRecodeService.update(asCroomRecodeForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存会议室申请使用记录表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/recode/listCroom";
	}
	/**
	 * 删除AsCroomRecode
	 * @return 
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			asCroomRecodeService.delByIds(asCroomRecodeForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除会议室申请使用记录表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/recode/listCroom";
	}
	
	/**
	 * 检查时间的有效性
	 * 
	 * */
	@RequestMapping(value = "/checkTime")
	public String checkTime(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		List<AsCroomRecode> listAsCroomRecode=asCroomRecodeService.listAsCroomRecode(asCroomRecodeForm.getItem().getTimeBegin(), asCroomRecodeForm.getItem().getTimeEnd());
		if (listAsCroomRecode.size()==0) {
			return renderString(response,"0");// 没有交错的时间
		}else{
			String msg="";
			for (int i = 0; i < listAsCroomRecode.size(); i++) {
				msg+=DateUtils.formatDate(listAsCroomRecode.get(i).getTimeBegin(), "yyyy-MM-dd HH:mm:ss")+"——"+DateUtils.formatDate(listAsCroomRecode.get(i).getTimeEnd(),"yyyy-MM-dd HH:mm:ss")+"\r\n";
			}
			return renderString(response,msg);// 有交错的时间
		}
	}
	/**
	 * 同意
	 * */
	@RequestMapping(value = "/updateAgree", method = RequestMethod.GET)
	public String updateAgree(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		asCroomRecodeService.updateAgree(asCroomRecodeForm.getItem().getId(), 1);
		addMessage(redirectAttributes, "申请已通过");
		return "redirect:" + adminPath + "/administr/recode/listAsCroomRecode2";
	}
	/**
	 * 不同意
	 * */
	@RequestMapping(value = "/updateNotAgree", method = RequestMethod.GET)
	public String updateNotAgree(@ModelAttribute AsCroomRecodeForm asCroomRecodeForm,HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		asCroomRecodeService.updateAgree(asCroomRecodeForm.getItem().getId(), 2);
		addMessage(redirectAttributes, "申请已作废");
		return "redirect:" + adminPath + "/administr/recode/listAsCroomRecode2";
	}
}

