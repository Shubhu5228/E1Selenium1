package genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener{
	

	ExtentReports report;
	ExtentTest test;
	JavaUtility jUtil=new JavaUtility();
	String dateTimeStamp=jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"excution Started");
		
		//create a test
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"excu tion Passed");
		
		test.log(Status.PASS, methodName+"execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"excution Failed");
		
		test.log(Status.FAIL, methodName+"execution failed");
		
		//capturing the screenshot on test script getting failed and attaching to report
		
		SeleniumUtility sUtil=new SeleniumUtility();
		String screenshotName=methodName+dateTimeStamp;
		try {
			String path=sUtil.captureScreenshot(BaseClass.sDriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"excution Skipped");
		
		test.log(Status.SKIP, methodName+"execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//configuration of the report
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(".\\Extent Reports\\Report-"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("VTiger Testing Reports");
		reporter.config().setReportName("VTiger");
		reporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Base URL", "http:/localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Reporter Name", "Shubham");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		
		report.flush();
		
	}
	
}
