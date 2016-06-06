package com.thinkgem.jeesite.modules.checkin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckrealCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckreal;
import com.thinkgem.jeesite.modules.checkin.form.OaCheckrealForm;
import com.thinkgem.jeesite.modules.checkin.service.IOaCheckrealService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller("oaCheckrealController")
@Scope("prototype")
@RequestMapping("${adminPath}/checkreal")
public class OaCheckrealController extends BaseController {

	@Resource(name = "oaCheckrealServiceImpl")
	private IOaCheckrealService oaCheckrealService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "modules/checkin/checkReal";
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckrealByPage")
	public String listOaCheckrealByPage(@ModelAttribute OaCheckrealForm oaCheckrealForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			Page<OaCheckreal> page = oaCheckrealForm.getPage();
			OaCheckrealCondition oaCheckrealCondition = oaCheckrealForm.getCondition();
			// 设置默认时间范围，默认当前月
			if (oaCheckrealCondition.getBeginDate() == null) {
				oaCheckrealCondition.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
			}
			if (oaCheckrealCondition.getEndDate() == null) {
				oaCheckrealCondition.setEndDate(DateUtils.addMonths(oaCheckrealCondition.getBeginDate(), 1));
			}
			oaCheckrealService.listOaCheckrealByPage(page, oaCheckrealCondition);
			Date lateAM=DateUtils.parseDate("1970-01-01 09:00:59");
			Date earlyPM=DateUtils.parseDate("1970-01-01 18:00:00");
			model.addAttribute("lateAM", lateAM);
			model.addAttribute("earlyPM", earlyPM);
			model.addAttribute("page", page);
			model.addAttribute("condition", oaCheckrealCondition);
		} catch (Exception ex) {
			String msg = "查询上下班签到签退表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkReal";
	}
	/**
	 * 个人分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckrealMeByPage")
	public String listOaCheckrealMeByPage(@ModelAttribute OaCheckrealForm oaCheckrealForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			Page<OaCheckreal> page = oaCheckrealForm.getPage();
			OaCheckrealCondition oaCheckrealCondition = oaCheckrealForm.getCondition();
			// 设置默认时间范围，默认昨天
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-1 );
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			if (oaCheckrealCondition.getBeginDate() == null) {
				oaCheckrealCondition.setBeginDate(c.getTime());
			}
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+1 );
			if (oaCheckrealCondition.getEndDate() == null) {
				oaCheckrealCondition.setEndDate(c.getTime());
			}
			oaCheckrealCondition.setUser(UserUtils.getUser());;
			oaCheckrealService.listOaCheckrealByPage(page, oaCheckrealCondition);
			Date lateAM=DateUtils.parseDate("1970-01-01 09:00:59");
			Date earlyPM=DateUtils.parseDate("1970-01-01 18:00:00");
			model.addAttribute("lateAM", lateAM);
			model.addAttribute("earlyPM", earlyPM);
			model.addAttribute("page", page);
			model.addAttribute("condition", oaCheckrealCondition);
			model.addAttribute("url", "listOaCheckrealMeByPage");
		} catch (Exception ex) {
			String msg = "查询上下班签到签退表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkRealMe";
	}
	/**
	 * 个人分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOaCheckrealDepartmentByPage")
	public String listOaCheckrealDepartmentByPage(@ModelAttribute OaCheckrealForm oaCheckrealForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			Page<OaCheckreal> page = oaCheckrealForm.getPage();
			OaCheckrealCondition oaCheckrealCondition = oaCheckrealForm.getCondition();
			// 设置默认时间范围，默认昨天
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) );
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			if (oaCheckrealCondition.getBeginDate() == null) {
				oaCheckrealCondition.setBeginDate(c.getTime());
			}
			//c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+1 );
			if (oaCheckrealCondition.getEndDate() == null) {
				oaCheckrealCondition.setEndDate(c.getTime());
			}
			oaCheckrealCondition.setOffice(UserUtils.getUser().getOffice());;
			oaCheckrealService.listOaCheckrealByPage(page, oaCheckrealCondition);
			Date lateAM=DateUtils.parseDate("1970-01-01 09:00:59");
			Date earlyPM=DateUtils.parseDate("1970-01-01 18:00:00");
			model.addAttribute("lateAM", lateAM);
			model.addAttribute("earlyPM", earlyPM);
			model.addAttribute("page", page);
			model.addAttribute("condition", oaCheckrealCondition);
			model.addAttribute("url", "listOaCheckrealDepartmentByPage");
		} catch (Exception ex) {
			String msg = "查询上下班签到签退表时发生异常：" + ex.getMessage();
			logger.error(msg, ex);
		}
		return "modules/checkin/checkRealMe";
	}

}
