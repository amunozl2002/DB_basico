package model;

public class Payments {
	private Integer customerNumber;
	private String checkNumber;
	private String paymentDate;
	private Double amount;
	
	public Payments() {}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payments [CustomerNumber=" + getCustomerNumber() + ", CheckNumber=" + getCheckNumber() + ", PaymentDate=" + getPaymentDate() + ", Amount=" + getAmount() + "]";
	}
	
}