package com.jcl.dao;

import com.jcl.pojo.Bzjmb;
import com.jcl.pojo.BzjmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BzjmbMapper {
    long countByExample(BzjmbExample example);

    int deleteByExample(BzjmbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bzjmb record);

    int insertSelective(Bzjmb record);

    List<Bzjmb> selectByExample(BzjmbExample example);

    Bzjmb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bzjmb record, @Param("example") BzjmbExample example);

    int updateByExample(@Param("record") Bzjmb record, @Param("example") BzjmbExample example);

    int updateByPrimaryKeySelective(Bzjmb record);

    int updateByPrimaryKey(Bzjmb record);
    
    List<Bzjmb> selectAll();
	
	List<Bzjmb> isExist(@Param(value = "subzhName")String subzh,@Param(value = "id")Integer id,@Param(value = "parentId")Integer parentId);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param parentid
	 * @return
	 */
	int deleteByParent(Integer parentid);
	
}