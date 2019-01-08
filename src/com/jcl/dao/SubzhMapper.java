package com.jcl.dao;

import com.jcl.pojo.PreMenu;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhKey;
import com.jcl.vo.SubVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SubzhMapper {
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-16
	 * @decribe 根据用户名查询所有用户，但不查自身
	 * @param username
	 * @return
	 */
	List<Subzh> selectAll(@Param("username")  String username);
	
	Subzh selectByPrimaryKeySubzh(@Param("subzhName") String subzhName);
	
	int deleteByPrimaryKeySubzh(@Param("subzhName") String subzhName);
	
	List<Map<String,Object>> selectByLike(@Param("subzhName") String nickname, @Param("usertype") Integer usertype);
	
    long countByExample(SubzhExample example);

    int deleteByExample(SubzhExample example);

    int deleteByPrimaryKey(SubzhKey key);

    int insert(Subzh record);

    int insertSelective(Subzh record);

    List<Subzh> selectByExample(SubzhExample example);

    Subzh selectByPrimaryKey(SubzhKey key);

    int updateByExampleSelective(@Param("record") Subzh record, @Param("example") SubzhExample example);

    int updateByExample(@Param("record") Subzh record, @Param("example") SubzhExample example);

    int updateByPrimaryKeySelective(Subzh record);

    int updateByPrimaryKey(Subzh record);
    
    List<Subzh> isExist(@Param(value = "subzhName")String subzh);

	Subzh selectBySubzh(String id);

	List<PreMenu> selectByRoleAndPer(String username);

	List<Subzh> selectByName(SubVo svo);

	Subzh loginBySubzh(String userName);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-16
	 * @decribe 根据条件查询渠道，经纪人，交易普通用户
	 * @param subzh
	 * @return
	 */
	List<Subzh> selectQdJjrUser(Subzh subzh);
	
	//根据手机号查询子账号
	List<Subzh> selectSubzhByPhone(@Param("phone")String phone,@Param("subzh")String subzh);

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
	 * @date 2018-5-24
	 * @decribe
	 * @param userid
	 * @return
	 */
	Subzh selectChannelBrokerBySubzh(String id);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-30
	 * @decribe 查询机构和平台 
	 * @param isadmin
	 * @return
	 */
	List<Subzh> getAgentzhPtList(int isadmin) throws Exception;

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-12
	 * @decribe 检查账号的  名称 是否已存在
	 * @param subzh
	 * @return
	 */
	List<Subzh> checkNameExist(Subzh subzh);
	
	//查询平台和机构信息
	List<Subzh> selectManage(int isadmin);

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
	
	@Select("SELECT * FROM subzh WHERE invite_code = #{inviteCode}")
	Subzh getSubzhByInviteCode(String inviteCode);

	@Delete("DELETE FROM subzh WHERE subzh = #{subzh}")
	boolean deleteBySubzh(String subzh);
	
	@Select("SELECT * FROM subzh WHERE risktype= #{id} and is_delete !=1")
	List<Subzh> selectSubzhByRisktype(Integer id);
	
	@Select("SELECT * FROM subzh WHERE bdtd= #{bdtd} and is_delete !=1")
	List<Subzh> selectByBdzh(String bdtd);
	
	@Select("SELECT * FROM subzh WHERE subzh like #{subzh}")
	List<Subzh> selectLikeSubzh(String subzh);
	
}