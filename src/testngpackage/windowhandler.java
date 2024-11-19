package testngpackage;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class windowhandler {
WebDriver driver;
@BeforeTest
public void first() {
	driver=new ChromeDriver();
	driver.get("https://www.google.com");
}
@Test
public void second() {
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.facebook.com");
	driver.getTitle();
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.ebay.com");
	driver.getTitle();
	ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
	driver.switchTo().window(windowdetails.get(1));
	System.out.println(driver.getTitle());
	String parentwindow=driver.getWindowHandle();
	//driver.switchTo().window(parentwindow);
}


}
