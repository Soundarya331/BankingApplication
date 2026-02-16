package com.multithreading.telecom;

public class CallRequest {
	
	public CallRequest(String requestId, long phoneNumber, int minutes) {
		super();
		this.requestId = requestId;
		this.phoneNumber = phoneNumber;
		this.minutes = minutes;
	}
	private String requestId ;
   private  long   phoneNumber;
   private int  minutes;
   public String getRequestId() {
	return requestId;
   }
   public void setRequestId(String requestId) {
	this.requestId = requestId;
   }
   public long getPhoneNumber() {
	return phoneNumber;
   }
   public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
   }
   public int getMinutes() {
	return minutes;
   }
   public void setMinutes(int minutes) {
	this.minutes = minutes;
   }

}
