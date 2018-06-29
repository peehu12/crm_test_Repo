package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginUsernamePage extends TestBase {
	
	String unamePageTitle="Amazon Sign In";
	
	//Using PageFactory for Finding elements
		@FindBy(id="ap_email")
		WebElement username;
		
		@FindBy(id="continue")
		WebElement buttonContinue;
		
		@FindBy(id="createAccountSubmit")
		WebElement signUpButton2;
		
		@FindBy(className="a-icon-alt")
		WebElement logoUserNamePage;
		
		//Initializing elements via page factory
		public LoginUsernamePage(){
			PageFactory.initElements(driver, this); //here 'this' means its pointing to current class object.
			
		}
		
		//Actions
		
		public String validateUnamePageTitle(){
			return driver.getTitle(); 
			
		}
		
		
		public LoginSubmitPage goToSubmitPage(String un){
			username.sendKeys(un);
			buttonContinue.click();
			return new LoginSubmitPage();
			
		}
		
		

}
