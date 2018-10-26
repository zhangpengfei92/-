package com.jcl.dao;

import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.CodefeesetExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodefeesetMapper {
    long countByExample(CodefeesetExample example);

    int deleteByExample(CodefeesetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Codefeeset record);

    int insertSelective(Codefeeset record);

    List<Codefeeset> selectByExample(CodefeesetExample example);

    Codefeeset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Codefeeset record, @Param("example") CodefeesetExample example);

    int updateByExample(@Param("record") Codefeeset record, @Param("example") CodefeesetExample example);

    int updateByPrimaryKeySelective(Codefeeset record);

    int updateByPrimaryKey(Codefeeset record);

    List<Codefeeset> selectAll();
	
   	List<Codefeeset> isExist(@Param(value = "subzhName")String subzh, @Param(value = "id")Integer id, @Param(value = "parentId")Integer parentId);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param parentid
	 * @return
	 */
	int deleteByMenu(Integer parentid);

}