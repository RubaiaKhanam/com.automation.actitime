package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Devloped By  : Rubaia
 * Reviewed By  : Shantosh
 *  Last Modified Date : 21/03/2022
 * Description  : 
 */


public class DriverScript {

	
	public static WebDriver driver;
	Properties prop;
	
	public DriverScript()
	{
		try
		{
			File src = new File("./atConfig/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Unable to load the properties file ");
		}
	}
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./atBrowser/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./atBrowser/msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./atBrowser/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please provide valid user name");
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		launchURL();
	}
		
		public void launchURL()
		{
			String url = prop.getProperty("url");
			driver.get(url);
			
	}
		public static void quitDriver()
		{
			driver.quit();
		}
}
