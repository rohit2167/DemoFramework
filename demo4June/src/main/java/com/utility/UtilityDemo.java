package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBaseDemo;

public class UtilityDemo extends TestBaseDemo 
{
	public UtilityDemo()
	{
	PageFactory.initElements(driver,this);
	
	}
	
	//get url
	public String getUrl()
	{
		String current_url = driver.getCurrentUrl();
		return current_url;
	}
	
	//take Screenshot
	static String path = "H:\\Eclipse Workspace\\FrameworkFirstPractice\\screenshot\\";
	public static void takescreenshot(String filename) 
	{
		try
		{
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File(path + filename + datename +".png");
		FileHandler.copy(src, destination);
		
		}
		catch(IOException e)
		{
			System.out.println("Please provide correct path");
			e.printStackTrace();
		}
		
	}
}
