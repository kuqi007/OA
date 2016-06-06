package com.thinkgem.jeesite.modules.administr.web;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thinkgem.jeesite.modules.administr.form.AsAssetsForm;
import com.thinkgem.jeesite.modules.administr.service.AsAssetsService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsAssetsCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsAssets;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/assets")
public class AsAssetsController extends BaseController {

	@Resource(name = "asAssetsServiceImpl")
	private AsAssetsService asAssetsService;

	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listAsAssetsByPage")
	public String listAsAssetsByPage(@ModelAttribute AsAssetsForm asAssetsForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsAssets> page=asAssetsForm.getPage();// 获取分页对象
		AsAssetsCondition condition=asAssetsForm.getCondition();
		asAssetsService.listAsAssetsByPage(page,condition);
		model.addAttribute("page",page);
		model.addAttribute("condition", condition);
		return "modules/administr/asAssetsList";
	}

	/**
	 * 保存固定资产表
	 * @return 
	 */
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute AsAssetsForm asAssetsForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(asAssetsForm.getItem().getId())){
			AsAssets item = asAssetsService.getAsAssetsById(asAssetsForm.getItem().getId());
			model.addAttribute("item", item);
		}
		return "modules/administr/asAssetsForm";
	}

	/**
	 * 保存固定资产表
	 * @return 
	 */
	@RequestMapping(value = "/saveAsAssets")
	public String saveAsAssets(@ModelAttribute AsAssetsForm asAssetsForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			if(StringUtils.isBlank(asAssetsForm.getItem().getId())){
				User user=UserUtils.getUser();// 获取当前用户
				AsAssets item=asAssetsForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				asAssetsService.add(item);
			}else{
				asAssetsService.update(asAssetsForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存固定资产表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/assets/listAsAssetsByPage";
	}
	/**
	 * 删除AsAssets
	 * @return 
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute AsAssetsForm asAssetsForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			asAssetsService.delByIds(asAssetsForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除固定资产表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/assets/listAsAssetsByPage";
	}
	/**
	 * 检查是否有从复编号
	 * 
	 */
	@RequestMapping(value = "/selectCheck")
	public String selectCheck(@Param("number")String number,HttpServletRequest request,HttpServletResponse response,Model model){
		boolean check=asAssetsService.selectcheck(number);
		return renderString(response,check);
	}
}

