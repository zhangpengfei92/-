/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : FundSettlelogService.java
 * 功能概要  : 资金销售报表信息管理接口类
 * 做成日期  : 2018年04月24日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.TradeParam;
import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.FundSettlelogExample;

/**
 * 资金销售报表信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface FundSettlelogService {

	/**
	 * 查询所有资金销售报表信息
	 * @return list
	 * @throws Exception
	 */
	List<FundSettlelog> selectAll();

	/**
	 * 根据条件获取资金销售报表列表集合
	 * @param FundSettlelogExample
	 * @return list
	 * @throws Exception
	 */
	List<FundSettlelog> selectByExample(FundSettlelogExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return FundSettlelog
	 * @throws Exception
	 */
	FundSettlelog selectByPrimaryKey(Integer id);

	/**
	 * 删除资金销售报表信息实体
	 * @param FundSettlelog  资金销售报表信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 资金销售报表信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(FundSettlelog record, List<RightsRole> roleList);

	/**
	 * 更新资金销售报表信息实体
	 * @param record 资金销售报表信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(FundSettlelog record);

	/**
	 * 更新资金销售报表信息实体
	 * @param 资金销售报表信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存资金销售报表信息实体
	 * @param FundSettlelog  资金销售报表信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(FundSettlelog record) throws Exception;
	
	/**
	 * 判断资金销售报表信息是否存在
	 * @param typeId  资金销售报表信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<FundSettlelog> isExist(String username);

	FundSettlelog sumFundSettlelogFund(TradeParam trade);

}