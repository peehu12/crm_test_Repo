package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginSubmitPage extends TestBase {
	
	//Using PageFactory for Finding elements
			@FindBy(id="ap_password")
			WebElement password;
			
			@FindBy(id="signInSubmit")
			WebElement buttonLogin;
			
			@FindBy(className="a-icon-alt")
			WebElement logoUserNamePage;
			
			//Initializing elements via page factory
			public LoginSubmitPage(){
				PageFactory.initElements(driver, this); //here 'this' means its pointing to current class object.
				
			}
			
			//Actions
			
			public HomePage goToHomePage(String pwd){
				password.sendKeys(pwd);
				buttonLogin.click();
				return new HomePage();
				
			}
			
			

}
