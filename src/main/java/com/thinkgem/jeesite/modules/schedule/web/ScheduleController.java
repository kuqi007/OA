/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.schedule.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;
import com.thinkgem.jeesite.modules.schedule.form.OaScheduleForm;
import com.thinkgem.jeesite.modules.schedule.service.IOaScheduleService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/schedule")
public class ScheduleController extends BaseController {
	@Resource(name = "oaScheduleServiceImpl")
	private IOaScheduleService iOaScheduleService;

	// 展示首页
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute OaScheduleForm scheduleForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();// 获取当前用户
//		OaSchedule item = scheduleForm.getItem();
//		List<OaSchedule> result = iOaScheduleService.getOaScheduleByUserId(user.getId());
		// Page<WorkLeave> page=workLeaveFrom.getPage();// 获取分页对象
		// WorkLeaveCondition condition=new WorkLeaveCondition();
		// // 根据用户id 查询用户所写单据
		// condition.setCreateBy(user.getId());
		// workLeaveSrevice.listWorkLeaveByPage(page,condition);
		// model.addAttribute("result",);
		// model.addAttribute("flag", 1);//1-本人2-其他人
		return "modules/schedule/calendar";
	}

	@RequestMapping(value = "/json")
	public String json(HttpServletRequest request, HttpServletResponse response) {
		User user = UserUtils.getUser();// 获取当前用户
		List<OaSchedule> result = iOaScheduleService.getOaScheduleByUserId(user.getId());
		JSONArray json = new JSONArray();
		for (OaSchedule oaSchedule : result) {
			JSONObject jo = new JSONObject();
			jo.put("id", oaSchedule.getId());
			jo.put("title", oaSchedule.gettitle());
			jo.put("start", oaSchedule.getStartDate());
			jo.put("end", oaSchedule.getEndDate());
			json.put(jo);
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// String cc=renderString(response,result);
		return null;
	}

	// 保存
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute OaScheduleForm scheduleForm, HttpServletRequest request,
			HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		// String state=String.valueOf(workLeaveForm.getState());
		try {// 新建事件
			OaSchedule item = scheduleForm.getItem();
			User user = UserUtils.getUser();// 获取当前用户
			if (StringUtils.isBlank(item.getId())) {
				item.setId(IdGen.uuid());// 主键id
				item.setUserId(user.getId());// 创建人id
				// item.setState(1);
				// item.setFlag(0);
				iOaScheduleService.add(item);
				addMessage(redirectAttributes, "新建日程成功");
			} else {
				// 编辑事件
//				OaSchedule schedule = iOaScheduleService.getOaScheduleById(item.getId());
//				model.addAttribute("item", schedule);
				iOaScheduleService.update(item);
				addMessage(redirectAttributes, "更新成功");
			}
		} catch (Exception e) {
			String msg = "保存事件时发生异常：" + e.getMessage();
			logger.error(msg, e);
		}
		return "redirect:" + adminPath + "/schedule/index";// 根据单据状态，参看对应单据信息
	}

/*	// 编辑
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute OaScheduleForm scheduleForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String id=request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			OaSchedule item = iOaScheduleService.getOaScheduleById(id);
			model.addAttribute("item",item);
		}
		return "redirect:" + adminPath + "/schedule/index";
	}
	// 编辑
	@RequestMapping(value = "/form")
	public String form(@ModelAttribute OaScheduleForm scheduleForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String id=request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			OaSchedule item = iOaScheduleService.getOaScheduleById(id);
			model.addAttribute("item",item);
		}
		return "redirect:" + adminPath + "/schedule/index";
	}
*/
	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute OaScheduleForm scheduleForm, HttpServletRequest request,
			HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		try {
			iOaScheduleService.delByIds(scheduleForm.getItem().getId().split(","));
			addMessage(redirectAttributes, "删除成功");
		} catch (Exception e) {
			addMessage(redirectAttributes, "删除失败" + e.getMessage());
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/schedule/index";
	}
	
}
