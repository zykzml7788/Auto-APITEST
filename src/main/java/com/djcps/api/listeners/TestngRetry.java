package com.djcps.api.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestngRetry implements IRetryAnalyzer {
	public static int retryCount = 1;
	public static int maxRetryCount = 3;

	public static void resetRetryCount() {
		retryCount = 1;
	}
	@Override
	public boolean retry(ITestResult result) {
		  if (retryCount < maxRetryCount) { 
	            retryCount++; 
	            return true; 
	        }
		return false;
	}
}

