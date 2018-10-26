package com.jcl.dao;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.DocCommunityContent;
import com.jcl.pojo.DocContent;

public interface DocContentMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(DocContent record);

	List<DocCommunityContent> selectByName(String title);

	int insertSelective(DocContent record);

	DocContent selectByPrimaryKey(Integer id);
	
	DocContent selectBycolumnid(Integer columnid);

	int updateByPrimaryKeySelective(DocContent record);

	int updateByPrimaryKeyWithBLOBs(DocContent record);

	int updateByPrimaryKey(DocContent record);
	


	List<DocContent> getDocContentListByMap(Map<String, Object> map);

	List<DocCommunityContent> getALL();
}