package com.jcl.dao;

import com.jcl.pojo.CooperationPartner;
import com.jcl.pojo.CooperationPartnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CooperationPartnerMapper {
    int countByExample(CooperationPartnerExample example);

    int deleteByExample(CooperationPartnerExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(CooperationPartner record);

    int insertSelective(CooperationPartner record);

    List<CooperationPartner> selectByExample(CooperationPartnerExample example);

    CooperationPartner selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") CooperationPartner record, @Param("example") CooperationPartnerExample example);

    int updateByExample(@Param("record") CooperationPartner record, @Param("example") CooperationPartnerExample example);

    int updateByPrimaryKeySelective(CooperationPartner record);

    int updateByPrimaryKey(CooperationPartner record);

	List<CooperationPartner> selectByName(@Param("cname") String cname);
}