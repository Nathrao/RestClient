package com.emp;

import org.junit.Assert;
import org.junit.Test;

import com.bank.RestClient;
import com.barclays.common.beans.EmployeeRequestBean;

import junit.framework.TestCase;

public class EmployeeAPITest extends TestCase{

	
	@Test
	public  void testSaveEmployeeService() {
		String url="http://localhost:8087/HibernateProjectUsingMaven/employeeDetails/save";
		EmployeeRequestBean requestBean =new EmployeeRequestBean();
		requestBean.setEmpId(183);
		requestBean.setEname("Sham");
		requestBean.setDesg("TL");
		requestBean.setSalary(10000);
		String result =RestClient.exchangeForPut(url,requestBean,"POST");
		Assert.assertEquals("Registration Successful",result);
	}
}
