package com.acti.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/* Devloped By  : Rubaia
 * Reviewed By  : Shantosh
 *  Last Modified Date : 21/03/2022
 * Description  : 
 */


public class EnterTimePage extends DriverScript{

	
	//**************************************** Page Elements ************************************************//

	@FindBy(xpath= "//a[@class='userProfileLink username']") WebElement textUserLogged;
	@FindBy(id = "logoutLink") WebElement linkLogout;
	
	
	//**************************************** Page Initialization *******************************************//
	
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//**************************************** Page Methods *************************************************//
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	public String verifyUserLogged()
	{
		return textUserLogged.getText();
		
	}
}
