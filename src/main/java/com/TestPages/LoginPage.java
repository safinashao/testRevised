package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or container
	// Keep all the locator and method in this class

	@FindBy(xpath="//input[@id='username']")
	WebElement UserName;
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	@FindBy(xpath="//button[@name='login']")
	WebElement Login;
	@FindBy(xpath="//img[@class='logo']")
	WebElement Logo;
	@FindBy(xpath="//div[@class='alert alert-danger fade in']")
	WebElement ErrorMessage;

	public LoginPage() {
		PageFactory.initElements(driver, this); // will always be the same in every page
	}

	// This is where all the action takes place
	// return new HomePage(); //return homepage because you are landing in homepage
	//methods to interact with elements
	public void VerifyLogin(String Email, String PWord) {
		UserName.sendKeys(Email);
		Password.sendKeys(PWord);
		Login.click();                                     

	}

	public String VerifyTitle() {
		return driver.getTitle();
	}

	public boolean VerifyLogo() {
		return Logo.isDisplayed();
	}
	
	public void ErrorMessage(String Email, String PWord) {
		UserName.sendKeys(Email);
		Password.sendKeys(PWord);
		Login.click();
		
	}

	public boolean VerifyError() {
		return ErrorMessage.isDisplayed();
	}

}
