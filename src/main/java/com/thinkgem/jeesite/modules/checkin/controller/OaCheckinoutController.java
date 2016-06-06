package com.thinkgem.jeesite.modules.checkin.controller;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckinoutCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckinout;
import com.thinkgem.jeesite.modules.checkin.form.OaCheckinoutForm;
import com.thinkgem.jeesite.modules.checkin.service.IOaCheckinoutService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller("oaCheckinoutController")
@Scope("prototype")
@RequestMapping("${adminPath}/checkin")
public class OaCheckinoutController extends BaseController {

	@Resource(name = "oaCheckinoutServiceImpl")
	private IOaCheckinoutService oaCheckinoutService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "modules/checkin/checkinoutList";
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckinoutByPage")
	public String listOaCheckinoutByPage(@ModelAttribute OaCheckinoutForm oaCheckinoutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			Page<OaCheckinout> page = oaCheckinoutForm.getPage();
			OaCheckinoutCondition checkinoutCondition = oaCheckinoutForm.getCondition();
			// 设置默认时间范围，默认当前月
			if (checkinoutCondition.getBeginDate() == null) {
				checkinoutCondition.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
			}
			if (checkinoutCondition.getEndDate() == null) {
				checkinoutCondition.setEndDate(DateUtils.addMonths(checkinoutCondition.getBeginDate(), 1));
			}
			oaCheckinoutService.listOaCheckinoutByPage(page, checkinoutCondition);
			model.addAttribute("page", page);
			model.addAttribute("condition", checkinoutCondition);
			// JSONObject root = toPageJson(model.getPageResult(), new
			// String[]{"id","userNo","userId","checktime","verifycode","updateTime"});
			// ajaxPageResult(root,response);
		} catch (Exception ex) {
			String msg = "查询考勤登记表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkinoutList";
	}

	/**
	 * 个人考勤记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckinoutMeByPage")
	public String listOaCheckinoutMeByPage(@ModelAttribute OaCheckinoutForm oaCheckinoutForm,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			Page<OaCheckinout> page = oaCheckinoutForm.getPage();
			OaCheckinoutCondition checkinoutCondition = oaCheckinoutForm.getCondition();
			// 设置默认时间范围，默认当前月
			// if (checkinoutCondition.getBeginDate()==null) {
			// checkinoutCondition.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()),
			// 1));
			// }
			// if (checkinoutCondition.getEndDate()==null) {
			// checkinoutCondition.setEndDate(DateUtils.addMonths(checkinoutCondition.getBeginDate(),
			// 1));
			// }
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 5);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			if (checkinoutCondition.getBeginDate() == null) {
				checkinoutCondition.setBeginDate(c.getTime());
			}
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
			c.set(Calendar.HOUR_OF_DAY, 5);
			if (checkinoutCondition.getEndDate() == null) {
				checkinoutCondition.setEndDate(c.getTime());
			}
			checkinoutCondition.setUserName(UserUtils.getUser().getName());
			checkinoutCondition.setUserNo(UserUtils.getUser().getNo());
			oaCheckinoutService.listOaCheckinoutByPageMe(page, checkinoutCondition);
			model.addAttribute("page", page);
			model.addAttribute("condition", checkinoutCondition);
			model.addAttribute("url", "listOaCheckinoutMeByPage");
			// JSONObject root = toPageJson(model.getPageResult(), new
			// String[]{"id","userNo","userId","checktime","verifycode","updateTime"});
			// ajaxPageResult(root,response);
		} catch (Exception ex) {
			String msg = "查询考勤登记表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkinoutListMe";
	}
	/**
	 * 部门考勤记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckinoutDepartmentByPage")
	public String listOaCheckinoutDepartmentByPage(@ModelAttribute OaCheckinoutForm oaCheckinoutForm,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			Page<OaCheckinout> page = oaCheckinoutForm.getPage();
			OaCheckinoutCondition checkinoutCondition = oaCheckinoutForm.getCondition();
			// 设置默认时间范围，默认当前月
			// if (checkinoutCondition.getBeginDate()==null) {
			// checkinoutCondition.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()),
			// 1));
			// }
			// if (checkinoutCondition.getEndDate()==null) {
			// checkinoutCondition.setEndDate(DateUtils.addMonths(checkinoutCondition.getBeginDate(),
			// 1));
			// }
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 5);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			if (checkinoutCondition.getBeginDate() == null) {
				checkinoutCondition.setBeginDate(c.getTime());
			}
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
			c.set(Calendar.HOUR_OF_DAY, 5);
			if (checkinoutCondition.getEndDate() == null) {
				checkinoutCondition.setEndDate(c.getTime());
			}
			checkinoutCondition.setOffice(UserUtils.getUser().getOffice());
			oaCheckinoutService.listOaCheckinoutByPageMe(page, checkinoutCondition);
			model.addAttribute("page", page);
			model.addAttribute("condition", checkinoutCondition);
			model.addAttribute("url", "listOaCheckinoutDepartmentByPage");
			// JSONObject root = toPageJson(model.getPageResult(), new
			// String[]{"id","userNo","userId","checktime","verifycode","updateTime"});
			// ajaxPageResult(root,response);
		} catch (Exception ex) {
			String msg = "查询考勤登记表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkinoutListMe";
	}

}
