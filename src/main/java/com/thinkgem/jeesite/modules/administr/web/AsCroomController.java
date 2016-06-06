package com.thinkgem.jeesite.modules.administr.web;


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

import com.thinkgem.jeesite.modules.administr.form.AsCroomForm;
import com.thinkgem.jeesite.modules.administr.service.AsCroomService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsCroom;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/croom")
public class AsCroomController extends BaseController {

	@Resource(name = "asCroomServiceImpl")
	private AsCroomService asCroomService;

	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listAsCroomByPage", method = RequestMethod.GET)
	public String listAsCroomByPage(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsCroom> page=asCroomForm.getPage();// 获取分页对象
		AsCroomCondition condition=new AsCroomCondition();
		asCroomService.listAsCroomByPage(page,condition);
		model.addAttribute("page",page);
		return "modules/administr/asCroomList";
	}

	/**
	 * 编辑会议室表
	 * @return 
	 */
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(asCroomForm.getItem().getId())){
			AsCroom item = asCroomService.getAsCroomById(asCroomForm.getItem().getId());
			model.addAttribute("item", item);
		}
		return "modules/administr/asCroomForm";
	}

	/**
	 * 保存会议室表
	 * @return 
	 */
	@RequestMapping(value = "/saveAsCroom", method = RequestMethod.POST)
	public String saveAsCroom(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			if(StringUtils.isBlank(asCroomForm.getItem().getId())){
				User user=UserUtils.getUser();// 获取当前用户
				AsCroom item=asCroomForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				asCroomService.add(item);
			}else{
				asCroomService.update(asCroomForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存会议室表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/croom/listAsCroomByPage";
	}
	/**
	 * 删除AsCroom
	 * @return 
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(@ModelAttribute AsCroomForm asCroomForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			asCroomService.delByIds(asCroomForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除会议室表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/croom/listAsCroomByPage";
	}

}

