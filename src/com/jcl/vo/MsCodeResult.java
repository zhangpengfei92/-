package com.jcl.vo;

import java.io.Serializable;

/**        
 * Title: MsCodeResult.java    
 * Description: 猛士代码链实体展示
 * @author jiangzq 
 * @created 2017-08-21    
 */      
public class MsCodeResult implements Serializable, Comparable<MsCodeResult>{
	
	private static final long serialVersionUID = 8634484077996263523L;
	
	private String key;    //key
	private String showkey;    //展示key
    private String codeName;   //品种名称
    private String code; 	   // 证券代码
    private String market;     // 市场
    private String marketCode; // 市场代码
    
    private String unit;//小数位数
    private double minchangeprice;//
	
    public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
    public String getShowkey() {
		return showkey;
	}
	public void setShowkey(String showkey) {
		this.showkey = showkey;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public double getMinchangeprice() {
		return minchangeprice;
	}
	public void setMinchangeprice(double minchangeprice) {
		this.minchangeprice = minchangeprice;
	}
	
	
	@Override
	public int compareTo(MsCodeResult o) {
		//return this.getMarket().compareTo(o.getMarket());
		return this.getCodeName().compareTo(o.getCodeName());
	}
   
}