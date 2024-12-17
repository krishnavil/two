package com.project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigRead {
	
	FileInputStream fis;
	static Properties prop;
	
	
	public ConfigRead()
	{
		prop = new Properties();
		String path = "C:\\Users\\madhu\\OneDrive\\Desktop\\RealProject\\Aid\\Configuration\\config.properties";
		
		try {
			 fis = new FileInputStream(path);
			 prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String geturl()
	{
		String url = prop.getProperty("Baseurl");
		
		if(url!=null)
			return url;
					
		else
			throw new RuntimeException("URL NOT AVAILABLE");
	}
	
	public String getbrowser()
	{
		String browser = prop.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("Browser is not described in config file");
				
	}
	
	public static String reportpath()
	{
		String path = prop.getProperty("reportpath");
		return path;
	}
	
	

}
