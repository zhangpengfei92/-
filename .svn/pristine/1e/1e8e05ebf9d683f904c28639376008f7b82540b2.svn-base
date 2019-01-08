package com.jcl.dao;

import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhPreMenu;
import com.jcl.pojo.SubzhPreMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubzhPreMenuMapper {
    int countByExample(SubzhPreMenuExample example);

    int deleteByExample(SubzhPreMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubzhPreMenu record);

    int insertSelective(SubzhPreMenu record);

    List<SubzhPreMenu> selectByExample(SubzhPreMenuExample example);

    SubzhPreMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubzhPreMenu record, @Param("example") SubzhPreMenuExample example);

    int updateByExample(@Param("record") SubzhPreMenu record, @Param("example") SubzhPreMenuExample example);

    int updateByPrimaryKeySelective(SubzhPreMenu record);

    int updateByPrimaryKey(SubzhPreMenu record);

	List<SubzhPreMenu> selectSubPreMenu(String subzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-20
	 * @decribe 查询某个 平台或渠道或代理商下的渠道，代理商，经纪人
	 * @param condition
	 * @return
	 */
	List<SubzhPreMenu> getAllSubPre(Subzh condition);
}