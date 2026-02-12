package com.lamda.payment;

public class Payment {
	public Payment(String paymentId, double amount, Status status, String reference) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
		this.reference = reference;
	}

	

	private String paymentId;
	private double amount;
	private Status status;
	private String reference;
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", status=" + status + ", reference="
				+ reference + "]";
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public enum Status{
		 ACTIVE, EXPIRED;
	}

}
