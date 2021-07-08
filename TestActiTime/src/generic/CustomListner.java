package generic;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListner extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("The test has been started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("This "+result.getMethod().getMethodName()+ " is successfully executed",true);
	}

	
	//this method is very important and will be called only if  the @Test annotation fails and immediately it will execute the fail()
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("this"+result.getMethod().getMethodName()+" is failed and the screenshot is taken in the screenshots folder",true);
		fail(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("the "+result.getMethod().getMethodName()+" is skipped ",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("The actitime test cases will execute now onwards",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("The test case execution is completed",true);
	}
	

}
