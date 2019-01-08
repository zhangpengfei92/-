package com.jcl.dao;

import com.jcl.pojo.Bdzh;
import com.jcl.pojo.BdzhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BdzhMapper {
    int countByExample(BdzhExample example);

    int deleteByExample(BdzhExample example);

    int deleteByPrimaryKey(Integer bdzhid);

    int insert(Bdzh record);

    int insertSelective(Bdzh record);

    List<Bdzh> selectByExample(BdzhExample example);

    Bdzh selectByPrimaryKey(Integer bdzhid);

    int updateByExampleSelective(@Param("record") Bdzh record, @Param("example") BdzhExample example);

    int updateByExample(@Param("record") Bdzh record, @Param("example") BdzhExample example);

    int updateByPrimaryKeySelective(Bdzh record);

    int updateByPrimaryKey(Bdzh record);
    //全查询 --根据显示状态区分
    List<Bdzh> selectAll();

	void updateZhstate(String accountid);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-21
	 * @decribe
	 * @param bdzh
	 * @return
	 */
	List<Bdzh> selectByBdzh(Bdzh bdzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param bdzh
	 * @return
	 */
	List<Bdzh> isexist(Bdzh bdzh);
    
    
}