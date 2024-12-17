package com.project.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.base.BaseClass;
import com.project.base.Dataprovider;
import com.project.pages.LoginPage;

public class TC_01 extends BaseClass{
	
	int i =0;
	@Test(dataProvider = "getlogindetails")
	public void VerifyLogin(String name, String pass)
	{
		System.out.println(name+" "+pass);
		
		log.info("Browser Open");
		LoginPage lp = new LoginPage(driver);
		//driver.findElement(By.id("user-name")).sendKeys("Hello");
		lp.Username(name);
		lp.Password(pass);
		lp.Submit();
		i++;
		getscreenshot(driver, "test one"+i);
		System.out.println(i);
		newtabs();
		//if(i>2)
		//setup();
	}
	
	@DataProvider(name="getlogindetails")
	public Object[][] getlogindetails() throws IOException
	{
		Dataprovider data = new Dataprovider();
		return data.getdata();
		
	}

}
