package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		super(); //super keyword is used to call TestBase
	}
	
	@BeforeMethod
	
	public void SetUp() {
		
		initil();
		loginpage = new LoginPage();
	}
	
	@Test(priority=3)
	public void VerifyLoginPage() {
		loginpage.VerifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void VerifyTitleofThePage() {
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing"); //actual, expected
	}
	@Test(priority=0)
	public void VerifyLogoOfThePage() {
		boolean logoT = loginpage.VerifyLogo();
		Assert.assertTrue(logoT); //select the right TestNG
	}
	@Test(priority=2)
	public void VerifyErrorMessageofPage() {
		loginpage.ErrorMessage(prop.getProperty("invalidusername"), prop.getProperty("invalidpassword"));
		boolean er = loginpage.VerifyError();
		Assert.assertTrue(er);
		System.out.println("The error message: " + er);
	}
	
	@AfterMethod //TearDown
	public void CloseandQuit() {
		driver.quit();
	}

}
