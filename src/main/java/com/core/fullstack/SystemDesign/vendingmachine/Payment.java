package com.core.fullstack.SystemDesign.vendingmachine;

public class Payment {
	
	private Double amount;
	private PaymentType paymentType;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
