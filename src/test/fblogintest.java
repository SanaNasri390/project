package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.fbloginpage;

public class fblogintest {
WebDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
}
@Test
public void fbloginpage() {
fbloginpage ob=new fbloginpage(driver);
ob.setvalues("abc@gmail.com","sana123");
ob.login();
}
}