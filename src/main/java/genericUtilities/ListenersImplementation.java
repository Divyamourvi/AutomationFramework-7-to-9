package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		//Example for method overriding and abstraction
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test Execution Started-------");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test Execution Success-------");
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test Execution Failed-------");
		System.out.println(result.getThrowable());
		
		//TakeScreenshot
		String screenshot=methodName+"-"+new JavaUtility().getSystemInFormat();
		WebDriverUtility wLib=new WebDriverUtility();
		try {
			wLib.takeScreenShot(BaseClass.sDriver, screenshot );
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test Execution Skipped-------");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("-------Test Execution started-------");
	}

	public void onFinish(ITestContext context) {
		System.out.println("-------Test Execution Finished-------");
	}

	
}
