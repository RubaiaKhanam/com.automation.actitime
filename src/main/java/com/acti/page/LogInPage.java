package com.acti.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LogInPage extends DriverScript{
	
	//**************************************** Page Elements ************************************************//

	
	@FindBy(id = "username") WebElement textboxUsername;
	@FindBy(name = "pwd") WebElement textboxPassword;
	@FindBy(xpath = "//div[text()='Login']") WebElement buttonLogin;
	@FindBy(id = "loginRecoveryLinkContainer") WebElement LinkForgotPassword;
	
	//**************************************** Page Initialization *******************************************//
	
	public LogInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//**************************************** Page Methods *************************************************//
	
	public boolean verifylinkForgotPassword()
	{
		return LinkForgotPassword.isDisplayed();
	}
	public void enterUsername(String username)
	{
		textboxUsername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		textboxPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		buttonLogin.click();
	}

	
}
