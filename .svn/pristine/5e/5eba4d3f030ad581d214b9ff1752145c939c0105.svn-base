package com.jcl.dao;

import com.jcl.pojo.PremiumPrincipal;
import com.jcl.pojo.PremiumPrincipalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PremiumPrincipalMapper {
    int countByExample(PremiumPrincipalExample example);

    int deleteByExample(PremiumPrincipalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PremiumPrincipal record);

    int insertSelective(PremiumPrincipal record);

    List<PremiumPrincipal> selectByExample(PremiumPrincipalExample example);

    PremiumPrincipal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PremiumPrincipal record, @Param("example") PremiumPrincipalExample example);

    int updateByExample(@Param("record") PremiumPrincipal record, @Param("example") PremiumPrincipalExample example);

    int updateByPrimaryKeySelective(PremiumPrincipal record);

    int updateByPrimaryKey(PremiumPrincipal record);
}