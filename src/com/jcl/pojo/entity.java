package com.jcl.pojo;

public enum entity {
	
	PAYMENT_APPLY("APPLY", "付款申请"), PAYMENT_CHECK("CHECK", "复核申请"), PAYMENT_DEALING("PROCESSING", "付款处理中"), PAYMENT_SUCCESS(
			"SUCCESS", "付款成功"), PAYMENT_FAILURE("FAILURE", "付款失败"), PAYMENT_RETURN("CANCEL", "退款"), PAYMENT_CLOSED(
			"CLOSED", "订单关闭");

	private String value;

	private String desc;


	private entity(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static void main(String[] args) {
		entity paymentCheck = entity.PAYMENT_CHECK;
		System.out.println(paymentCheck.value);
	}
}
