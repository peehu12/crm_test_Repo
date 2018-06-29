package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BeforeLoginPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginSubmitPage;
import com.crm.qa.pages.LoginUsernamePage;

public class LoginPageTest extends TestBase {
	
	
	LoginUsernamePage pageUsernameObj;
	LoginSubmitPage pageSubmitObj;
	HomePage pageHomeObj;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();// since it is static method u can call it without using object
		pageUsernameObj=new LoginUsernamePage();
		pageSubmitObj=new LoginSubmitPage();	
	}
	 
	//Validating UserName Title Page
	@Test(priority=1)
	public void validateUnamePageTitleTest(){
		String title=pageUsernameObj.validateUnamePageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	//Calling Function to pass username and go to next page
	@Test(priority=2)
	public void goToSubmitPageTest(){
		pageSubmitObj=pageUsernameObj.goToSubmitPage(prop.getProperty("username"));
		
	}
	
	//Calling Function to pass pass and go to home page
	@Test(priority=3)
	public void goToHomePageTest(){
		pageHomeObj=pageSubmitObj.goToHomePage(prop.getProperty("password"));
		
	}

	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/
	
	

}
