package com.jcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.comm.WhResult;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.service.FundPzLogService;

@Controller
@RequestMapping("/fundAuto")
public class FundAutoController {

	/**
	 * 三方线下通过
	 */

	/* 提现记录信息管理service */
	@Autowired
	private FundPzLogService fundPzLogService;
	
	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;
	
	private static final Object object="12";

	// 新增收费方案
	@RequestMapping("/fundAuto")
	@ResponseBody
	public WhResult fundAuto(Integer id) {
		WhResult result = new WhResult();
		result.setStatus(100);
		synchronized (object) {
			AgentzhfundLog agentzhfundLog = agentzhfundLogMapper.selectByPrimaryKey(id);
			if(agentzhfundLog !=null && agentzhfundLog.getBz()==2 && agentzhfundLog.getStatus()==4){
				int i =fundPzLogService.fundAuto(agentzhfundLog);
				if(i>0){
					result.setStatus(200);
				}
			}
		}
		return result;
	}
}
