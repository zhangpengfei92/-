/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : feeSchemeController.java
 * 功能概要  : 收费方案信息 管理Controller类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.comm.WhResult;
import com.jcl.pojo.Bzjmb;
import com.jcl.pojo.BzjmbExample;
import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.FeeScheme;
import com.jcl.pojo.FeeSchemeExample;
import com.jcl.pojo.FeeSchemeExample.Criteria;
import com.jcl.pojo.FeeschemeMenu;
import com.jcl.pojo.FileUploadPathObject;
import com.jcl.pojo.RiskContract;
import com.jcl.pojo.RiskStock;
import com.jcl.pojo.RiskStockExample;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTempallExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.service.BzjmbMenuService;
import com.jcl.service.BzjmbService;
import com.jcl.service.FeeSchemeService;
import com.jcl.service.FeeschemeMenuService;
import com.jcl.service.RiskStockService;
import com.jcl.service.RiskTempallService;
import com.jcl.service.SubzhService;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.ExcelReader;
import com.jcl.util.FileUtil;
import com.jcl.util.ReadExcel2007;
import com.jcl.util.StringUtil;
import com.jcl.vo.MsCodeResult;

/**
 * 收费方案信息 管理类
 * 
 * @author jiangzq
 * @version 1.0
 */
@Controller
@RequestMapping("/cost")
public class CostController {
	
	public static Logger log = Logger.getLogger(CostController.class);
	
	/*收费方案*/
	private FeeScheme feeScheme;
	//private Object synObj = "129";
	/*myFile属性用来封装上传的文件   */
    private File myFile;
    /*myFileFileName属性用来封装上传文件的文件名 */
    private String myFileFileName;
	
	/*收费方案信息管理service*/
	@Autowired
	private FeeSchemeService feeSchemeService;
	
	@Autowired
	private FeeschemeMenuService feeSchemeMenuService;
	
	@Autowired
	private SubzhService subzhservice;
	
	/*保证金方案信息管理service*/
	@Autowired
	private BzjmbMenuService bzjmbMenuService;
	
	@Autowired
	private BzjmbService bzjmbService;
	
	/*风控方案信息管理service*/
	@Autowired
	private RiskTempallService riskTempallService;
	
	@Autowired
	private RiskStockService riskStockService;
	
	/*交易Service*/
	@Autowired
    private SimulateStockService simulateStockService;
	
	/*子账户管理service*/
	@Autowired
	private SubzhService subzhService;
	
