package com.jcl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jcl.pojo.SubzhContract;

public interface SubzhContractMapper {
	
	@Select("SELECT * FROM subzh_contract WHERE id = #{primaryKey}")
	SubzhContract selectOneByPrimaryKey(String primaryKey);
	
	@Insert("INSERT INTO subzh_contract (id,subzh,isadmin,contract_code,contract_name,cost,update_time) VALUES (#{id},#{subzh},#{isadmin},#{contractCode},#{contractName},#{cost},#{updateTime} )")
	boolean insertSubzhContract(SubzhContract subzhContract);
	
	@Select("SELECT * FROM subzh_contract WHERE subzh = #{subzh}")
	List<SubzhContract> selectSubzhContractsBySubzh(String subzh);
	
	@Delete("DELETE FROM subzh_contract WHERE subzh = #{subzh}")
	boolean deleteDataBySubzh(String subzh);
	
	@Select("SELECT * FROM subzh_contract WHERE contract_name = #{contractName} AND subzh = #{subzh}")
	SubzhContract selectOneByNameAndSubzh(@Param("contractName")String contractName, @Param("subzh")String subzh);

}
