package com.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testBase.TestBaseDemo;

public class ListnersDemo extends TestBaseDemo implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		
		logger.info("Test Execution will be start");

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Case Execution will be Successfully Passed..");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Testcase execution failed");
		UtilityDemo.takescreenshot(result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
