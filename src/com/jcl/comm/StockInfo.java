package com.jcl.comm;

    /**        
     * Title: StockInfo.java    
     * Description: 个股的信息
     * @author zhuj       
     * @created 2015-5-28 下午1:44:08    
     */      
    
public class StockInfo {
    private float openPrice;//今开
    private float closePrice;//昨收
    private float highPrice;//最高
    private float lowPrice;//最低
    private float newPrice;//最新价
    private int dealNum;//成交量
    private float dealFund;//成交额
    private float volumeRatio;//量比
    private float exchangeRate;//换手率
    private float swing;//振幅
    private int invol;//内盘
    private int outvol;//外盘
    private float peRatio;//市盈率
    private String marketValue;//流通市值
    
    private float avePrice;//均价
    private float committee;//委比
    private float commission;//委差
    private float cityNet;//市净
    private float equity;//流通股本
    private float equityTotal;//总股本
    
    
    
	public float getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}
	public float getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(float closePrice) {
		this.closePrice = closePrice;
	}
	public float getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(float highPrice) {
		this.highPrice = highPrice;
	}
	public float getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(float lowPrice) {
		this.lowPrice = lowPrice;
	}
	public float getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}
	public int getDealNum() {
		return dealNum;
	}
	public void setDealNum(int dealNum) {
		this.dealNum = dealNum;
	}
	public float getDealFund() {
		return dealFund;
	}
	public void setDealFund(float dealFund) {
		this.dealFund = dealFund;
	}
	public float getVolumeRatio() {
		return volumeRatio;
	}
	public void setVolumeRatio(float volumeRatio) {
		this.volumeRatio = volumeRatio;
	}
	public float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public float getSwing() {
		return swing;
	}
	public void setSwing(float swing) {
		this.swing = swing;
	}
	public int getInvol() {
		return invol;
	}
	public void setInvol(int invol) {
		this.invol = invol;
	}
	public int getOutvol() {
		return outvol;
	}
	public void setOutvol(int outvol) {
		this.outvol = outvol;
	}
	public float getPeRatio() {
		return peRatio;
	}
	public void setPeRatio(float peRatio) {
		this.peRatio = peRatio;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public float getAvePrice() {
		return avePrice;
	}
	public void setAvePrice(float avePrice) {
		this.avePrice = avePrice;
	}
	public float getCommittee() {
		return committee;
	}
	public void setCommittee(float committee) {
		this.committee = committee;
	}
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	public float getCityNet() {
		return cityNet;
	}
	public void setCityNet(float cityNet) {
		this.cityNet = cityNet;
	}
	public float getEquity() {
		return equity;
	}
	public void setEquity(float equity) {
		this.equity = equity;
	}
	public float getEquityTotal() {
		return equityTotal;
	}
	public void setEquityTotal(float equityTotal) {
		this.equityTotal = equityTotal;
	}
    
    
}