	// 收费方案管理页面跳转
	@RequestMapping("/feeSchemeList")
	public String feeSchemeList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "8");
		try {
			/*查询收费方案列表*/
			List<FeeschemeMenu> feeschemeMenuList = feeSchemeMenuService.selectAll();
			model.addAttribute("feeschemeMenuList", feeschemeMenuList);
			
			if(feeschemeMenuList != null && feeschemeMenuList.size() > 0){
				Integer feeschemeid = feeschemeMenuList.get(0).getLsh();
				
				PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
				//List<feeScheme> userlist = feeSchemeservice.selectAll();
				FeeSchemeExample example = new FeeSchemeExample();
				example.setOrderByClause(" lsh asc");
				Criteria criteria = example.createCriteria();
				criteria.andFeeschemeidEqualTo(feeschemeid);
				//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
				List<FeeScheme> userlist = feeSchemeService.selectByExample(example);
				PageInfo<FeeScheme> userpage = new PageInfo<FeeScheme>(userlist);
				if(userlist != null && userlist.size() > 0){
				}
				model.addAttribute("userlist", userlist);
				model.addAttribute("userpage", userpage);
			}
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/feeSchemeList";
	}

	// 收费方案列表模糊查询
	@RequestMapping("/selectPageFeeSchemeList")
	public String selectPageFeeSchemeList(String nickname, Integer feeschemeId, Model model) throws UnsupportedEncodingException {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			FeeSchemeExample example = new FeeSchemeExample();
			example.setOrderByClause(" lsh asc");
			Criteria criteria = example.createCriteria();
			if(feeschemeId != null){
				criteria.andFeeschemeidEqualTo(feeschemeId);
			}
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			/*if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andSubzhLike("%" + nickname + "%");
			}*/
			/*if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andIsadminEqualTo(Integer.parseInt(usertype));
			}*/
			List<FeeScheme> userlist = feeSchemeService.selectByExample(example);
			PageInfo<FeeScheme> userpage = new PageInfo<FeeScheme>(userlist);
			
			/*查询收费方案列表*/
			List<FeeschemeMenu> feeschemeMenuList = feeSchemeMenuService.selectAll();
			model.addAttribute("feeschemeMenuList", feeschemeMenuList);
			
			model.addAttribute("nickname", nickname);
			model.addAttribute("feeschemeId", feeschemeId);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/feeSchemeList";
	}

	// 新增收费方案
	@RequestMapping("/addfeeScheme")
	public String addfeeScheme() {
		return "fund/addfeeScheme";
	}
	
	// 编辑收费方案
	@RequestMapping("/editfeeScheme")
	public String editfeeScheme(Integer id, Model model) {
		try {
			if(id != null){
				FeeScheme user = feeSchemeService.selectByPrimaryKey(id);
				if(user != null){//判断交易日时间不可修改  （可修改  15:00-16:30）
					boolean isUpdate = true;//不可修改
					int dayInt = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);//1 7 周末
					int hourInt = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
					int minuteInt = Calendar.getInstance().get(Calendar.MINUTE);
					if(dayInt > 1 && dayInt < 7){
						if(hourInt > 14 && hourInt < 16){
							isUpdate = false;//可修改  15:00-16:30
						} 
						if(hourInt == 16 && minuteInt < 30){
							isUpdate = false;//可修改
						}
					} else {
						isUpdate = false;//可修改
					}
					if(isUpdate) {
						return "fund/feeSchemeList";
					}
				}
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/inputfeeScheme";
	}
	
	// 编辑收费方案
	@RequestMapping("/editfeeSchemeMsg")
	@ResponseBody
	public String editfeeSchemeMsg(FeeschemeMenu user, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			List<FeeschemeMenu> userList = feeSchemeMenuService.isExist(user.getSchemename(), id);
			if(userList != null && userList.size() > 0){
				return "isExist";
			}
			if(id == null){//新增
				user.setAgentzh("1");
			} else {
				user.setLsh(id);
				if(StringUtil.isAnyNullOrEmpty(user.getAgentzh())){
					user.setAgentzh("1");
				}
			}
			int i = feeSchemeMenuService.insertSelective(user);
			if(i > 0){
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			feeSchemeMenuService.deleteByPrimaryKey(user.getLsh());
		}
		
		return "false";
	}
	
	// 编辑收费信息
	@RequestMapping("/editfeeSchemeInfo")
	@ResponseBody
	public String editfeeSchemeInfo(FeeScheme user) {
		/*判断方案名称是否已存在*/
		try {
			if(user != null && user.getLsh() != null){
				int i = feeSchemeService.updateByPrimaryKey(user);
				if(i > 0){
					return "true";
				}
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
		}
		
		return "false";
	}

	// 单个删除
	@RequestMapping("/deletefeeScheme")
	@ResponseBody
	public String deletefeeScheme(Integer id) {
		try {
			feeSchemeService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
	
	// 保证金管理页面跳转
	@RequestMapping("/bzjmbList")
	public String bzjmbList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "9");
		try {
			/*查询保证金方案列表*/
			List<BzjmbMenu> bzjmbMenuList = bzjmbMenuService.selectAll();
			model.addAttribute("bzjmbMenuList", bzjmbMenuList);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<feeScheme> userlist = feeSchemeservice.selectAll();
			BzjmbExample example = new BzjmbExample();
			example.setOrderByClause(" id desc");
			if(bzjmbMenuList != null && bzjmbMenuList.size() > 0){
				com.jcl.pojo.BzjmbExample.Criteria criteria = example.createCriteria();
				criteria.andParentidEqualTo(bzjmbMenuList.get(0).getId());
				
				model.addAttribute("parentid", bzjmbMenuList.get(0).getId());
			}
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<Bzjmb> userlist = bzjmbService.selectByExample(example);
			PageInfo<Bzjmb> userpage = new PageInfo<Bzjmb>(userlist);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询保证金方案列表异常：" + e.getMessage());
		}
		return "fund/bzjmbList";
	}

	// 保证金列表模糊查询
	@RequestMapping("/selectPageBzjmbList")
	public String selectPageBzjmbList(String nickname, String usertype, String marketcode, Model model) throws UnsupportedEncodingException {
		try {
			/*查询保证金方案列表*/
			List<BzjmbMenu> bzjmbMenuList = bzjmbMenuService.selectAll();
			model.addAttribute("bzjmbMenuList", bzjmbMenuList);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			BzjmbExample example = new BzjmbExample();
			example.setOrderByClause(" id desc");
			com.jcl.pojo.BzjmbExample.Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andParentidEqualTo(Integer.parseInt(usertype));
				model.addAttribute("parentid", usertype);
			}
			/*if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andSubzhLike("%" + nickname + "%");
			}*/
			/*if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andIsadminEqualTo(Integer.parseInt(usertype));
			}*/
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andBzjdmLike("%" + nickname + "%");
			}
			if(!StringUtil.isAnyNullOrEmpty(marketcode)){
				criteria.andScEqualTo(Integer.parseInt(marketcode));
			}
			List<Bzjmb> userlist = bzjmbService.selectByExample(example);
			PageInfo<Bzjmb> userpage = new PageInfo<Bzjmb>(userlist);
			model.addAttribute("marketcodeValue", marketcode);
			model.addAttribute("nickname", nickname);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询保证金方案列表异常：" + e.getMessage());
		}
		return "fund/bzjmbList";
	}
	
	// 新增保证金方案
	@RequestMapping("/addBzjmbMenu")
	public String addBzjmbMenu() {
		return "fund/addBzjmbMenu";
	}
	
	// 编辑保证金方案
	@SuppressWarnings("rawtypes")
	@RequestMapping("/editBzjmb")
	public String editBzjmb(Integer id, Model model) {
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
			/*查询保证金方案列表*/
			List<BzjmbMenu> bzjmbMenuList = bzjmbMenuService.selectAll();
			model.addAttribute("bzjmbMenuList", bzjmbMenuList);
			
			if(id != null){
				Bzjmb user = bzjmbService.selectByPrimaryKey(id);
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/inputBzjmb";
	}
	
	// 编辑保证金信息
	@SuppressWarnings("rawtypes")
	@RequestMapping("/editBzjmbMenuMsg")
	@ResponseBody
	public String editBzjmbMenuMsg(HttpSession session, BzjmbMenu user, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			List<BzjmbMenu> userList = bzjmbMenuService.isExist(user.getTitle(), id);
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
			int i = bzjmbMenuService.insertSelective(user);
			if(i > 0){
				try {//新增当前行情下的所有保证金方案
					Map<String, String> msCode = CommonFunc.getHttpCtpMsCode();
					if(msCode != null && msCode.size() > 0){
						Bzjmb result = null;
						String key = "";
						String [] keyArr = null;
						Iterator entries = msCode.entrySet().iterator();
						while (entries.hasNext()) {  
						    Map.Entry entry = (Map.Entry) entries.next();
						    result = new Bzjmb();
						    key = entry.getKey().toString();
						    
						    keyArr = key.split("-");//6AH6-CME,14
						    if(keyArr.length > 1){
						    	result.setBzjdm(keyArr[0]);//品种代码
						    	keyArr = keyArr[1].split(",");//CME,14
						    	result.setSc(Integer.parseInt(keyArr[1]));//市场代码
						    }
						    result.setBzjname(entry.getValue().toString());
						    result.setSqfs(1);
						    result.setBz("CNY");
						    
						    result.setParentid(user.getId());//手续费方案
						    /* if(session.getAttribute(Constant.SESSION_ACCOUNTID) != null){
						    	result.setUserid(Long.parseLong(session.getAttribute(Constant.SESSION_ACCOUNTID).toString()));
							} else {*/
								result.setUserid(1l);
							//}
						    result.setAgentzh("1");
						    log.info("保存收费合约信息状态值:" + bzjmbService.insertSelective(result));
						}
					}
				} catch (Exception ex) {
					log.error("新增当前行情下的所有手续费方案异常：" + ex.getMessage());
				}
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			bzjmbMenuService.deleteByPrimaryKey(user.getId());
		}
		
		return "false";
	}
	
	// 编辑保证金信息
	@RequestMapping("/editBzjmbInfo")
	@ResponseBody
	public WhResult editBzjmbInfo(HttpSession session, Bzjmb user) {
		/*判断方案名称是否已存在*/
		WhResult whResult=new WhResult();
		try {
			if(user != null && user.getId() != null){
				List<Bzjmb> userList = bzjmbService.isExist(user.getBzjdm(), user.getId(), user.getParentid());
				if(userList != null && userList.size() > 0){
					whResult.setStatus(100);
					return whResult;
				}
				int i = bzjmbService.updateByPrimaryKey(user);
				if(i > 0){
					whResult.setStatus(200);
					return whResult;
				}
			} else {
				String key = user.getBzjname();
				if(!StringUtil.isAnyNullOrEmpty(key)){
					Map<String, String> msCode = CommonFunc.getHttpMsCode();
					if(msCode != null && msCode.size() > 0){
						user.setBzjname(msCode.get(key));//名称
					}
					String [] keyArr = key.split("-");//6AH6-CME,14
				    if(keyArr.length > 1){
				    	user.setBzjdm(keyArr[0]);//品种代码
				    }
				    keyArr = key.split(",");
				    if(keyArr.length > 1){
				    	user.setSc(Integer.parseInt(keyArr[1]));//市场
				    }
				}
				user.setAgentzh("1");
				/*if(session.getAttribute(Constant.SESSION_ACCOUNTID) != null){
					user.setUserid(Long.parseLong(session.getAttribute(Constant.SESSION_ACCOUNTID).toString()));
				} else {*/
					user.setUserid(1l);
				//}
				List<Bzjmb> userList = bzjmbService.isExist(user.getBzjdm(), null, user.getParentid());
				if(userList != null && userList.size() > 0){
					whResult.setStatus(100);
					return whResult;
				}
				int i = bzjmbService.insertSelective(user);
				if(i > 0){
					whResult.setStatus(200);
					return whResult;
				}
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		return whResult;
	}
	
	// 单个删除
	@RequestMapping("/deleteBzjmb")
	@ResponseBody
	public String deleteBzjmb(Integer id) {
		try {
			int i = bzjmbService.deleteByPrimaryKey(id);
			if(i > 0){
				return "true";
			}
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "false";
	}
	
	// 某个方案
	@RequestMapping("/deleteBzjmbMenu")
	@ResponseBody
	public String deleteBzjmbMenu(Integer id) {
		try {
			if(id==null){
				return "false";
			}
			Subzh subzh=new Subzh();
			subzh.setMarginset(id.toString());
			List<Subzh> list=subzhservice.getFanganSubzh(subzh);
			if(list!=null && list.size()>0){//如果有交易用户关联到此手续费方案
				return "hassub";
			}else{
				int i = bzjmbMenuService.deleteByPrimaryKey(id);
				int j=bzjmbService.deleteByParent(id);
				if(i > 0){
					return "true";
				}
			}
			
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "false";
	}
	
	//批量修改
	@RequestMapping("/updateBzjmbMore")
	public String updateBzjmbMore(Model model, String codefeesetIds) {
		try {
			model.addAttribute("codefeesetIds", codefeesetIds);
		} catch (Exception e) {
			log.error("查询异常："+e.getMessage());
		}
		return "fund/updateBzjmb";
	}
	
	// 编辑保证金方案
	@RequestMapping("/editBzjmbMsgMore")
	@ResponseBody
	public String editBzjmbMsgMore(HttpSession session, Bzjmb user, String codefeesetIds) {
		/*判断方案名称是否已存在*/
		try {
			if(!StringUtil.isAnyNullOrEmpty(codefeesetIds)){//修改
				String [] strId = codefeesetIds.split(",");
				Bzjmb userTemp = null;
				for(int i = 0; i < strId.length; i++){
					userTemp = bzjmbService.selectByPrimaryKey(Integer.parseInt(strId[i]));
					if(userTemp != null){
						userTemp.setTjdtbzj1(user.getTjdtbzj1());
						userTemp.setTjdtbzj2(user.getTjdtbzj2());
						userTemp.setTjktbzj1(user.getTjktbzj1());
						userTemp.setTjktbzj2(user.getTjktbzj2());
						log.info("更新保证金合约记录：" + bzjmbService.updateByPrimaryKey(userTemp));
					}
				}
			}
			return "true";
		} catch (Exception es) {
			log.error("查询异常：" + es.getMessage());
		}
		return "false";
	}
	
	// 风控方案管理页面跳转
	@RequestMapping("/riskTemplateList")
	public String riskTemplateList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "10");
		try {
			/*查询收费方案列表*/
			List<RiskTempall> menuList = riskTempallService.selectAll();
			model.addAttribute("menuList", menuList);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<feeScheme> userlist = feeSchemeservice.selectAll();
			RiskTempallExample example = new RiskTempallExample();
			example.setOrderByClause(" id desc, modifytime desc");
			//com.jcl.pojo.RiskTempallExample.Criteria criteria = example.createCriteria();
			//criteria.andTypeEqualTo("3");//
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<RiskTempall> userlist = riskTempallService.selectByExample(example);
			PageInfo<RiskTempall> userpage = new PageInfo<RiskTempall>(userlist);
			
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/riskTemplateList";
	}
	
	

	// 风控方案列表模糊查询
	@RequestMapping("/selectPageRiskTemplateList")
	public String selectPageRiskTemplateList(String nickname, String usertype, Model model) throws UnsupportedEncodingException {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			RiskTempallExample example = new RiskTempallExample();
			example.setOrderByClause(" id desc, modifytime desc");
			com.jcl.pojo.RiskTempallExample.Criteria criteria = example.createCriteria();
			model.addAttribute("nickname", nickname);
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				nickname = "%" + nickname + "%";
				criteria.andTypeLike(nickname);
			}
			if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andIdEqualTo(Integer.parseInt(usertype));
				model.addAttribute("usertypeValue", usertype);
			}
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<RiskTempall> userlist = riskTempallService.selectByExample(example);
			PageInfo<RiskTempall> userpage = new PageInfo<RiskTempall>(userlist);
			
			/*查询收费方案列表*/
			List<RiskTempall> menuList = riskTempallService.selectAll();
			model.addAttribute("menuList", menuList);
			
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "fund/riskTemplateList";
	}
	
	// 新增风控方案
	@RequestMapping("/addRiskTempall")
	public String addRiskTempall() {
		return "fund/addRiskTempall";
	}
	
	// 编辑风控方案
	@RequestMapping("/editRiskTempall")
	public String editRiskTempall(Integer id, Model model) {
		try {
			if(id != null){
				RiskTempall user = riskTempallService.selectByPrimaryKey(id);
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/addRiskTempall";
	}
	
	// 编辑风控信息
	@RequestMapping("/editRiskTempallMsg")
	@ResponseBody
	public String editRiskTempallMsg(HttpSession session, RiskTempall user, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			List<RiskTempall> userList = riskTempallService.isExist(user.getType(), id);
			if(userList != null && userList.size() > 0){
				return "isExist";
			}
			if(id == null){//新增
				user.setAgentzh("1");
			} else {
				user.setId(id);
				if(StringUtil.isAnyNullOrEmpty(user.getAgentzh())){
					user.setAgentzh("1");
				}
			}
			user.setModifytime(Calendar.getInstance().getTime());
			if(user.getNewstock() == null){
				user.setNewstock(0);
			}
			if(user.getNewstockDay() == null){
				user.setNewstockDay(0);
			}
			if(user.getRubbishstock() == null){
				user.setRubbishstock(0);
			}
			if(user.getBusinessplate() == null){
				user.setBusinessplate(0);
			}
			if(user.getIneLimit() == null){
				user.setIneLimit(0);
			}
			int i = 0;
			if(id == null){
				i = riskTempallService.insertSelective(user);
			} else {
				i = riskTempallService.updateByPrimaryKey(user);
			}
			if(i > 0){
				try {
					String rbStr = simulateStockService.commonFunction("{\"risk_id\":"+user.getId()+"}", DefineNumber.JCL_PROTOCOL_ID_REQ_RISKTEMPCATE);
					log.info("通知柜台重新加载风控协议:" + rbStr);
				} catch (Exception e) {
					log.error("通知柜台重新加载风控协议异常：" + e.getMessage());
				}
				return "true";
			}
		} catch (Exception es) {
			log.error("查询风控方案名称是否已存在异常：" + es.getMessage());
			riskTempallService.deleteByPrimaryKey(user.getId());
		}
		
		return "false";
	}
	
	// 风控方案 - 个股设置管理页面跳转
	@RequestMapping("/riskStockList")
	public String riskStockList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "10");
		try {
			List<RiskTempall> menulist = riskTempallService.selectAll();
			model.addAttribute("menulist", menulist);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<feeScheme> userlist = feeSchemeservice.selectAll();
			RiskStockExample example = new RiskStockExample();
			example.setOrderByClause(" id desc");
			com.jcl.pojo.RiskStockExample.Criteria criteria = example.createCriteria();
			if(menulist != null && menulist.size() > 0){
				criteria.andParentidEqualTo(menulist.get(0).getId());
				criteria.andTypeEqualTo(1);//类型  1：白名单
			}
			List<RiskStock> userlist = riskStockService.selectByExample(example);
			PageInfo<RiskStock> userpage = new PageInfo<RiskStock>(userlist);
			
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询风控方案-个股设置列表异常：" + e.getMessage());
		}
		return "fund/riskStockList";
	}

	// 风控方案列表模糊查询
	@RequestMapping("/selectPageRiskStockList")
	public String selectPageRiskStockList(String nickname, Integer parentid, String usertype, Model model) throws UnsupportedEncodingException {
		try {
			List<RiskTempall> menulist = riskTempallService.selectAll();
			model.addAttribute("menulist", menulist);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			RiskStockExample example = new RiskStockExample();
			example.setOrderByClause(" id desc");
			com.jcl.pojo.RiskStockExample.Criteria criteria = example.createCriteria();
			model.addAttribute("nickname", nickname);
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				nickname = "%" + nickname + "%";
				criteria.andStockcodeLike(nickname);
			}
			criteria.andParentidEqualTo(parentid);
			criteria.andTypeEqualTo(Integer.parseInt(usertype));//类型  1：白名单
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<RiskStock> userlist = riskStockService.selectByExample(example);
			PageInfo<RiskStock> userpage = new PageInfo<RiskStock>(userlist);
			
			model.addAttribute("parentid", parentid);
			model.addAttribute("usertype", usertype);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询风控方案-个股设置列表异常：" + e.getMessage());
		}
		return "fund/riskStockList";
	}
	
	
	// 风控方案 - 个股设置管理页面跳转
	@RequestMapping("/inputRiskStock")
	public String inputRiskStock(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "10");
		try {
			List<RiskTempall> menulist = riskTempallService.selectAll();
			model.addAttribute("menulist", menulist);
			
		} catch (Exception e) {
			log.error("查询风控方案-个股设置列表异常：" + e.getMessage());
		}
		session.setAttribute("sessionToken", "6aa35341f25184fd996c4c918255c3a1");
		return "fund/inputRiskStock";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/importStock")
	public String importStock(@RequestParam("file")MultipartFile file, HttpServletRequest request, Model model) {
		String sessionToken = request.getSession().getAttribute("sessionToken").toString();
		String menuId = request.getParameter("menuId");
		if("6aa35341f25184fd996c4c918255c3a1".equals(sessionToken) && !file.isEmpty()){
			try {			
				CommonsMultipartFile cf = (CommonsMultipartFile)file; 
				DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
				File fil = fi.getStoreLocation();
				String[] strs={"XLS","XLSX"};
				FileUtil._strAllowdFileExts = strs;
				/*开始行、开始列*/
				int startRow = 2;
				int startColumn = 1;
				/*添加Excel数据*/
				FileUploadPathObject uploadPathObject = FileUtil.uploadProjectLocal("excel", fil, "excel_"+System.currentTimeMillis()+".xlsx");
				/*判断上传地址不为空*/
				if (uploadPathObject != null){
					List<List<String>> listData = null;	
					InputStream is = new FileInputStream(fil);
					Workbook workbook = WorkbookFactory.create(fil);
					Sheet sheet = workbook.getSheetAt(0);
					int index = 1;
					Boolean flag = true;
					String paramId = request.getParameter("paramId");
					//String menuId = request.getParameter("menuId");
					boolean informFlag = false;
					/*更新风控全局设置 风控模板类型  1:白名单  2:黑名单  3:持仓比例 其他:其他*/
					if(StringUtil.isAnyNullOrEmpty(paramId)){
						paramId = "1";//白名单
					}
					if(!StringUtil.isAnyNullOrEmpty(menuId)) {
						RiskTempall riskTempall = riskTempallService.selectByPrimaryKey(Integer.parseInt(menuId));
						if(riskTempall != null){
							informFlag = true;
						}
					}
					
					int exceptionRow = 0;
					String exceptionDate = "";
					RiskStock ruleInfo = null;
					
					while (flag) {
						Row row = sheet.getRow(index++);
						if (row == null)
							break;
						Cell cell0= row.getCell(0);
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						
						Cell cell1 = row.getCell(1);
						cell1.setCellType(Cell.CELL_TYPE_STRING);				
						ruleInfo = new RiskStock();
						ruleInfo.setStockcode(cell0.getStringCellValue());
						ruleInfo.setStockname(cell1.getStringCellValue());
						ruleInfo.setParentid(Integer.parseInt(menuId));
						ruleInfo.setType(Integer.parseInt(paramId));//个股设置规则 添加字段类型  1：白名单 2：黑名单
						exceptionRow = exceptionRow + 1;
						Boolean isFlag = true;
						try {
							if(isFlag){
								/*保存用户数据*/
								/*判断用户名是否存在*/
								List<RiskStock> stockList = riskStockService.isExist(Integer.parseInt(menuId), Integer.parseInt(paramId), ruleInfo.getStockcode());
								if(stockList == null || stockList.size() == 0){
									riskStockService.insertSelective(ruleInfo);
								} else {
									log.info("名单已存在，股票代码->" + ruleInfo.getStockcode() + " 模板ID->" + menuId);
								}
							} else {
								break;
							}
						} catch (Exception e) {
							log.error("名单已存在，股票代码->" + ruleInfo.getStockcode() + " 模板ID->" + menuId + 
							" 上传excel中第" + (exceptionRow + (startRow-1)) + "行数据字段长度过大或字段类型不匹配！" + exceptionDate + e.getMessage());
						}
					}
					
					/*加载风控*/
					if(informFlag){
						log.info("通知柜台重新加载风控:" + informRiskTempall(menuId));
					}
				}
				
				request.getSession().setAttribute("sessionToken", "");
			} catch (Exception e) {
				log.error("导入个股设置数据异常：" + e.getMessage());
			}
		}
		
		try {
			List<RiskTempall> menulist = riskTempallService.selectAll();
			model.addAttribute("menulist", menulist);
			
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<feeScheme> userlist = feeSchemeservice.selectAll();
			RiskStockExample example = new RiskStockExample();
			example.setOrderByClause(" id desc");
			com.jcl.pojo.RiskStockExample.Criteria criteria = example.createCriteria();
			if(menulist != null && menulist.size() > 0){
				criteria.andParentidEqualTo(menulist.get(0).getId());
				criteria.andTypeEqualTo(1);//类型  1：白名单
			}
			if(!StringUtil.isAnyNullOrEmpty(menuId)){
				criteria.andIdEqualTo(Integer.parseInt(menuId));
				model.addAttribute("parentid", menuId);
			}
			List<RiskStock> userlist = riskStockService.selectByExample(example);
			PageInfo<RiskStock> userpage = new PageInfo<RiskStock>(userlist);
			
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
			request.getSession().setAttribute("sessionToken", "6aa35341f25184fd996c4c918255c3a1");
		} catch (Exception e) {
			log.error("查询风控方案-个股设置列表异常：" + e.getMessage());
		}
		
		return "fund/riskStockList";
	}
	
	/*通知柜台重新加载风控*/
	public String informRiskTempall(String tempallId) {
		try {//查询哪些账户使用此风控
			SubzhExample example = new SubzhExample();
			example.setOrderByClause(" khdate desc");
			com.jcl.pojo.SubzhExample.Criteria criteria = example.createCriteria();
			criteria.andRisksetEqualTo(Integer.parseInt(tempallId));
			List<Subzh> subzhList = subzhService.selectByExample(example);
			if(subzhList != null && subzhList.size() > 0){
				for(Subzh subzh : subzhList){
					try {
						String rbStr = simulateStockService.commonFunction("{\"all\":false,\"risk_id\":"+tempallId+",\"client_id\":\""+subzh.getSubzh()+"\"}", 
								DefineNumber.JCL_PROTOCOL_ID_REQ_RISKTEMPCATE);
						log.info("通知柜台重新加载风控协议:" + rbStr);
					} catch (Exception eload) {
						log.error("通知柜台重新加载此账户风控协议异常：subzh->" + subzh.getSubzh() + eload.getMessage());
					}
				}
			}
		} catch (Exception es) {
			log.error("通知柜台重新加载风控异常：tempallId->" + tempallId + es.getMessage());
		}
		return null;
	}
		
	// 单个删除
	@RequestMapping("/deleteRiskTempall")
	@ResponseBody
	public String deleteRiskTempall(Integer id) {
		try {
			if(id==null){
				return "false";
			}
			Subzh subzh=new Subzh();
			subzh.setRiskset(id);
			List<Subzh> list=subzhservice.getFanganSubzh(subzh);
			if(list!=null && list.size()>0){//如果有交易用户关联到此手续费方案
				return "hassub";
			}else{
				int i = riskTempallService.deleteByPrimaryKey(id);
				if(i > 0){
					return "true";
				}
			}
			
		} catch (Exception e) {
			log.error("删除风控方案 - 个股设置异常：" + e.getMessage());
			return "false";
		}
		return "false";
	}
	
	// 单个删除名单
	@RequestMapping("/deleteRiskStock")
	@ResponseBody
	public String deleteRiskStock(Integer id) {
		try {
			if(id == null){
				return "false";
			}
			RiskStock riskStock = riskStockService.selectByPrimaryKey(id);
			int i = riskStockService.deleteByPrimaryKey(id);
			if(i > 0){
				try {
					String rbStr = simulateStockService.commonFunction("{\"risk_id\":"+riskStock.getParentid()+"}", 
							DefineNumber.JCL_PROTOCOL_ID_REQ_RISKTEMPCATE);
					log.info("通知柜台重新加载风控协议:" + rbStr);
				} catch (Exception eload) {
					log.error("通知柜台重新加载此账户风控协议异常：risk_id->" + eload.getMessage());
				}
				return "true";
			}
		} catch (Exception e) {
			log.error("删除风控方案 - 个股设置异常：" + e.getMessage());
			return "false";
		}
		return "false";
	}
	
	public FeeScheme getFeeScheme() {
		return feeScheme;
	}

	public void setFeeScheme(FeeScheme feeScheme) {
		this.feeScheme = feeScheme;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	
}