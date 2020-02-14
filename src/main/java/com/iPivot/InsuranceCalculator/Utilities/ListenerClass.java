package com.iPivot.InsuranceCalculator.Utilities;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

//Use ITestListerner ==> is an interface which we need to implement
public class ListenerClass implements ITestListener{

	Logger log = Logger.getLogger(ListenerClass.class.getName());

	@Override
	public void onTestSuccess(ITestResult result) {
		//log.info("Test Case Execution is success for Test Case: "+result.getTestName().toString());

	}
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Case Execution is started for Test Case: "+result.getInstanceName());

	}
	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Case Execution is failed for Test Case: "+result.getInstanceName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Execution is skipped for Test Case: ");

	}
}
