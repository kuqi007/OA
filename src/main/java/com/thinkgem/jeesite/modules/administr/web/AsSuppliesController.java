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
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;
import com.thinkgem.jeesite.modules.administr.form.AsSuppliesForm;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/supplies")
public class AsSuppliesController extends BaseController {

	@Resource(name = "asSuppliesServiceImpl")
	private AsSuppliesService asSuppliesService;


	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listAsSuppliesByPage")
	public String listAsSuppliesByPage(@ModelAttribute AsSuppliesForm asSuppliesForm,HttpServletRequest request, HttpServletResponse response, Model model){
		Page<AsSupplies> page=asSuppliesForm.getPage();// 获取分页对象
		AsSuppliesCondition condition=asSuppliesForm.getCondition();
		asSuppliesService.listAsSuppliesByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("condition",condition);
		return "modules/administr/asSuppliesList";
	}

	/**
	 * 编辑办公用品表
	 * @return 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute AsSuppliesForm asSuppliesForm,HttpServletRequest request, HttpServletResponse response, Model model){
		if(StringUtils.isNotBlank(asSuppliesForm.getItem().getId())){
			AsSupplies item = asSuppliesService.getAsSuppliesById(asSuppliesForm.getItem().getId());
			model.addAttribute("item", item);
		}
		return "modules/administr/asSuppliesForm";
	}

	/**
	 * 保存办公用品表
	 * @return 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute AsSuppliesForm asSuppliesForm,HttpServletRequest request, HttpServletResponse response, Model model){
		try {
			if(StringUtils.isBlank(asSuppliesForm.getItem().getId())){
				User user=UserUtils.getUser();// 获取当前用户
				AsSupplies item=asSuppliesForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				asSuppliesService.add(item);
			}else{
				asSuppliesService.update(asSuppliesForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/supplies/listAsSuppliesByPage";
	}
	/**
	 * 删除AsSupplies
	 * @return 
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute AsSuppliesForm asSuppliesForm,HttpServletRequest request, HttpServletResponse response, Model model){
		try {
			asSuppliesService.delByIds(asSuppliesForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/supplies/listAsSuppliesByPage";
	}
	/**
	 * 根据id查询商品信息，返回json
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/getAsSuppliesById")
	public AsSupplies getAsSuppliesById(String id){
		AsSupplies asSupplies=asSuppliesService.getAsSuppliesById(id);
		return asSupplies;
	 }
}

