package com.jcl.dao;

import com.jcl.pojo.Feetemplate;
import com.jcl.pojo.FeetemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeetemplateMapper {
    int countByExample(FeetemplateExample example);

    int deleteByExample(FeetemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feetemplate record);

    int insertSelective(Feetemplate record);

    List<Feetemplate> selectByExample(FeetemplateExample example);

    Feetemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feetemplate record, @Param("example") FeetemplateExample example);

    int updateByExample(@Param("record") Feetemplate record, @Param("example") FeetemplateExample example);

    int updateByPrimaryKeySelective(Feetemplate record);

    int updateByPrimaryKey(Feetemplate record);
}