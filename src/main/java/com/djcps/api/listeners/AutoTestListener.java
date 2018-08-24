package com.djcps.api.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@SuppressWarnings("unused")
public class AutoTestListener extends TestListenerAdapter {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(AutoTestListener.class);
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		TestngRetry.resetRetryCount();
		super.onTestSuccess(tr);
	}

	public void onTestFailure(ITestResult tr) {
		if(TestngRetry.retryCount==TestngRetry.maxRetryCount) {
			TestngRetry.resetRetryCount();
		}
		saveResult(tr);
		super.onTestFailure(tr);
		
	}

	public void onTestSkipped(ITestResult tr) {
		saveResult(tr);
		super.onTestSkipped(tr);
	}

	private void saveResult(ITestResult tr) {
		Throwable throwable = tr.getThrowable();
		if (null == throwable) {
			return;
		}
		// String imgPath = WebdriverUtil.captureEntirePageScreenshot();
		// log.error("用例执行错误截图：" + imgPath);
		// Reporter.setCurrentTestResult(tr);
		// Reporter.log("path path path path");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		//失败后重跑，记录最后一次结果
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator(); 
        while (listOfFailedTests.hasNext()) { 
             ITestResult failedTest = listOfFailedTests.next(); 
             ITestNGMethod method = failedTest.getMethod(); 
             if (testContext.getFailedTests().getResults(method).size() > 1) { 
                 listOfFailedTests.remove(); 
             } else { 
                 if (testContext.getPassedTests().getResults(method).size() > 0) { 
                     listOfFailedTests.remove(); 
                 } 
             } 
         }
        


	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id
				+ (result.getParameters() != null ? Arrays.hashCode(result
						.getParameters()) : 0);
		return id;
	}
}
