package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

<<<<<<< HEAD
	public void ma1()
	{
		System.out.println("gitstuff");
	}
=======
	
>>>>>>> 49fc7ce932fdaeb50fe549794ffd5f768680ac02
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="user-name")
	WebElement usernames;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	public void Username(String name)
	{
		System.out.println("user name");
		usernames.sendKeys(name);
	}
	
	public void Password(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void Submit()
	{
		submit.click();
	}

}
