package com.thinkgem.jeesite.modules.administr.web;


import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.modules.administr.form.AsSuppliesInfoForm;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesInfoService;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesInfoCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesInfo;


@Controller
@Scope("prototype")
@RequestMapping(value = "${adminPath}/administr/suppliesInfo")
public class AsSuppliesInfoController extends BaseController {

	@Resource(name = "asSuppliesInfoServiceImpl")
	private AsSuppliesInfoService asSuppliesInfoService;
	@Resource(name = "asSuppliesServiceImpl")
	private AsSuppliesService asSuppliesService;

	/**
	 * 分页查询
	 * @return 
	 */
	@RequestMapping(value = "/listAsSuppliesInfoByPage")
	public String listAsSuppliesInfoByPage(@ModelAttribute AsSuppliesInfoForm asSuppliesInfoForm,HttpServletRequest request,HttpServletResponse response,Model model){
		Page<AsSuppliesInfo> page=asSuppliesInfoForm.getPage();// 获取分页对象
		AsSuppliesInfoCondition condition=new AsSuppliesInfoCondition();
		asSuppliesInfoService.listAsSuppliesInfoByPage(page,condition);
		model.addAttribute("page",page);
		return "modules/administr/asSuppliesInfoList";
	}

	/**
	 * 编辑办公用品入库表
	 * @return 
	 */
	@RequestMapping(value = "/edit")
	public String edit(@ModelAttribute AsSuppliesInfoForm asSuppliesInfoForm,HttpServletRequest request,HttpServletResponse response,Model model){
		if(StringUtils.isNotBlank(asSuppliesInfoForm.getItem().getId())){
			AsSuppliesInfo item = asSuppliesInfoService.getAsSuppliesInfoById(asSuppliesInfoForm.getItem().getId());
			model.addAttribute("item", item);
		}
		// 所有用品
		List<AsSupplies> listaSupplies=asSuppliesService.listAsSupplies();
		model.addAttribute("listaSupplies", listaSupplies);
		return "modules/administr/asSuppliesInfoForm";
	}

	/**
	 * 保存办公用品入库表
	 * @return 
	 */
	@RequestMapping(value = "/saveAsSuppliesInfo", method = RequestMethod.POST)
	public String saveAsSuppliesInfo(@ModelAttribute AsSuppliesInfoForm asSuppliesInfoForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			if(StringUtils.isBlank(asSuppliesInfoForm.getItem().getId())){
				User user=UserUtils.getUser();// 获取当前用户
				AsSuppliesInfo item=asSuppliesInfoForm.getItem();
				item.setId(IdGen.uuid());// 主键id
				item.setCreateBy(user.getId());// 创建人id
				asSuppliesInfoService.add(item);
				// 增加仓库库存
				asSuppliesService.updateSuppliesNum2(item.getArticles(), item.getNum());
			}else{
				asSuppliesInfoService.update(asSuppliesInfoForm.getItem());
			}
		} catch (Exception e) {
			String msg = "保存办公用品入库表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/suppliesInfo/listAsSuppliesInfoByPage";
	}
	/**
	 * 删除AsSuppliesInfo
	 * @return 
	 */
	@RequestMapping(value = "/del")
	public String del(@ModelAttribute AsSuppliesInfoForm asSuppliesInfoForm,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			asSuppliesInfoService.delByIds(asSuppliesInfoForm.getItem().getId().split(","));
		} catch (Exception e) {
			String msg = "删除办公用品入库表时发生异常：" + e.getMessage();
			logger.error(msg,e);
		}
		return "redirect:" + adminPath + "/administr/suppliesInfo/listAsSuppliesInfoByPage";
	}

	
	/**根据采购单id更新仓库信息*/
	@ResponseBody
	@RequestMapping(value = "/updateAsSuppliesById")
	public String updateAsSuppliesById(@Param("shoppingId")String shoppingId,@Param("id")String id){
		asSuppliesInfoService.updateAsSuppliesById(shoppingId,id);
		return "( ゜- ゜)つロ 乾杯~";
	}
}

