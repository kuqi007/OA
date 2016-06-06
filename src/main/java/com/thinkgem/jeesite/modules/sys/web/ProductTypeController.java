package com.thinkgem.jeesite.modules.sys.web;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.dto.ProductTypeCondition;
import com.thinkgem.jeesite.modules.sys.entity.ProductType;
import com.thinkgem.jeesite.modules.sys.form.ProductTypeForm;
import com.thinkgem.jeesite.modules.sys.service.ProductTypeService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/sys/product")
public class ProductTypeController extends BaseController {

	@Resource(name = "productTypeServiceImpl")
	private ProductTypeService productTypeService;


	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/list")
	public String list(@ModelAttribute ProductTypeForm productTypeForm,HttpServletRequest request,HttpServletResponse response,Model model){
			Page<ProductType> page=productTypeForm.getPage();// 获取分页对象
			ProductTypeCondition condition=new ProductTypeCondition();
			productTypeService.listProductTypeByPage(page,condition);
			model.addAttribute("page",page);
			return "modules/sys/productTypeList";
	}

	/**
	 * 编辑办公用品类型表
	 * @return 
	 */
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute ProductTypeForm productTypeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(productTypeForm.getItem().getId())){
			model.addAttribute("item", productTypeService.getProductTypeById(productTypeForm.getItem().getId()));
		}
		model.addAttribute("listProductType", productTypeService.listProductType("0"));
		model.addAttribute("state", productTypeForm.getState());
		return "modules/sys/productTypeForm";
	}

	/**
	 * 保存办公用品类型表
	 * @return 
	 */
	@RequestMapping(value = "/saveProductType")
	public String saveProductType(@ModelAttribute ProductTypeForm productTypeForm,HttpServletRequest request,Model model){
		try {
			if(StringUtils.isBlank(productTypeForm.getItem().getId())){
				productTypeForm.getItem().setId(IdGen.uuid());// 主键id
				productTypeForm.getItem().setCreateBy(UserUtils.getUser().getId());// 创建人id
				productTypeService.add(productTypeForm.getItem());
			}else{
				productTypeService.update(productTypeForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存办公用品类型表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/sys/product/list";
	}
	/**
	 * 删除ProductType
	 * @return 
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute ProductTypeForm productTypeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			productTypeService.delByIds(productTypeForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除办公用品类型表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/sys/product/list";
	}
	/**
	 * 获取类型
	 * @return json
	 */
	@RequestMapping(value = "/listProductType")
	public String listProductType(@ModelAttribute ProductTypeForm productTypeForm,HttpServletRequest request,HttpServletResponse response,Model model){
		return renderString(response,productTypeService.listProductType(productTypeForm.getItem().getUpper()));
	}
}

