package com.thinkgem.jeesite.modules.sys.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.oa.entity.OaNotify;
import com.thinkgem.jeesite.modules.oa.service.OaNotifyService;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;
import com.thinkgem.jeesite.modules.schedule.service.IOaScheduleService;
import com.thinkgem.jeesite.modules.sys.dto.workVo;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.utils.WorkUtils;

@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/sys/index")
public class IndexController extends BaseController {
	@Autowired
	private SystemService systemService;
	@Resource(name = "oaScheduleServiceImpl")
	private IOaScheduleService iOaScheduleService;
	@Autowired
	private OaNotifyService oaNotifyService;
	/**
	 * 主页
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(User user, HttpServletResponse response, Model model) {
		User currentUser = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getName())){
//			if(Global.isDemoMode()){
//				model.addAttribute("message", "演示模式，不允许操作！");
//				return "modules/sys/userInfo";
//			}
			currentUser.setEmail(user.getEmail());
			currentUser.setPhone(user.getPhone());
			currentUser.setMobile(user.getMobile());
			currentUser.setRemarks(user.getRemarks());
			currentUser.setPhoto(user.getPhoto());
			systemService.updateUserInfo(currentUser);
			model.addAttribute("message", "保存用户信息成功");
		}
		model.addAttribute("user", currentUser);
		model.addAttribute("Global", new Global());
		
		/**当日日程 */
		List<OaSchedule> itemToday=iOaScheduleService.getOaScheduleTodayByUserId(currentUser.getId());
		if (itemToday.size()>10) {
			itemToday=itemToday.subList(0, 9);
		}
		model.addAttribute("itemToday",itemToday);
		/**近日日程 */
		List<OaSchedule> itemRecent=iOaScheduleService.getOaScheduleRecnetByUserId(currentUser.getId());
		//当前日期减10天
		/*Calendar ca=Calendar.getInstance();
		ca.setTime(new Date());
		ca.add(Calendar.DAY_OF_MONTH, -11);
		Date preTime=ca.getTime();
		ca.add(Calendar.DAY_OF_MONTH, 11);
		Date nexTime=ca.getTime();
		for (int i = 0; i < itemRecent.size(); i++) {
			if (!(itemRecent.get(i).getStartDate().after(preTime)&&itemRecent.get(i).getStartDate().before(nexTime))) {
			itemRecent.remove(i);
			}
		}*/
		if (itemRecent.size()>10) {
			itemRecent=itemRecent.subList(0, 9);
		}
	
		model.addAttribute("itemRecent",itemRecent);
		

		/**公告管理*/
		/**
		 * 未读公告
		 */
		List<OaNotify> unread=oaNotifyService.getUnreadList(UserUtils.getUser().getId());
		if (unread.size()>10) {
			unread=unread.subList(0, 9);
		}
		model.addAttribute("unread",unread);
		/**
		 * 已读公告
		 */
		List<OaNotify> read=oaNotifyService.getReadList(UserUtils.getUser().getId());
		if (read.size()>10) {
			read=read.subList(0, 9);
		}
		model.addAttribute("read",read);

		/**
		 * 所有待办工作
		 * 
		 * */
		List<List<workVo>> listworkVo=WorkUtils.listWaitWork();
		List<workVo> listworkVo2=new ArrayList<workVo>();// 待办工作
		List<workVo> listworkVo3=new ArrayList<workVo>();// 滞留工作
		
		for (int i = 0; i <listworkVo.get(0).size(); i++) {
			if (DateUtils.pastHour(listworkVo.get(0).get(i).getTime())>72) {
				/**滞留工作*/
				/*if (listworkVo3.size()>=10) {
					continue;
				}*/
				listworkVo3.add(listworkVo.get(0).get(i));
			}else{
				/**待办工作*/
				/*if (listworkVo2.size()>=10) {
					continue;
				}*/
				listworkVo2.add(listworkVo.get(0).get(i));
			}
		}
		
		/*List<workVo> listworkVo4=new ArrayList<workVo>();
		for (int i = 0; i < listworkVo.get(1).size(); i++) {
			if (listworkVo.get(1).size()==i) {
				break;
			}
			listworkVo4.add(listworkVo.get(1).get(i));
		}*/
		model.addAttribute("listworkVo2",listworkVo2);
		model.addAttribute("listworkVo3",listworkVo3);
		model.addAttribute("listworkVo4",listworkVo.get(1));
		return "modules/sys/index";
	}
	
}
