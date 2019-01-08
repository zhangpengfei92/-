/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : SubzhService.java
 * 功能概要  : 账户信息管理接口类
 * 做成日期  : 2018年04月08日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.Permission;
import com.jcl.pojo.PreMenu;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhPreMenu;
import com.jcl.pojo.SubzhRole;
import com.jcl.util.StringUtil;
import com.jcl.vo.SubVo;

/**
 * 账户信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface SubzhService {

	/**
	 * 查询所有账户信息
	 * @return list
	 * @throws Exception
	 */
	List<Subzh> selectAll(String username);

	/**
	 * 根据Id查询账户信息实体
	 * @param FundPzlogId
	 * @return FundPzlog
	 * @throws Exception
	 */
	Subzh selectByPrimaryKey(String subzhName);

	/**
	 * 根据条件模糊查询niclname和usertype
	 * @param SubzhExample
	 * @return list
	 * @throws Exception
	 */
	List<Map<String,Object>> selectByLike(String nickname, Integer usertype);
	
	/**
	 * 根据条件获取账户列表集合
	 * @param SubzhExample
	 * @return list
	 * @throws Exception
	 */
	List<Subzh> selectByExample(SubzhExample example);

	/**
	 * 删除账户信息实体
	 * @param FundPzlog  账户信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String subzhName);
	
	/**
	 * 更新用户权限
	 * @param record 账户信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(Subzh record, List<RightsRole> roleList);

	/**
	 * 更新账户信息实体
	 * @param record 账户信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(Subzh record);

	/**
	 * 更新账户信息实体
	 * @param 账户信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存账户信息实体
	 * @param FundPzlog  账户信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(Subzh record, List<RightsRole> roleList) throws Exception;
	
	/**
	 * 判断账户信息是否存在
	 * @param typeId  账户信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<Subzh> isExist(String username);

	int addSubzh(Subzh subzh);

	int saveSubzhPre(String num,String subzh);

	int saveSubzhRole(String subzh, Integer roleid);

	Subzh selectBySubzh(String subzh);

	SubzhRole selectSubzhRole(String subzh);

	List<SubzhPreMenu> selectSubPreMenu(String subzh);

	List<PreMenu> selectByRoleAndPer(String username);

	List<Subzh> selectByName(SubVo svo);

	int updateSubzhRole(SubzhRole sr);

	int updateSubzhPre(String num, String subzh);

	Subzh loginBySubzh(String userName);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-16
	 * @decribe 根据条件查询渠道经纪人交易用户
	 * @param subzh
	 * @return
	 */
	List<Subzh> selectQdJjrUser(Subzh subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-17
	 * @decribe 查询此手机号是存在，如果已存在则返回true,如果不存在就返回false;
	 * @param phone
	 * @param subzh
	 * @return
	 */
	boolean checkPhoneExist(String phone, String subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-17
	 * @decribe 查询此用户编号是存在，如果已存在则返回true,如果不存在就返回false;
	 * @param subzh
	 * @return
	 */
	boolean checkSubzhExist(String subzh);

	List<Permission> selectPre();

	int addmenu(PreMenu preMenu);

	List<PreMenu> selectPreMenu(String keyword);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-17
	 * @decribe 查询平台下所有渠道，查询渠道下所有经纪人，查询经纪人下所有普通用户
	 * @param s
	 * @return
	 */
	List<Subzh> getSubzhLevelList(Subzh s);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-18
	 * @decribe 获取一个纯净用户
	 * @param id
	 * @return
	 */
	Subzh getPuriSubzh(String id);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-21
	 * @decribe 查询交易用户，需要关联查出渠道名，经纪人名，方案名，报单账号的。
	 * @param subzh
	 * @return
	 */
	List<Subzh> selectTradeUser(Subzh subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-30
	 * @decribe 查询机构和平台
	 * @param i
	 * @return
	 */
	List<Subzh> getAgentzhPtList(int isadmin) throws Exception;
	
	String auth(Subzh subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-12
	 * @decribe 检查账号的名称是否已存在
	 * @param subzh
	 * @param name
	 * @return
	 */
	boolean checkNameExist(Subzh subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-13
	 * @decribe 交易管理查询交易用户，需要关联渠道，代理商，经纪人的名称 的。
	 * @param sub
	 * @return
	 */
	List<Subzh> getTradeUserList(Subzh sub);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-13
	 * @decribe 交易管理查询交易用户，需要关联渠道，代理商，经纪人的名称 的。
	 * @param subzh
	 * @return
	 */
	Subzh getTradeUserOne(String subzh);

    /**
     * 根据邀请码查询用户信息
     * @param inviteCode
     */
	Subzh selectByInviteCode(String inviteCode);
	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-20
	 * @decribe 根据方案查询交易用户
	 * @param subzh
	 * @return
	 */
	List<Subzh> getFanganSubzh(Subzh subzh);
	public String getInviteCode(String inviteCode);

	Subzh selectByPrimaryKeySubzh(String phone);

	int insertSelective(Subzh subzh);

	Subzh getSubzhByInviteCode(String inviteCode);

	boolean deleteBySubzh(String subzh);
}