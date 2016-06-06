
package com.thinkgem.jeesite.modules.work.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.dto.workVo;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dao.WorkApplyDao;
import com.thinkgem.jeesite.modules.work.dao.WorkCostDao;
import com.thinkgem.jeesite.modules.work.dao.WorkDjustDao;
import com.thinkgem.jeesite.modules.work.dao.WorkIntegralDao;
import com.thinkgem.jeesite.modules.work.dao.WorkLeaveDao;
import com.thinkgem.jeesite.modules.work.dao.WorkLoanDao;
import com.thinkgem.jeesite.modules.work.dao.WorkOutDao;
import com.thinkgem.jeesite.modules.work.dao.WorkOvertimeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkPaymentDao;
import com.thinkgem.jeesite.modules.work.dao.WorkPaymentHrDao;
import com.thinkgem.jeesite.modules.work.dao.WorkRecruitDao;
import com.thinkgem.jeesite.modules.work.dao.WorkReimbursementDao;
import com.thinkgem.jeesite.modules.work.dao.WorkRestDao;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDao;
import com.thinkgem.jeesite.modules.work.dao.WorkTravelDao;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkOutCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkOvertimeCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentHrCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkRecruitCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkTravelCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkApply;
import com.thinkgem.jeesite.modules.work.entity.WorkCost;
import com.thinkgem.jeesite.modules.work.entity.WorkDjust;
import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.entity.WorkLoan;
import com.thinkgem.jeesite.modules.work.entity.WorkOut;
import com.thinkgem.jeesite.modules.work.entity.WorkOvertime;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;
import com.thinkgem.jeesite.modules.work.entity.WorkPaymentHr;
import com.thinkgem.jeesite.modules.work.entity.WorkRecruit;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;
import com.thinkgem.jeesite.modules.work.entity.WorkTravel;

/**
 * 我的工作工具类
 * @author songJian
 * @version 2016-03-27
 */
public class WorkUtils {
	
