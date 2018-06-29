package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeforeLoginPage extends TestBase {
	
	
	
	@FindBy(id="nav-link-yourAccount")
	WebElement goToSignIn;
	
	WebElement signIn=driver.findElement(By.cssSelector("span[class='nav-action-inner']"));
	
	//Initializing elements via page factory
			public BeforeLoginPage(){
				PageFactory.initElements(driver, this); //here 'this' means its pointing to current class object.
				
			}
			
			//Actions
			
			public String validateBeforeLoginPageTitle(){
				return driver.getTitle(); 
				
			}
			
			public void goToSignInPage(){
				Actions action=new Actions(driver);
				action.moveToElement(goToSignIn).build().perform();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				action.moveToElement(signIn).click();
				//return new LoginUsernamePage();
				
			}

}
