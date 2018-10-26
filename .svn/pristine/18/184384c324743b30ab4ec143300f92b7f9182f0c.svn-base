/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @ContractController.java
 * 功能概要  : 
 * 做成日期  : @2018年5月8日
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.jcl.pojo.RiskContract;
import com.jcl.service.RiskContractService;
import com.jcl.stock.simulate.StringUtil;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;


/** 
 * @author zpf
 * @version 1.0
 */
@RequestMapping("/contract")
@Controller
public class ContractController {
	
	public static Logger log = Logger.getLogger(ContractController.class);
	
	//注入合约的服务层
	@Autowired
	private RiskContractService riskcontractServiceImpl;

	
	@RequestMapping("/queryAll")
	public String queryContractAll(Model model,HttpSession session,RiskContract contract){
		session.setAttribute(Constant.SESSION_LEFTMENU, "18");
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<RiskContract> clist =riskcontractServiceImpl.queryContractAll(contract);
			PageInfo<RiskContract> userpage = new PageInfo<RiskContract>(clist);
			List<RiskContract> orderlist=new ArrayList<RiskContract>();
			if((clist==null || clist.size()==0) && (contract==null || StringUtil.isAnyNullOrEmpty(contract.getContractName()))){
				clist = new ArrayList<RiskContract>();
				Map<String, String> msCode = CommonFunc.getHttpMsCode();
				if(msCode != null && msCode.size() > 0){
					int size=0;
					RiskContract result = null;
					String key = "";
					String [] keyArr = null;
					Iterator<Map.Entry<String, String>> entries = msCode.entrySet().iterator();
					while (entries.hasNext()) {  
					    Map.Entry<String, String> entry = entries.next();
					    result = new RiskContract();
					    key = entry.getKey().toString();
					    log.info("从合约中查到的："+key);
					   // result.setKey(key);
					    keyArr = key.split("-");//6AH6-CME,14
					    if(keyArr.length > 1){
					    	result.setContractCode(keyArr[0]);//品种代码
					    	keyArr = keyArr[1].split(",");//CME,14
					    	//result.setMarketCode(keyArr[0]);//市场代码
					    	result.setExchangeName(keyArr[1]);
					    	System.out.println("1index:"+keyArr[0]);
					    }
					    result.setContractName(entry.getValue());//合约名称
					    result.setContractdetail(new BigDecimal("0"));
					    result.setMinchangeprice(new BigDecimal("0"));
					    result.setUnit("CNY");
					    log.info("从合约中查到的：ContractCode"+result.getContractCode()+",name:"+result.getContractName());
					    size++;
					    if(size<=400){
					    	clist.add(result);
					    }else{
					    	orderlist.add(result);
					    }
					}
					
				}
				if(clist.size()>0){//批量插入数据
					int count1=riskcontractServiceImpl.insertBatchContract(clist);
					System.out.println("count1:"+count1);
				}
				if(orderlist.size()>0){//批量插入数据
					int count2=riskcontractServiceImpl.insertBatchContract(orderlist);
					System.out.println("count2:"+count2);
					clist.addAll(orderlist);
				}
				userpage = new PageInfo<RiskContract>(clist);
			}
			
			model.addAttribute("co", contract);
			if(clist!=null && clist.size()>0){
				log.info("遍历取合约数量");
				Map<String,String> map=getMapper();
				for(RiskContract contract2:clist){
					String market=contract2.getExchangeName();
					if(map.containsKey(market)){
						market=map.get(market);
					}
					contract2.setMarket(market);
				}
			}
			//向页面返回数据
			model.addAttribute("clist", clist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
			
		return "fund/contractList";
	}
	//去修改一个
	@RequestMapping("/toupdate")
	public String toupdate(Model model,String cid) {
		try {
			if(cid!=null&&cid!=""){
				RiskContract contract=riskcontractServiceImpl.queryByID(cid);
				model.addAttribute("con", contract);
			}
		} catch (Exception e) {
			log.error("toupdate_查询账户列表异常："+e.getMessage());
		}
	
		return "fund/updatecontract";
	}
	
	//去批量修改
	@RequestMapping("/toupdateAll")
	public String toupdateAll(Model model,String cids) {
		try {
			model.addAttribute("cids", cids);
		} catch (Exception e) {
			log.error("update查询账户列表异常："+e.getMessage());
		}
		return "fund/updatecontract";
	}
	
	//修改一个
	@RequestMapping("/update")
	@ResponseBody
	public int update(Model model,RiskContract con,String data) {
		int num=0;
		try {
			Date date = DateUtil.stringToDate(data, "yyyy-MM-dd");
			con.setPromptDay(date);
			num=riskcontractServiceImpl.updatebyCid(con);
		} catch (Exception e) {
			log.error("update查询账户列表异常："+e.getMessage());
		}
		return num;
	}
	
	//批量修改
	@RequestMapping("/updateAll")
	@ResponseBody
	public int updateAll(Model model,String cids,RiskContract con,String data) {
		int num=0;
		try {
			cids =cids.substring(0, cids.length()-1);
			String arr []=cids.split(",");
			for (String i : arr) {
				Date date = DateUtil.stringToDate(data, "yyyy-MM-dd");
				con.setPromptDay(date);
				con.setContractCode(i);
				num+=riskcontractServiceImpl.updatebyCid(con);
			}
		} catch (Exception e) {
			log.error("updateAll查询账户列表异常：", e);
		}
		
		return num;
	}
	
	//去添加
	@RequestMapping("/toadd")
	public String toadd(Model model) {
		List<RiskContract> clist =riskcontractServiceImpl.queryContractAll(null);
		List<RiskContract> accesslist=new ArrayList<RiskContract>();
		try {
			Map<String, String> msCode = CommonFunc.getHttpMsCode();
			if(msCode != null && msCode.size() > 0){
				int size=0;
				RiskContract result = null;
				String key = "";
				String [] keyArr = null;
				Iterator<Map.Entry<String, String>> entries = msCode.entrySet().iterator();
				while (entries.hasNext()) {  
				    Map.Entry<String, String> entry = entries.next();
				    result = new RiskContract();
				    key = entry.getKey().toString();
				    keyArr = key.split("-");//6AH6-CME,14
				    if(keyArr.length > 1){
				    	result.setContractCode(keyArr[0]);//品种代码
				    	keyArr = keyArr[1].split(",");//CME,14
				    	//result.setMarketCode(keyArr[0]);//市场代码
				    	result.setExchangeName(keyArr[1]);
				    }
				    result.setVarietyCode(key);//6AH6-CME,14
				    result.setContractName(entry.getValue());//合约名称
				    result.setUnit("CNY");
				    int ishas=0;//判断此合约是否已经加到数据库中了。
				    for(RiskContract rc:clist){
				    	if(rc.getContractCode().equals(result.getContractCode())){
				    		ishas=1;
				    		break;
				    	}
				    }
				    if(ishas==0){//此合约未入库，可以新增到库中
				    	accesslist.add(result);
				    }
				}
				
			}
			if(accesslist.size()>0){
				model.addAttribute("clist", accesslist);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "fund/addContract";
	}
	
	//修改一个
	@RequestMapping("/add")
	@ResponseBody
	public int add(RiskContract con,String data) {
		int num=0;
		try {
			Date date = DateUtil.stringToDate(data, "yyyy-MM-dd");
			con.setPromptDay(date);
			con.setPublicDay(new Date());
			num=riskcontractServiceImpl.addriskcontract(con);
		} catch (Exception e) {
			log.error("add-查询账户列表异常：", e);
		}
		return num;
	}

	
	
	//导入excel
	@RequestMapping("/upload")
	@ResponseBody
	public int detailupload(@RequestParam("file") MultipartFile uploadFile) {
		int num =0;
		FileUploadPathObject uploadPathObject;
		try {
			
			CommonsMultipartFile cf = (CommonsMultipartFile) uploadFile;
			DiskFileItem fi = (DiskFileItem) cf.getFileItem();
			File file = fi.getStoreLocation();
			InputStream is = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			int index = 1;
			Boolean flag = true;
			while (flag) {
				Row row = sheet.getRow(index++);
				if (row == null)
					break;
				Cell cell0= row.getCell(0);
				cell0.setCellType(Cell.CELL_TYPE_STRING);
				
				Cell cell1 = row.getCell(1);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				
				Cell cell2 = row.getCell(2);
				cell2.setCellType(Cell.CELL_TYPE_STRING);
				
				Cell cell3 = row.getCell(3);
				cell3.setCellType(Cell.CELL_TYPE_NUMERIC);
				
				Cell cell4 = row.getCell(4);
				cell4.setCellType(Cell.CELL_TYPE_NUMERIC);
				
				RiskContract contract = new RiskContract();
				contract.setContractCode(cell0.getStringCellValue());
				contract.setContractName(cell1.getStringCellValue());
				contract.setExchangeName(cell2.getStringCellValue());
				contract.setContractdetail(BigDecimal.valueOf(cell3.getNumericCellValue()));
				contract.setMinchangeprice(BigDecimal.valueOf(cell4.getNumericCellValue()));
				contract.setUnit("CNY");
				contract.setVarietyCode("aaaa");
				contract.setPromptDay(new Date());
				contract.setPublicDay(new Date());
				num=riskcontractServiceImpl.addriskcontract(contract);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return num;
	}
	
	//弹出一个批量修改的页面
	@RequestMapping("/todel")
	public String todel() {
		
		return "fund/delconract";	
	}
	
	//批量删除的是时的查询
	@RequestMapping("/queryBy")
	public String queryBy(Model model,String keywords) {
		try {
		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		List<RiskContract> rlist=riskcontractServiceImpl.queryByTime(keywords);
		PageInfo<RiskContract> userpage = new PageInfo<RiskContract>(rlist);
		
		if(rlist!=null && rlist.size()>0){
			log.info("queryBy遍历取合约数量");
			Map<String,String> map=getMapper();
			for(RiskContract contract2:rlist){
				String market=contract2.getExchangeName();
				if(map.containsKey(market)){
					market=map.get(market);
				}
				contract2.setMarket(market);
			}
		}
		model.addAttribute("userpage", userpage);
		model.addAttribute("rlist", rlist);
		model.addAttribute("keywords", keywords);
		} catch (Exception e) {
			log.error("queryBy_查询菜单列异常", e);
		}
		return "fund/delconract";
	}
	@RequestMapping("/delAll")
	@ResponseBody
	public int delAll(String cids) {
		int num = 0;
		try {
		num=riskcontractServiceImpl.deleteAllBycode(cids);
		} catch (Exception e) {
			log.error("delAll-删除合约列表异常",e);
		}
		return num;
	}
	
	public Map<String,String> getMapper(){
		Map<String,String> data=new HashMap<String,String>();
		data.put("0", "深圳证券交易所");
		data.put("1", "上海证券交易所");
		data.put("2", "香港证券交易所");
		data.put("3", "中国金融期货交易所");
		data.put("4", "上海期货交易所");
		data.put("5", "大连商品交易所");
		data.put("6", "郑州商品交易所");
		data.put("7", "天津渤海商品交易所");
		data.put("8", "上海黄金交易所");
		data.put("9", "伦敦黄金交易市场");
		data.put("10", "天津贵金属交易所");
		data.put("11", "外汇市场");
		data.put("12", "福建海峡文化产权交易所");
		data.put("15", "国际期货交易市场");
		data.put("16", "香港期货交易所");
		data.put("20", "通用市场");
		data.put("24", "上海国际能源交易中心");
		return data;
	}
}
