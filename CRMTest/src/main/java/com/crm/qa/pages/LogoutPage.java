package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LogoutPage extends TestBase {
	
	
	public LogoutPage(){
		PageFactory.initElements(driver, this); //here 'this' means its pointing to current class object.
		
	}
	
	
	WebElement logoutmenu=driver.findElement(By.xpath("//span[contains(text(),'Hello, pooja')]"));
	WebElement logout=driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]"));
	
    public void logout(){
    	Actions action=new Actions(driver);
    	action.moveToElement(logoutmenu).build().perform();
    	action.moveToElement(logout).click();
	
}
	

	
	

}
