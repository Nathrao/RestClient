package com.bank;

public class RestClientRunner {

	public static void main(String[] args) {
		BankAPITest bankDetailServiceImpl=new BankAPITest();
		bankDetailServiceImpl.getAccountStatus();
		bankDetailServiceImpl.getBankName();
		bankDetailServiceImpl.getAccountBalance();
	}
}
