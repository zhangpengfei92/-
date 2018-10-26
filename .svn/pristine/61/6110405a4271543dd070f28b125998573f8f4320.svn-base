package com.jcl.service;

import java.util.List;

import com.jcl.pojo.DocCommunityContent;
import com.jcl.pojo.DocContent;

public interface DocContentService {

	// 连表查
	List<DocCommunityContent> getALL();

	int insert(DocContent record);

	int deleteByPrimaryKey(Integer id);

	DocContent selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(DocContent record);

	List<DocCommunityContent> selectByName(String title);

	DocContent selectBycolumnid(Integer columnid);

	int updateByPrimaryKeySelective(DocContent record);

}
