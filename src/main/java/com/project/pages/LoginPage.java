package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	
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
