package com.productreport;

public class ProductReport {
	
	private String prodName;
	private int orderCount;
	private double totalRevenue;
	public ProductReport(String prodName, int orderCount, double totalRevenue) {
		super();
		this.prodName = prodName;
		this.orderCount = orderCount;
		this.totalRevenue = totalRevenue;
	}
	public String getProdName() {
		return prodName;
	}
	@Override
	public String toString() {
		return "ProductReport [prodName=" + prodName + ", orderCount=" + orderCount + ", totalRevenue=" + totalRevenue
				+ "]";
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	

}
