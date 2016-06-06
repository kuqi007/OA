package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dao.AsSuppliesDao;
import com.thinkgem.jeesite.modules.administr.dao.AsSuppliesOutDao;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesOutCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesOut;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesOutService;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;


/**
 * 办公用品出库记录
 * @create-time 2016/4/7 9:48:39
 */
@Service("asSuppliesOutServiceImpl")
@Transactional(value = "transactionManager")
public class AsSuppliesOutServiceImpl implements AsSuppliesOutService{

	@Resource
	private AsSuppliesOutDao asSuppliesOutDao;
	@Autowired
	private UserDao userDao;
	@Resource
	private AsSuppliesDao asSuppliesDao;
	/**
	 * 查询所有办公用品出库记录
	 */
	public List<AsSuppliesOut> listAsSuppliesOutAll(){
		return asSuppliesOutDao.listAsSuppliesOutAll();
	}

	/**
	 * 分页查询
	 * @param condition 查询条件类
	 */
	public void listAsSuppliesOutByPage(Page<AsSuppliesOut> page,AsSuppliesOutCondition condition){
		int rows = asSuppliesOutDao.listAsSuppliesOutByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsSuppliesOut> list = asSuppliesOutDao.listAsSuppliesOutByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<AsSuppliesOut> list2=new ArrayList<AsSuppliesOut>();
		for (int i = 0; i < list.size(); i++) {
			AsSuppliesOut item=list.get(i);
			User user=userDao.getById(list.get(i).getPeopleId());
			if(user==null)continue;
			item.setPeopleName(user.getName());
			item.setOfficeName(user.getOffice().getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}
	/**
	 * 根据权限分页查询
	 * @param condition 查询条件类
	 */
	public void listAsSuppliesOutByPageClassfied(Page<AsSuppliesOut> page,AsSuppliesOutCondition condition){
		User currentUser=UserUtils.getUser();
		int rows = asSuppliesOutDao.listAsSuppliesOutByPageCountClassfied(currentUser, condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsSuppliesOut> list = asSuppliesOutDao.listAsSuppliesOutByPageClassfied(currentUser,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		/*List<AsSuppliesOut> list2=new ArrayList<AsSuppliesOut>();
		for (int i = 0; i < list.size(); i++) {
			AsSuppliesOut item=list.get(i);
			User user=userDao.getById(list.get(i).getPeopleId());
			item.setPeopleName(user.getName());
			item.setOfficeName(user.getOffice().getName());
			list2.add(item);
		}*/
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品出库记录
	 */
	public AsSuppliesOut getAsSuppliesOutById(String id){
		return asSuppliesOutDao.getAsSuppliesOutById(id);
	}

	/**
	 * 新增
	 * @param item 办公用品出库记录
	 */
	public void add(AsSuppliesOut item){
		asSuppliesOutDao.add(item);
	}

	/**
	 * 修改
	 * @param item 办公用品出库记录
	 */
	public void update(AsSuppliesOut item){
		asSuppliesOutDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asSuppliesOutDao.delByIds(ids);
	}

	/**
	 * 签收出库单
	 * @param item 出库详情表
	 */
	public void updateSign(String id,Integer state){
		asSuppliesOutDao.updateSign(id,state);
	};

}

