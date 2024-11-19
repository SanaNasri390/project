package testngpackage;



import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {
WebDriver driver;
String baseurl="https://www.facebook.com";
ExtentSparkReporter reporter;
ExtentTest test;
ExtentReports extent;
@BeforeTest
public void setup() {
	reporter=new ExtentSparkReporter("./reports/myreport1.html");
	  reporter.config().setDocumentTitle("Automation test");
	 reporter.config().setReportName("functional Test");
	 reporter.config().setTheme(Theme.DARK);
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("hostname","localhost");
	extent.setSystemInfo("os","window11");
extent.setSystemInfo("testername","sana");
extent.setSystemInfo("BrowserName","chrome");
driver=new ChromeDriver();
}
@BeforeMethod
public void bfrmethod() {
	driver.get(baseurl);
}
	@Test
	public void titleverification() {
		test=extent.createTest("titleverification");
		String exp="facebook";
		String actual=driver.getTitle();
		Assert.assertEquals(exp,actual);
	}
		@AfterTest
		public void aftertest() {
			extent.flush();
		}
		@AfterMethod
			public void browserclose(ITestResult result)throws Exception {
				if(result.getStatus()==ITestResult.FAILURE) {
					test.log(Status.FAIL,"test case failed is"+result.getName());
					test.log(Status.FAIL,"test case failed is"+result.getThrowable());
					String screenshotpath=screenshotMethod(driver,result.getName());
					test.addScreenCaptureFromPath(screenshotpath);
				}
				else if(result.getStatus()==ITestResult.SKIP){
					test.log(Status.SKIP,"test case skipped is"+result.getName());}
					else if(result.getStatus()==ITestResult.SUCCESS) {
						test.log(Status.PASS,"test case passed is"+result.getName());
						
					}
				}
			public static String screenshotMethod(WebDriver driver,String screenshotname)throws Exception{
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String destination="./screenshot/"+screenshotname+".jpeg";
				FileHandler.copy(src,new File(destination));
				return destination;
			}
	
}