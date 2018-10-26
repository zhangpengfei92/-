package com.jcl.dao;

import com.jcl.pojo.Document;
import com.jcl.pojo.DocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    int countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExampleWithBLOBs(DocumentExample example);

    List<Document> selectByExample(DocumentExample example);

    Document selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);

	List<Document> selectByname(String docnaem);
}