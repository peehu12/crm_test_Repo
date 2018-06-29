package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;   //static method defined at global level
	
	 public TestBase() //constructor
	  {
		//Reading config.properties file
	   try{
			prop = new Properties();
			FileInputStream ip=new FileInputStream("C:/Users/POOJA/workspace1/CRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		   }
	   catch(FileNotFoundException e){
			e.printStackTrace();
		}
	   catch(IOException e)
		{
			e.printStackTrace();
		}				
	  }
	 
	 
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		//Check which browser is defined in the properties file
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Selenium Installation 2018/Selenium Drivers/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Selenium Installation 2018/Selenium Drivers/geckodriver-v0.19.0-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%2Fref%3Dnav_signin&switch_account=");
		
	}

}
