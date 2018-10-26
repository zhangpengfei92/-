package com.jcl.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.AppHelpMapper;
import com.jcl.pojo.AppHelp;
import com.jcl.service.AppHelpInfoService;


@Service
public class AppHelpInfoServiceImpl implements AppHelpInfoService {

	@Autowired
	private AppHelpMapper appHelpMapper;
	
	@Override
	public List<AppHelp> getHelpInfoList() {
		
		return appHelpMapper.selectByExample(null);
	}

	
}
