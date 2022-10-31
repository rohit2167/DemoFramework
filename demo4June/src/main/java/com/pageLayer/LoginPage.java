package com.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBaseDemo;

public class LoginPage extends TestBaseDemo
{
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email_txtBox;
	
	@FindBy(xpath ="//input[@name='password']")
	private WebElement pass_txtBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_btn;
	
	
	public void enterEmailAddress()
	{
		email_txtBox.sendKeys("rohitrathic@gmail.com");
	}
	
	public void enterPassword()
	{
		pass_txtBox.sendKeys("rohit@8788");
	}
	public void loginButton()
	{
		login_btn.click();
	}
}
