package com.bank;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.barclays.common.beans.Bank;

public class BankAPITest {
	public static String GET_BANK_ACCOUNT_STATUS_SERVICE_ENDPOINT = "http://localhost:9091/RestDemo/BankDetails/accountStatus?accNumberParam";
	public static String GET_BANK_ACCOUNT_BALANCE_SERVICE_ENDPOINT = "http://localhost:9091/RestDemo/BankDetails/check-balance";
	public static String GET_BANK_NAME_SERVICE_ENDPOINT = "http://localhost:9091/RestDemo/BankDetails/BankName/name";


	public String getBankName() {
		HttpHeaders headers = new HttpHeaders();
		GET_BANK_NAME_SERVICE_ENDPOINT = GET_BANK_NAME_SERVICE_ENDPOINT.replace("name", "Barclays");
		String result = RestClient.exchange(GET_BANK_NAME_SERVICE_ENDPOINT, headers, "GET",null);
		System.out.println(result);
		return null;
	}

	public String getAccountStatus() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(MediaType.parseMediaTypes(MediaType.APPLICATION_JSON_VALUE));
		String accNumberParam = "accNumber="+"123";
		GET_BANK_ACCOUNT_STATUS_SERVICE_ENDPOINT = GET_BANK_ACCOUNT_STATUS_SERVICE_ENDPOINT.replace("accNumberParam",
				accNumberParam);
		String result = RestClient.exchange(GET_BANK_ACCOUNT_STATUS_SERVICE_ENDPOINT, headers, "GET",null);
		System.out.println(result);
		return null;
	}

	public String getAccountBalance() {
		Bank bank=new Bank();
		bank.setName("Barclays");
		bank.setAccountNumber("123");
		bank.setStaffName(new String[] { "Retail", "Investment" });
		GET_BANK_ACCOUNT_BALANCE_SERVICE_ENDPOINT = GET_BANK_ACCOUNT_BALANCE_SERVICE_ENDPOINT.replace("name",
				"Barclays");
		String result =RestClient.exchangeForPut(GET_BANK_ACCOUNT_BALANCE_SERVICE_ENDPOINT,bank,"POST");
				
		System.out.println(result);
		return null;
	}

}
