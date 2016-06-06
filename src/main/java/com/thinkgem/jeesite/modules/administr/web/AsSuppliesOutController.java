package com.thinkgem.jeesite.modules.administr.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesOutCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesOut;
import com.thinkgem.jeesite.modules.administr.form.AsSuppliesOutForm;
import com.thinkgem.jeesite.modules.administr.service.AsOutDetailsService;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesOutService;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 办公用品出库记录
 * 
 * @create-time 2016/4/7 9:48:39
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/suppliesOut")
public class AsSuppliesOutController extends BaseController {

	@Resource(name = "asSuppliesOutServiceImpl")
	private AsSuppliesOutService asSuppliesOutService;
	@Resource(name = "asOutDetailsServiceImpl")
	private AsOutDetailsService asOutDetailsService;
	@Resource(name = "asSuppliesServiceImpl")
	private AsSuppliesService asSuppliesService;
	@Autowired
	private SystemService systemService;

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listAsSuppliesOutByPage")
	public String listAsSuppliesOutByPage(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AsSuppliesOut> page = asSuppliesOutForm.getPage();// 获取分页对象
		AsSuppliesOutCondition condition = new AsSuppliesOutCondition();
		asSuppliesOutService.listAsSuppliesOutByPage(page, condition);
		model.addAttribute("page", page);
		model.addAttribute("urll", "listAsSuppliesOutByPage");
		return "modules/administr/asSuppliesOutList";
	}

	/**
	 * 根据权限分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listAsSuppliesOutByPageClassfied")
	public String listAsSuppliesOutByPageClassfied(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AsSuppliesOut> page = asSuppliesOutForm.getPage();// 获取分页对象
		AsSuppliesOutCondition condition = new AsSuppliesOutCondition();
		condition.setState(1);
		if (("1").equals(UserUtils.getUser().getUserType())) {
			asSuppliesOutService.listAsSuppliesOutByPage(page, condition);
		} else {
			asSuppliesOutService.listAsSuppliesOutByPageClassfied(page, condition);
		}
		model.addAttribute("page", page);
		model.addAttribute("urll", "listAsSuppliesOutByPageClassfied");
		return "modules/administr/asSuppliesOutListClassfied";
	}

	/**
	 * 分页查询（待签收）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listAsSuppliesOut0")
	public String listAsSuppliesOut1(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<AsSuppliesOut> page = asSuppliesOutForm.getPage();// 获取分页对象
		AsSuppliesOutCondition condition = new AsSuppliesOutCondition();
		condition.setPeopleId(UserUtils.getUser().getId());
		condition.setState(0);
		asSuppliesOutService.listAsSuppliesOutByPage(page, condition);
		model.addAttribute("page", page);
		model.addAttribute("urll", "listAsSuppliesOut0");
		return "modules/administr/asSuppliesOutList";
	}

	/**
	 * 分页查询（已签收）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listAsSuppliesOut1")
	public String listAsSuppliesOut2(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<AsSuppliesOut> page = asSuppliesOutForm.getPage();// 获取分页对象
		AsSuppliesOutCondition condition = new AsSuppliesOutCondition();
		condition.setPeopleId(UserUtils.getUser().getId());
		condition.setState(1);
		asSuppliesOutService.listAsSuppliesOutByPage(page, condition);
		model.addAttribute("page", page);
		model.addAttribute("urll", "listAsSuppliesOut1");
		return "modules/administr/asSuppliesOutList";
	}

	/**
	 * 编辑办公用品出库记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if (StringUtils.isNotBlank(asSuppliesOutForm.getItem().getId())) {
			AsSuppliesOut item = asSuppliesOutService.getAsSuppliesOutById(asSuppliesOutForm.getItem().getId());
			model.addAttribute("item", item);
			// 用品详情列表
			List<AsOutDetails> list = asOutDetailsService.listAsOutDetails(item.getId());
			model.addAttribute("list", list);
			// 签收人部门
			User use = systemService.getUser(item.getPeopleId());
			model.addAttribute("officeId", use.getOffice().getId());
			model.addAttribute("addFlag", 0);// 查看
		} else {
			model.addAttribute("addFlag", 1);// 添加
		}
		model.addAttribute("urll", asSuppliesOutForm.getUrlFlag());
		if (asSuppliesOutForm.getUrlFlag().equals("listAsSuppliesOut0")) {
			model.addAttribute("sign", "sign");// 签收
		}
		return "modules/administr/asSuppliesOutForm";
	}

	/**
	 * 签收
	 * 
	 * @return
	 */
	@RequestMapping(value = "/savesign", method = RequestMethod.POST)
	public String savesign(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		asSuppliesOutService.updateSign(asSuppliesOutForm.getItem().getId(), 1);
		return "redirect:" + adminPath + "/administr/suppliesOut/listAsSuppliesOut0";// 跳回待签收
	}

	/**
	 * 保存办公用品出库记录
	 * 
	 * @return
	 */
	@Transactional(value = "transactionManager")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAsSuppliesOut(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			if (StringUtils.isBlank(asSuppliesOutForm.getItem().getId())) {
				User user = UserUtils.getUser();// 获取当前用户
				AsSuppliesOut item = asSuppliesOutForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				item.setState(0);
				// 添加商品详情
				String[] mode = asSuppliesOutForm.getProducts().split(",");
				asSuppliesService.updateSuppliesNum(mode, item.getId());
				asSuppliesOutService.add(item);
			} else {
				asSuppliesOutService.update(asSuppliesOutForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存记录时发生异常：" + e.getMessage();
			logger.error(msg, e);
		}
		return "redirect:" + adminPath + "/administr/suppliesOut/listAsSuppliesOutByPage";
	}

	/**
	 * 删除办公用品出库记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute AsSuppliesOutForm asSuppliesOutForm, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			asSuppliesOutService.delByIds(asSuppliesOutForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除时发生异常：" + e.getMessage();
			logger.error(msg, e);
		}
		return "redirect:" + adminPath + "/administr/suppliesOut/" + asSuppliesOutForm.getUrlFlag();
	}

	/**
	 * 查询类别下的商品，返回json
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "listSuppliesByType")
	public List<Map<String, Object>> listSuppliesByType(String typeId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<AsSupplies> list = asSuppliesService.listAsSuppliesByType(typeId);
		for (int i = 0; i < list.size(); i++) {
			AsSupplies e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("num", e.getNum());
			map.put("name", e.getName());
			map.put("company", e.getCompany());
			mapList.add(map);
		}
		return mapList;
	}
}