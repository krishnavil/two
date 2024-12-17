package com.project.base;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.project.utilities.ConfigRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	 public static Logger log = LogManager.getLogger("BaseClass");
	 public static ConfigRead config;
	
	@BeforeTest
	public static void setup() {
		
		config = new ConfigRead();
		
		
		String url = config.geturl();
		String browser = config.getbrowser();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		
		else
		{
			System.out.println("browser not available"); 
		}

	}
	public static void getscreenshot(WebDriver driver, String name)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File Destination = new File("C:\\Users\\madhu\\OneDrive\\Desktop\\RealProject\\Aid\\Screenshots" + name + ".png");
		File Destination = new File("C:\\Users\\madhu\\OneDrive\\Desktop\\RealProject\\Aid\\Screenshots\\" + name + ".png");
		try {
			FileUtils.copyFile(src, Destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void newtabs()
	{
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String>tabs =  driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		
		//while(it.hasNext())
		
			driver.switchTo().window(it.next());
			driver.get(config.geturl());
		
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
