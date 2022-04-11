package com.acti.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.page.EnterTimePage;
import com.acti.page.LogInPage;

public class LoginTest extends DriverScript{

	LogInPage lp;
	EnterTimePage etp;
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		lp = new LogInPage();
		etp = new EnterTimePage();
	}
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}

	@Test(priority = 1)
	public void TestLogin() throws InterruptedException
	{
		
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		String actual = etp.verifyUserLogged();
		System.out.println(actual);
		etp.clickLogout();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2)
	public void testValidateForgotPasswordLink() throws InterruptedException
	{
		boolean flag = lp.verifylinkForgotPassword();
		System.out.println(flag);
		Thread.sleep(3000);
		
	}
}
