/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : CodefeesetController.java
 * 功能概要  : 收费方案信息 管理Controller类
 * 做成日期  : 2018年04月26日 
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.CodefeesetExample;
import com.jcl.pojo.CodefeesetExample.Criteria;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.CodefeesetMenuExample;
import com.jcl.pojo.RiskContract;
import com.jcl.pojo.Subzh;
import com.jcl.service.CodefeesetMenuService;
import com.jcl.service.CodefeesetService;
import com.jcl.service.SubzhService;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.jcl.vo.MsCodeResult;

/**
 * 收费方案信息 管理类
 * 
 * @version 1.0
 */
@Controller
@RequestMapping("/codefeeset")
public class CodefeesetController {
	
	public static Logger log = Logger.getLogger(CodefeesetController.class);
	
	private Codefeeset codefeeset;
	
	/*收费方案信息管理service*/
	@Autowired
	private CodefeesetMenuService codefeesetMenuService;
	
	@Autowired
	private CodefeesetService codefeesetService;
	
	@Autowired
	private SubzhService subzhservice;
	
	// 收费方案管理页面跳转
	@RequestMapping("/codefeesetList")
	public String codefeesetList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "8");
		try {
			/*查询收费方案列表*/
			List<CodefeesetMenu> codefeesetMenuList = codefeesetMenuService.selectAll();
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<codefeeset> userlist = codefeesetservice.selectAll();
			CodefeesetExample example = new CodefeesetExample();
			example.setOrderByClause(" id desc");
			Criteria criteria = example.createCriteria();
			if(codefeesetMenuList != null && codefeesetMenuList.size() > 0){
				DecimalFormat df = new DecimalFormat("######0.00");
				for(CodefeesetMenu menu : codefeesetMenuList){
					if(menu.getIsdefault() != null && menu.getIsdefault() == 1){
						if(menu.getPercentage() != null){
							menu.setTitle(menu.getTitle() + "(管理费:" + df.format(menu.getPercentage()) + ") - 默认");
						} else {
							menu.setTitle(menu.getTitle() + "(默认)");
						}
					} else if(menu.getPercentage() != null){
						menu.setTitle(menu.getTitle() + "(管理费:" + df.format(menu.getPercentage()) + ")");
					}
				}
				criteria.andParentidEqualTo(codefeesetMenuList.get(0).getId());
			}
			model.addAttribute("codefeesetMenuList", codefeesetMenuList);
			//criteria.andTypeEqualTo("3");//
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<Codefeeset> userlist = codefeesetService.selectByExample(example);
			if(userlist!=null&&!userlist.isEmpty()){
				//根据汉字拼音排序
				Collections.sort(userlist, new Comparator<Codefeeset>() {
					@Override
					public int compare(Codefeeset o1, Codefeeset o2) {
						// TODO Auto-generated method stub
						Comparator<Object> com=Collator.getInstance(Locale.CHINA);
						return com.compare(o1.getHyname(), o2.getHyname());
					}
				});
			}
			PageInfo<Codefeeset> userpage = new PageInfo<Codefeeset>(userlist);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/codefeesetList";
	}

	// 收费方案列表模糊查询
	@RequestMapping("/selectPage")
	public String selectPage(String nickname, String usertype, String marketcode, Model model) throws UnsupportedEncodingException {
		try {
			/*查询收费方案列表*/
			List<CodefeesetMenu> codefeesetMenuList = codefeesetMenuService.selectAll();
			if(codefeesetMenuList != null && codefeesetMenuList.size() > 0){
				for(CodefeesetMenu menu : codefeesetMenuList){
					DecimalFormat df = new DecimalFormat("######0.00");
					if(menu.getIsdefault() != null && menu.getIsdefault() == 1){
						if(menu.getPercentage() != null){
							menu.setTitle(menu.getTitle() + "(管理费:" + df.format(menu.getPercentage()) + ") - 默认");
						} else {
							menu.setTitle(menu.getTitle() + "(默认)");
						}
					} else if(menu.getPercentage() != null){
						menu.setTitle(menu.getTitle() + "(管理费:" + df.format(menu.getPercentage()) + ")");
					}
				}
			}
			model.addAttribute("codefeesetMenuList", codefeesetMenuList);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			CodefeesetExample example = new CodefeesetExample();
			example.setOrderByClause(" id desc");
			Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andParentidEqualTo(Integer.parseInt(usertype));
			}
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andCodeLike("%" + nickname + "%");
			}
			if(!StringUtil.isAnyNullOrEmpty(marketcode)){
				criteria.andMarketcodeEqualTo(Integer.parseInt(marketcode));
			}
			List<Codefeeset> userlist = codefeesetService.selectByExample(example);
			PageInfo<Codefeeset> userpage = new PageInfo<Codefeeset>(userlist);
			
			model.addAttribute("usertypeValue", usertype);
			model.addAttribute("marketcodeValue", marketcode);
			model.addAttribute("nickname", nickname);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/codefeesetList";
	}
	
	// 新增收费方案
	@RequestMapping("/addCodefeesetMenu")
	public String addCodefeesetMenu() {
		return "fund/addCodefeesetMenu";
	}
	
	// 编辑收费方案信息
	@SuppressWarnings("rawtypes")
	@RequestMapping("/editCodefeesetMenuMsg")
	@ResponseBody
	public String editCodefeesetMenuMsg(HttpSession session, CodefeesetMenu user, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			List<CodefeesetMenu> userList = codefeesetMenuService.isExist(user.getTitle(), id);
			if(userList != null && userList.size() > 0){
				return "isExist";
			}
			if(id == null){//新增
				user.setAgentzh("1");
				user.setModifytime(Calendar.getInstance().getTime());
				/*if(session.getAttribute(Constant.SESSION_ACCOUNTID) != null){
					user.setUserid(Long.parseLong(session.getAttribute(Constant.SESSION_ACCOUNTID).toString()));
				} else {*/
				user.setUserid(1l);
				//}
			} else {
				user.setId(id);
				if(StringUtil.isAnyNullOrEmpty(user.getAgentzh())){
					user.setAgentzh("1");
				}
			}
			if(user.getIsdefault() != null && user.getIsdefault() == 1){
				CodefeesetMenuExample example = new CodefeesetMenuExample();
				example.setOrderByClause(" id desc");
				com.jcl.pojo.CodefeesetMenuExample.Criteria criteria = example.createCriteria();
				criteria.andIsdefaultEqualTo(1);
				List<CodefeesetMenu> codefeesetMenuList = codefeesetMenuService.selectByExample(example);
				if(codefeesetMenuList != null && codefeesetMenuList.size() > 0){
					for(CodefeesetMenu menu : codefeesetMenuList){
						try {
							menu.setIsdefault(0);
							codefeesetMenuService.updateByPrimaryKey(menu);
						} catch (Exception eu) {
							log.error("更新收费方案异常:" + eu.getMessage());
						}
					}
				}
			}
			int i = codefeesetMenuService.insertSelective(user);
			if(i > 0){
				try {//新增当前行情下的所有手续费方案
					//List<Codefeeset> codefeesetList = new ArrayList<Codefeeset>();//合约手续费信息
					
					Map<String, String> msCode = CommonFunc.getHttpCtpMsCode();
					if(msCode != null && msCode.size() > 0){
						Codefeeset result = null;
						String key = "";
						String [] keyArr = null;
						Iterator entries = msCode.entrySet().iterator();
						while (entries.hasNext()) {  
						    Map.Entry entry = (Map.Entry) entries.next();
						    result = new Codefeeset();
						    key = entry.getKey().toString();
						    
						    keyArr = key.split("-");//6AH6-CME,14
						    if(keyArr.length > 1){
						    	result.setCode(keyArr[0]);//品种代码
						    	keyArr = keyArr[1].split(",");//CME,14
						    	result.setMarketcode(Integer.parseInt(keyArr[1]));//市场代码
						    }
						    result.setHyname(entry.getValue().toString());
						    result.setSqfs(1);
						    result.setBz("CNY");
						    
						    result.setParentid(user.getId());//手续费方案
						    /*if(session.getAttribute(Constant.SESSION_ACCOUNTID) != null){
						    	result.setUserid(Long.parseLong(session.getAttribute(Constant.SESSION_ACCOUNTID).toString()));
							} else {*/
								result.setUserid(1l);
							//}
						    result.setAgentzh("1");
						    log.info("保存收费合约信息状态值:" + codefeesetService.insertSelective(result));
						}
					}
					
				} catch (Exception ex) {
					log.error("新增当前行情下的所有手续费方案异常：" + ex.getMessage());
				}
				
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			codefeesetMenuService.deleteByPrimaryKey(user.getId());
		}
		
		return "false";
	}
	
	// 编辑收费方案
	@SuppressWarnings("rawtypes")
	@RequestMapping("/editCodefeeset")
	public String editCodefeeset(Integer id, Model model) {
		
		try {
			List<MsCodeResult> msCodeList = new ArrayList<MsCodeResult>();
			Map<String, String> msCode = CommonFunc.getHttpMsCode();
			if(msCode != null && msCode.size() > 0){
				MsCodeResult result = null;
				String key = "";
				String [] keyArr = null;
				Iterator entries = msCode.entrySet().iterator();
				while (entries.hasNext()) {  
				    Map.Entry entry = (Map.Entry) entries.next();
				    result = new MsCodeResult();
				    key = entry.getKey().toString();
				    result.setKey(key);
				    keyArr = key.split("-");//6AH6-CME,14
				    if(keyArr.length > 1){
				    	result.setCode(keyArr[0]);//品种代码
				    	keyArr = keyArr[1].split(",");//CME,14
				    	result.setMarketCode(keyArr[0]);//市场代码
				    }
				    keyArr = key.split(",");
				    if(keyArr.length > 1){
				    	result.setShowkey(keyArr[0]);//显示名称
				    	result.setMarket(keyArr[1]);//市场
				    }
				    result.setCodeName(entry.getValue().toString());
				    msCodeList.add(result);
				    Collections.sort(msCodeList);
				}
			}
			model.addAttribute("yyCodeList", msCodeList);
		} catch (Exception e) {
			log.error("获取代码链或查询异常：" + e.getMessage());
		}
		
		try {
			List<CodefeesetMenu> codefeesetMenuList = codefeesetMenuService.selectAll();
			if(codefeesetMenuList != null && codefeesetMenuList.size() > 0){
				for(CodefeesetMenu menu : codefeesetMenuList){
					if(menu.getIsdefault() != null && menu.getIsdefault() == 1){
						menu.setTitle(menu.getTitle() + "(默认)");
					}
				}
			}
			model.addAttribute("codefeesetMenuList", codefeesetMenuList);
			
			if(id != null){
				/*List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
				model.addAttribute("rightsRoles", roles);*/
				Codefeeset user = codefeesetService.selectByPrimaryKey(id);
				/*if(user.getStarttime() != null){
					model.addAttribute("starttimeStr", DateUtil.dateToString(user.getStarttime()));
				}
				if(user.getEndtime() != null){
					model.addAttribute("endtimeStr", DateUtil.dateToString(user.getEndtime()));
				}*/
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/inputCodefeeset";
	}
	
	// 新增收费方案
	@RequestMapping("/addCodefeeset")
	public String addCodefeeset(Integer id, Model model) {
		try {
			/*List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);*/
			Codefeeset user = codefeesetService.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/inputCodefeeset";
	}
	
	// 编辑收费方案
	@RequestMapping("/editcodefeesetMsg")
	@ResponseBody
	public String editcodefeesetMsg(HttpSession session, Codefeeset user, String starttimeStr, String endtimeStr, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			if(id == null){//新增
				String key = user.getHyname();
				if(!StringUtil.isAnyNullOrEmpty(key)){
					Map<String, String> msCode = CommonFunc.getHttpMsCode();
					if(msCode != null && msCode.size() > 0){
						user.setHyname(msCode.get(key));//名称
					}
					String [] keyArr = key.split("-");//6AH6-CME,14
				    if(keyArr.length > 1){
				    	user.setCode(keyArr[0]);//品种代码
				    }
				    keyArr = key.split(",");
				    if(keyArr.length > 1){
				    	user.setMarketcode(Integer.parseInt(keyArr[1]));//市场
				    }
				}
				List<Codefeeset> userList = codefeesetService.isExist(user.getCode(), id, user.getParentid());
				if(userList != null && userList.size() > 0){
					return "isExist";
				}
				user.setAgentzh("1");
				//user.setModifytime(Calendar.getInstance().getTime());
				/*if(session.getAttribute(Constant.SESSION_ACCOUNTID) != null){
					user.setUserid(Long.parseLong(session.getAttribute(Constant.SESSION_ACCOUNTID).toString()));
				} else {*/
					user.setUserid(1l);
				//}
			} else {
				List<Codefeeset> userList = codefeesetService.isExist(user.getCode(), id, user.getParentid());
				if(userList != null && userList.size() > 0){
					return "isExist";
				}
				user.setId(id);
				if(StringUtil.isAnyNullOrEmpty(user.getAgentzh())){
					user.setAgentzh("1");
				}
			}
			int i = 0;
			if(id == null){//新增
				i = codefeesetService.insertSelective(user);
			} else {
				i = codefeesetService.updateByPrimaryKey(user);
			}
			if(i > 0){
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			codefeesetService.deleteByPrimaryKey(user.getId());
		}
		return "false";
	}

	//批量修改
	@RequestMapping("/updateCodefeesetMore")
	public String updateCodefeesetMore(Model model, String codefeesetIds) {
		try {
			model.addAttribute("codefeesetId", codefeesetIds);
		} catch (Exception e) {
			log.error("查询异常："+e.getMessage());
		}
		return "fund/updateCodefeeset";
	}
	
	// 编辑收费方案
	@RequestMapping("/editcodefeesetMsgMore")
	@ResponseBody
	public String editcodefeesetMsgMore(HttpSession session, Codefeeset user) {
		/*判断方案名称是否已存在*/
		try {
			 String codefeesetIds = user.getBz();
			if(!StringUtil.isAnyNullOrEmpty(codefeesetIds)){//修改
				String [] strId = codefeesetIds.split(",");
				Codefeeset userTemp = null;
				for(int i = 0; i < strId.length; i++){
					userTemp = codefeesetService.selectByPrimaryKey(Integer.parseInt(strId[i]));
					if(userTemp != null){
						userTemp.setCounterfee1(user.getCounterfee1());
						userTemp.setCounterfee2(user.getCounterfee2());
						userTemp.setPcfee1(user.getPcfee1());
						userTemp.setPcfee2(user.getPcfee2());
						userTemp.setPcamountfee1(user.getPcamountfee1());
						userTemp.setPcamountfee2(user.getPcamountfee2());
						log.info("更新收费合约记录：" + codefeesetService.updateByPrimaryKey(userTemp));
					}
				}
			}
			return "true";
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
		}
		return "false";
	}
	
	// 单个删除
	@RequestMapping("/deleteCodefeeset")
	@ResponseBody
	public String deleteCodefeeset(Integer id) {
		try {
			codefeesetService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
	
	
	@RequestMapping("/deleteCodefeeMenu")
	@ResponseBody
	public String deleteCodefeeMenu(Integer id) {
		try {
			if(id==null){
				return "false";
			}
			Subzh subzh=new Subzh();
			subzh.setFeeset(id.toString());
			List<Subzh> list=subzhservice.getFanganSubzh(subzh);
			if(list!=null && list.size()>0){//如果有交易用户关联到此手续费方案
				return "hassub";
			}else{
				codefeesetMenuService.deleteByPrimaryKey(id);
				codefeesetService.deleteByMenu(id);
			}
			
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
	
	
	public Codefeeset getcodefeeset() {
		return codefeeset;
	}

	public void setcodefeeset(Codefeeset codefeeset) {
		this.codefeeset = codefeeset;
	}
	
}