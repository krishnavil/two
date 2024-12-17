package com.project.utilities;

	
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener ;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;		


public class Listner extends ConfigRead implements ITestListener {
	
	static ExtentSparkReporter spark;
	static ExtentReports ext;
	static ExtentTest test;
	
	//static WebDriver driverl = bs.driver();
	
	
	
	public Listner()
	{
		File file = new File("C:\\Users\\madhu\\OneDrive\\Desktop\\RealProject\\Aid\\Report\\rpt.html");
		//File file = new File(ConfigRead.reportpath());
		spark = new ExtentSparkReporter(file);
		 ext = new ExtentReports();
		
		ext.attachReporter(spark);
		
		spark.config().setDocumentTitle("Madhukar Vilaspure");
		spark.config().setReportName("Testing Project");
		spark.config().setTimeStampFormat("yyy.mm.dd");
		
		ext.setSystemInfo("Tester", "Madhukar");
		ext.setSystemInfo("Browser", "EDGE");
		ext.setSystemInfo("OS", "W10");
		
		//Scrrenshot
				
	}
	

	@Override
	public boolean isEnabled() {
		
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = ext.createTest(result.getName());
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, MarkupHelper.createLabel("Passed test method name "+result.getName(), ExtentColor.GREEN));
		
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, MarkupHelper.createLabel("Failed Test Name "+result.getName(), ExtentColor.RED));
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		ext.flush();
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		
	}
	

}
