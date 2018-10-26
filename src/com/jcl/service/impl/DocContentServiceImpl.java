package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.DocContentMapper;
import com.jcl.pojo.DocCommunityContent;
import com.jcl.pojo.DocContent;
import com.jcl.service.DocContentService;

@Service
public class DocContentServiceImpl implements DocContentService {

	@Autowired
	private DocContentMapper docContentMapper;

	@Override
	public List<DocCommunityContent> getALL() {

		return docContentMapper.getALL();
	}

	@Override
	public int insert(DocContent record) {

		return docContentMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return docContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<DocCommunityContent> selectByName(String title) {

		return docContentMapper.selectByName(title);
	}

	@Override
	public DocContent selectByPrimaryKey(Integer id) {

		return docContentMapper.selectByPrimaryKey(id);

	}

	@Override
	public int updateByPrimaryKey(DocContent record) {

		return docContentMapper.updateByPrimaryKey(record);

	}

	@Override
	public DocContent selectBycolumnid(Integer columnid) {
		return docContentMapper.selectBycolumnid(columnid);
	}

	@Override
	public int updateByPrimaryKeySelective(DocContent record) {
	
		return docContentMapper.updateByPrimaryKeySelective(record);
		
	}


}