	private static WorkLeaveDao workLeaveDao = SpringContextHolder.getBean(WorkLeaveDao.class);
	private static WorkOutDao workOutDao = SpringContextHolder.getBean(WorkOutDao.class);
	private static WorkOvertimeDao workOvertimeDao = SpringContextHolder.getBean(WorkOvertimeDao.class);
	private static WorkPaymentDao workPaymentDao = SpringContextHolder.getBean(WorkPaymentDao.class);
	private static WorkPaymentHrDao workPaymentHrDao = SpringContextHolder.getBean(WorkPaymentHrDao.class);
	private static WorkRecruitDao workRecruitDao = SpringContextHolder.getBean(WorkRecruitDao.class);
	private static WorkReimbursementDao workReimbursementDao = SpringContextHolder.getBean(WorkReimbursementDao.class);
	private static WorkRestDao workRestDao = SpringContextHolder.getBean(WorkRestDao.class);
	private static WorkShoppingDao workShoppingDao = SpringContextHolder.getBean(WorkShoppingDao.class);
	private static WorkTravelDao workTravelDao = SpringContextHolder.getBean(WorkTravelDao.class);
	private static WorkCostDao workCostDao=SpringContextHolder.getBean(WorkCostDao.class);
	private static WorkApplyDao workApplyDao=SpringContextHolder.getBean(WorkApplyDao.class);
	private static WorkDjustDao workDjustDao=SpringContextHolder.getBean(WorkDjustDao.class);
	private static WorkIntegralDao workIntegralDao=SpringContextHolder.getBean(WorkIntegralDao.class);
	private static WorkLoanDao workLoanDao=SpringContextHolder.getBean(WorkLoanDao.class);
	/**获取当前用户的待办工作-
	 * 此方法巨长，if巨多，不要问我为什么，一开始我是拒绝的
	 * */
	public static List<List<workVo>> listWaitWork(){
		List<Menu> listMenu=UserUtils.getMenuList();
		User user=UserUtils.getUser();// 获取当前用户
		List<workVo> listWorkVo=new ArrayList<workVo>();// 待审批的
		List<workVo> listWorkVo2=new ArrayList<workVo>();// 我发起的
		for (int i = 0; i < listMenu.size(); i++) {
			// 待审工作
			String link=listMenu.get(i).getHref();
			if (link!=null && !link.equals("")) {
				String [] links=link.split("/");
				if (links[1].equals("work")) {   // 我的工作模块
					if (links[2].equals("leave")) {
						WorkLeaveCondition condition=new WorkLeaveCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkLeave> listworkLeave=workLeaveDao.listWorkLeave(condition);
							for (int j = 0; j < listworkLeave.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("请假单");
								workVo.setId(listworkLeave.get(j).getId());
								workVo.setNumber(listworkLeave.get(j).getTransaction());
								workVo.setTime(listworkLeave.get(j).getCreateDate());
								workVo.setEmergency(listworkLeave.get(j).getEmergency());
								workVo.setUrls("/work/leave/edit?item.id="+listworkLeave.get(j).getId()+"&state="+listworkLeave.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("overtime")){
						WorkOvertimeCondition condition=new WorkOvertimeCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);// 待审
							List<WorkOvertime> listWorkOvertime=workOvertimeDao.listWorkOvertime(condition);
							for (int j = 0; j < listWorkOvertime.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("加班单");
								workVo.setId(listWorkOvertime.get(j).getId());
								workVo.setNumber(listWorkOvertime.get(j).getTransaction());
								workVo.setTime(listWorkOvertime.get(j).getCreateDate());
								workVo.setEmergency(listWorkOvertime.get(j).getEmergency());
								workVo.setUrls("/work/overtime/edit?item.id="+listWorkOvertime.get(j).getId()+"&state="+listWorkOvertime.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("rest")){
						WorkRestCondition condition=new WorkRestCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);// 待审
							List<WorkRest> listworkRest=workRestDao.listWorkRest(condition);
							for (int j = 0; j < listworkRest.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("换休单");
								workVo.setId(listworkRest.get(j).getId());
								workVo.setNumber(listworkRest.get(j).getTransaction());
								workVo.setTime(listworkRest.get(j).getCreateDate());
								workVo.setEmergency(listworkRest.get(j).getEmergency());
								workVo.setUrls("/work/rest/edit?item.id="+listworkRest.get(j).getId()+"&state="+listworkRest.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("out")){
						WorkOutCondition condition=new WorkOutCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);// 待审
							List<WorkOut> listworkOut=workOutDao.listWorkOut(condition);
							for (int j = 0; j < listworkOut.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("外出单");
								workVo.setId(listworkOut.get(j).getId());
								workVo.setNumber(listworkOut.get(j).getTransaction());
								workVo.setTime(listworkOut.get(j).getCreateDate());
								workVo.setEmergency(listworkOut.get(j).getEmergency());
								workVo.setUrls("/work/out/edit?item.id="+listworkOut.get(j).getId()+"&state="+listworkOut.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("shopping")){
						WorkShoppingCondition condition=new WorkShoppingCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkShopping> listworkShopping=workShoppingDao.listWorkShopping(condition);
							for (int j = 0; j < listworkShopping.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("办公用品采购单");
								workVo.setId(listworkShopping.get(j).getId());
								workVo.setNumber(listworkShopping.get(j).getTransaction());
								workVo.setTime(listworkShopping.get(j).getCreateDate());
								workVo.setEmergency(listworkShopping.get(j).getEmergency());
								workVo.setUrls("/work/shopping/edit?item.id="+listworkShopping.get(j).getId()+"&state="+listworkShopping.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("travel")){
						WorkTravelCondition condition=new WorkTravelCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);// 待审
							List<WorkTravel> listworkTravel=workTravelDao.listWorkTravel(condition);
							for (int j = 0; j < listworkTravel.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("出差申请单");
								workVo.setId(listworkTravel.get(j).getId());
								workVo.setNumber(listworkTravel.get(j).getTransaction());
								workVo.setTime(listworkTravel.get(j).getCreateDate());
								workVo.setEmergency(listworkTravel.get(j).getEmergency());
								workVo.setUrls("/work/travel/edit?item.id="+listworkTravel.get(j).getId()+"&state="+listworkTravel.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("recruit")){
						WorkRecruitCondition condition=new WorkRecruitCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);// 待审
							List<WorkRecruit> listworkRecruit=workRecruitDao.listWorkRecruit(condition);
							for (int j = 0; j < listworkRecruit.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("招聘申请单");
								workVo.setId(listworkRecruit.get(j).getId());
								workVo.setNumber(listworkRecruit.get(j).getTransaction());
								workVo.setTime(listworkRecruit.get(j).getCreateDate());
								workVo.setEmergency(listworkRecruit.get(j).getEmergency());
								workVo.setUrls("/work/recruit/edit?item.id="+listworkRecruit.get(j).getId()+"&state="+listworkRecruit.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("reimbursement")){
						WorkReimbursementCondition condition=new WorkReimbursementCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkReimbursement> listworkReimbursement=workReimbursementDao.listWorkReimbursement(condition);
							for (int j = 0; j < listworkReimbursement.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("差旅报销单");
								workVo.setId(listworkReimbursement.get(j).getId());
								workVo.setNumber(listworkReimbursement.get(j).getTransaction());
								workVo.setTime(listworkReimbursement.get(j).getCreateDate());
								workVo.setEmergency(listworkReimbursement.get(j).getEmergency());
								workVo.setUrls("/work/reimbursement/edit?item.id="+listworkReimbursement.get(j).getId()+"&state="+listworkReimbursement.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("payment")){
						WorkPaymentCondition condition=new WorkPaymentCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkPayment> listworkPayment=workPaymentDao.listWorkPayment(condition);
							for (int j = 0; j < listworkPayment.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("付款申请单");
								workVo.setId(listworkPayment.get(j).getId());
								workVo.setNumber(listworkPayment.get(j).getTransaction());
								workVo.setTime(listworkPayment.get(j).getCreateDate());
								workVo.setEmergency(listworkPayment.get(j).getEmergency());
								workVo.setUrls("/work/payment/edit?item.id="+listworkPayment.get(j).getId()+"&state="+listworkPayment.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("paymentHr")){
						WorkPaymentHrCondition condition=new WorkPaymentHrCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkPaymentHr> listworkPayment=workPaymentHrDao.listWorkPayment(condition);
							for (int j = 0; j < listworkPayment.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("行政付款申请单");
								workVo.setId(listworkPayment.get(j).getId());
								workVo.setNumber(listworkPayment.get(j).getTransaction());
								workVo.setTime(listworkPayment.get(j).getCreateDate());
								workVo.setEmergency(listworkPayment.get(j).getEmergency());
								workVo.setUrls("/work/paymentHr/edit?item.id="+listworkPayment.get(j).getId()+"&state="+listworkPayment.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("cost")){
						WorkCostCondition condition=new WorkCostCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkCost> listworkPayment=workCostDao.listWorkCost(condition);
							for (int j = 0; j < listworkPayment.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("费用报销单");	
								workVo.setId(listworkPayment.get(j).getId());
								workVo.setNumber(listworkPayment.get(j).getTransaction());
								workVo.setTime(listworkPayment.get(j).getCreateDate());
								workVo.setEmergency(listworkPayment.get(j).getEmergency());
								workVo.setUrls("/work/cost/edit?item.id="+listworkPayment.get(j).getId()+"&state="+listworkPayment.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
						
					}else if(links[2].equals("apply")){
						WorkApplyCondition condition=new WorkApplyCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkApply> listworkApply=workApplyDao.listWorkApply(condition);
							for (int j = 0; j < listworkApply.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("办公用品申领单");
								workVo.setId(listworkApply.get(j).getId());
								workVo.setNumber(listworkApply.get(j).getTransaction());
								workVo.setTime(listworkApply.get(j).getCreateDate());
								workVo.setEmergency(listworkApply.get(j).getEmergency());
								workVo.setUrls("/work/apply/edit?item.id="+listworkApply.get(j).getId()+"&state="+listworkApply.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("djust")){
						WorkDjustCondition condition=new WorkDjustCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkDjust> listworkDjuat=workDjustDao.listWorkDjust(condition);
							for (int j = 0; j < listworkDjuat.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("价格调整审批单");
								workVo.setId(listworkDjuat.get(j).getId());
								workVo.setNumber(listworkDjuat.get(j).getTransaction());
								workVo.setTime(listworkDjuat.get(j).getCreateDate());
								workVo.setEmergency(listworkDjuat.get(j).getEmergency());
								workVo.setUrls("/work/djust/edit?item.id="+listworkDjuat.get(j).getId()+"&state="+listworkDjuat.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("integral")){
						WorkIntegralCondition condition=new WorkIntegralCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkIntegral> listworkIntegral=workIntegralDao.listWorkIntegral(condition);
							for (int j = 0; j < listworkIntegral.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("积分撤销申请单");
								workVo.setId(listworkIntegral.get(j).getId());
								workVo.setNumber(listworkIntegral.get(j).getTransaction());
								workVo.setTime(listworkIntegral.get(j).getCreateDate());
								workVo.setEmergency(listworkIntegral.get(j).getEmergency());
								workVo.setUrls("/work/integral/edit?item.id="+listworkIntegral.get(j).getId()+"&state="+listworkIntegral.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}else if(links[2].equals("loan")){
						WorkLoanCondition condition=new WorkLoanCondition();
						if (links[3].equals("list")) {
							condition.setExamination(user.getRoleList().get(0).getId());
							condition.setFlag(0);
							List<WorkLoan> listworkLoan=workLoanDao.listWorkLoan(condition);
							for (int j = 0; j < listworkLoan.size(); j++) {
								workVo workVo=new workVo();
								workVo.setBillType("借款申请单");
								workVo.setId(listworkLoan.get(j).getId());
								workVo.setNumber(listworkLoan.get(j).getTransaction());
								workVo.setTime(listworkLoan.get(j).getCreateDate());
								workVo.setEmergency(listworkLoan.get(j).getEmergency());
								workVo.setUrls("/work/loan/edit?item.id="+listworkLoan.get(j).getId()+"&state="+listworkLoan.get(j).getState());
								listWorkVo.add(workVo);
							}
						}
					}
				}
			}
		}
		
		// 获取当前登录用户id
		String uid=UserUtils.getUser().getId();
		
		WorkLeaveCondition condition=new WorkLeaveCondition();
		condition.setCreateBy(uid);
		condition.setFlag(0);
		List<WorkLeave> listworkLeave2=workLeaveDao.listWorkLeave(condition);
		for (int j = 0; j < listworkLeave2.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("请假单");
			workVo.setId(listworkLeave2.get(j).getId());
			workVo.setNumber(listworkLeave2.get(j).getTransaction());
			workVo.setTime(listworkLeave2.get(j).getCreateDate());
			workVo.setEmergency(listworkLeave2.get(j).getEmergency());
			workVo.setUrls("/work/leave/edit?item.id="+listworkLeave2.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkOvertimeCondition condition2=new WorkOvertimeCondition();
		condition2.setCreateBy(uid);
		condition2.setFlag(0);
		List<WorkOvertime> listWorkOvertime=workOvertimeDao.listWorkOvertime(condition2);
		for (int j = 0; j < listWorkOvertime.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("加班单");
			workVo.setId(listWorkOvertime.get(j).getId());
			workVo.setNumber(listWorkOvertime.get(j).getTransaction());
			workVo.setTime(listWorkOvertime.get(j).getCreateDate());
			workVo.setEmergency(listWorkOvertime.get(j).getEmergency());
			workVo.setUrls("/work/overtime/edit?item.id="+listWorkOvertime.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkRestCondition condition3=new WorkRestCondition();
		condition3.setCreateBy(uid);
		condition3.setFlag(0);
		List<WorkRest> listWorkRest=workRestDao.listWorkRest(condition3);
		for (int j = 0; j < listWorkRest.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("换休单");
			workVo.setId(listWorkRest.get(j).getId());
			workVo.setNumber(listWorkRest.get(j).getTransaction());
			workVo.setTime(listWorkRest.get(j).getCreateDate());
			workVo.setEmergency(listWorkRest.get(j).getEmergency());
			workVo.setUrls("/work/rest/edit?item.id="+listWorkRest.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkOutCondition condition4=new WorkOutCondition();
		condition4.setCreateBy(uid);
		condition4.setFlag(0);
		List<WorkOut> listWorkOut=workOutDao.listWorkOut(condition4);
		for (int j = 0; j < listWorkOut.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("外出单");
			workVo.setId(listWorkOut.get(j).getId());
			workVo.setNumber(listWorkOut.get(j).getTransaction());
			workVo.setTime(listWorkOut.get(j).getCreateDate());
			workVo.setEmergency(listWorkOut.get(j).getEmergency());
			workVo.setUrls("/work/out/edit?item.id="+listWorkOut.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkShoppingCondition condition5=new WorkShoppingCondition();
		condition5.setCreateBy(uid);
		condition5.setFlag(0);
		List<WorkShopping> listWorkShopping=workShoppingDao.listWorkShopping(condition5);
		for (int j = 0; j < listWorkShopping.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("采购单");
			workVo.setId(listWorkShopping.get(j).getId());
			workVo.setNumber(listWorkShopping.get(j).getTransaction());
			workVo.setTime(listWorkShopping.get(j).getCreateDate());
			workVo.setEmergency(listWorkShopping.get(j).getEmergency());
			workVo.setUrls("/work/shopping/edit?item.id="+listWorkShopping.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkTravelCondition condition6=new WorkTravelCondition();
		condition6.setCreateBy(uid);
		condition6.setFlag(0);
		List<WorkTravel> listWorkTravel=workTravelDao.listWorkTravel(condition6);
		for (int j = 0; j < listWorkTravel.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("出差申请单");
			workVo.setId(listWorkTravel.get(j).getId());
			workVo.setNumber(listWorkTravel.get(j).getTransaction());
			workVo.setTime(listWorkTravel.get(j).getCreateDate());
			workVo.setEmergency(listWorkTravel.get(j).getEmergency());
			workVo.setUrls("/work/travel/edit?item.id="+listWorkTravel.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkRecruitCondition condition7=new WorkRecruitCondition();
		condition7.setCreateBy(uid);
		condition7.setFlag(0);
		List<WorkRecruit> listWorkRecruit=workRecruitDao.listWorkRecruit(condition7);
		for (int j = 0; j < listWorkRecruit.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("招聘申请单");
			workVo.setId(listWorkRecruit.get(j).getId());
			workVo.setNumber(listWorkRecruit.get(j).getTransaction());
			workVo.setTime(listWorkRecruit.get(j).getCreateDate());
			workVo.setEmergency(listWorkRecruit.get(j).getEmergency());
			workVo.setUrls("/work/recruit/edit?item.id="+listWorkRecruit.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkReimbursementCondition condition8=new WorkReimbursementCondition();
		condition8.setCreateBy(uid);
		condition8.setFlag(0);
		List<WorkReimbursement> listWorkReimbursement=workReimbursementDao.listWorkReimbursement(condition8);
		for (int j = 0; j < listWorkReimbursement.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("差旅报销单");
			workVo.setId(listWorkReimbursement.get(j).getId());
			workVo.setNumber(listWorkReimbursement.get(j).getTransaction());
			workVo.setTime(listWorkReimbursement.get(j).getCreateDate());
			workVo.setEmergency(listWorkReimbursement.get(j).getEmergency());
			workVo.setUrls("/work/reimbursement/edit?item.id="+listWorkReimbursement.get(j).getId()+"&state=7");
			listWorkVo2.add(workVo);
		}
		WorkPaymentCondition condition9=new WorkPaymentCondition();
		condition9.setCreateBy(uid);
		condition9.setFlag(0);
		List<WorkPayment> listWorkPayment=workPaymentDao.listWorkPayment(condition9);
		for (int j = 0; j < listWorkPayment.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("付款申请单");
			workVo.setId(listWorkPayment.get(j).getId());
			workVo.setNumber(listWorkPayment.get(j).getTransaction());
			workVo.setTime(listWorkPayment.get(j).getCreateDate());
			workVo.setEmergency(listWorkPayment.get(j).getEmergency());
			workVo.setUrls("/work/payment/edit?item.id="+listWorkPayment.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		
		WorkPaymentHrCondition condition99=new WorkPaymentHrCondition();
		condition99.setCreateBy(uid);
		condition99.setFlag(0);
		List<WorkPaymentHr> listWorkPaymentHr=workPaymentHrDao.listWorkPayment(condition99);
		for (int j = 0; j < listWorkPaymentHr.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("行政付款申请单");
			workVo.setId(listWorkPaymentHr.get(j).getId());
			workVo.setNumber(listWorkPaymentHr.get(j).getTransaction());
			workVo.setTime(listWorkPaymentHr.get(j).getCreateDate());
			workVo.setEmergency(listWorkPaymentHr.get(j).getEmergency());
			workVo.setUrls("/work/paymentHr/edit?item.id="+listWorkPaymentHr.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		
		WorkCostCondition condition10=new WorkCostCondition();
		condition10.setCreateBy(uid);
		condition10.setFlag(0);
		List<WorkCost> listWorkCost=workCostDao.listWorkCost(condition10);
		for (int j = 0; j < listWorkCost.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("费用报销单");
			workVo.setId(listWorkCost.get(j).getId());
			workVo.setNumber(listWorkCost.get(j).getTransaction());
			workVo.setTime(listWorkCost.get(j).getCreateDate());
			workVo.setEmergency(listWorkCost.get(j).getEmergency());
			workVo.setUrls("/work/cost/edit?item.id="+listWorkCost.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		
		WorkApplyCondition condition11=new WorkApplyCondition();
		condition11.setCreateBy(uid);
		condition11.setFlag(0);
		List<WorkApply> listWorkApply=workApplyDao.listWorkApply(condition11);
		for (int j = 0; j < listWorkApply.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("办公用品申领单");
			workVo.setId(listWorkApply.get(j).getId());
			workVo.setNumber(listWorkApply.get(j).getTransaction());
			workVo.setTime(listWorkApply.get(j).getCreateDate());
			workVo.setEmergency(listWorkApply.get(j).getEmergency());
			workVo.setUrls("/work/apply/edit?item.id="+listWorkApply.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkDjustCondition condition12=new WorkDjustCondition();
		condition12.setCreateBy(uid);
		condition12.setFlag(0);
		List<WorkDjust> listWorkDjust=workDjustDao.listWorkDjust(condition12);
		for (int j = 0; j < listWorkDjust.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("价格调整审批单");
			workVo.setId(listWorkDjust.get(j).getId());
			workVo.setNumber(listWorkDjust.get(j).getTransaction());
			workVo.setTime(listWorkDjust.get(j).getCreateDate());
			workVo.setEmergency(listWorkDjust.get(j).getEmergency());
			workVo.setUrls("/work/djust/edit?item.id="+listWorkDjust.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkIntegralCondition condition13=new WorkIntegralCondition();
		condition13.setCreateBy(uid);
		condition13.setFlag(0);
		List<WorkIntegral> listworkIntegral=workIntegralDao.listWorkIntegral(condition13);
		for (int j = 0; j < listworkIntegral.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("积分撤销申请单");
			workVo.setId(listworkIntegral.get(j).getId());
			workVo.setNumber(listworkIntegral.get(j).getTransaction());
			workVo.setTime(listworkIntegral.get(j).getCreateDate());
			workVo.setEmergency(listworkIntegral.get(j).getEmergency());
			workVo.setUrls("/work/integral/edit?item.id="+listworkIntegral.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		WorkLoanCondition condition14=new WorkLoanCondition();
		condition14.setCreateBy(uid);
		condition14.setFlag(0);
		List<WorkLoan> listworkLoan=workLoanDao.listWorkLoan(condition14);
		for (int j = 0; j < listworkLoan.size(); j++) {
			workVo workVo=new workVo();
			workVo.setBillType("借款申请单");
			workVo.setId(listworkLoan.get(j).getId());
			workVo.setNumber(listworkLoan.get(j).getTransaction());
			workVo.setTime(listworkLoan.get(j).getCreateDate());
			workVo.setEmergency(listworkLoan.get(j).getEmergency());
			workVo.setUrls("/work/loan/edit?item.id="+listworkLoan.get(j).getId()+"&state=6");
			listWorkVo2.add(workVo);
		}
		
		List<List<workVo>> xx=new ArrayList<List<workVo>>();
		xx.add(listWorkVo);// 待审单据
		xx.add(listWorkVo2);// 我的关注
		return xx;
	}
    /** 
     * 根据图片类型，取得对应的图片类型代码 
     * @param picType 
     * @return int 
     */  
    public static int getPictureType(String picType){  
        int res = HSSFWorkbook.PICTURE_TYPE_PICT;  
        if(picType != null){  
            if(picType.equalsIgnoreCase("png")){  
                res = HSSFWorkbook.PICTURE_TYPE_PNG;  
            }else if(picType.equalsIgnoreCase("dib")){  
                res = HSSFWorkbook.PICTURE_TYPE_DIB;  
            }else if(picType.equalsIgnoreCase("emf")){  
                res = HSSFWorkbook.PICTURE_TYPE_EMF;  
            }else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){  
                res = HSSFWorkbook.PICTURE_TYPE_JPEG;  
            }else if(picType.equalsIgnoreCase("wmf")){  
                res = HSSFWorkbook.PICTURE_TYPE_WMF;  
            }  
        }  
        return res;  
    } 
}
