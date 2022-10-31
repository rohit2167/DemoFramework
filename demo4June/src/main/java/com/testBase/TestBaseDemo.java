package com.testBase;





import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


//import com.pageLayer.DashboardPageDemo;

//import com.pageLayer.ExchangePageDemo;

import com.pageLayer.LoginPage;


import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBaseDemo 
{
	public static WebDriver driver;
	//public DashboardPageDemo dash;
	//public ExchangePageDemo exchange;
	public static Logger logger;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Dalal Street Framework");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Framework Execution Will be Started..");
		
	}
	@AfterClass
	public void stop()
	{
		logger.info("Framework execution Will be finished");
	}
	@Parameters("browser")
	@BeforeMethod
	public void  setBrowser()
	{
		String br = "chrome";
		if(br.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			
		}
		else
		{
			
			logger.info("Please provide correct browser");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Browser window will be maximize and here we give implicitly wait successfully..");



	
	//------------Login steps -------------------
			LoginPage login = new LoginPage();
			login.enterEmailAddress();
			login.enterPassword();
			login.loginButton();
			
			//----------- Object Creation ------------ 
		//	dash = new DashboardPageDemo();
			//exchange = new ExchangePageDemo();

	}

	@AfterMethod()
	public void closeMethod()
	{
		driver.quit();
		logger.info("browser will be closed successfully");

	}
}
