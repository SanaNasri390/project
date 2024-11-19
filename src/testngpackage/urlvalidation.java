package testngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class urlvalidation {
ChromeDriver driver;
@BeforeTest
public void setup() throws Exception {
	driver=new ChromeDriver();
	driver.get("https://keralaproperty.in/member/login/");
}
	@Test
	public void test() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"ulogin\"]")).sendKeys("hiba");
	driver.findElement(By.xpath("//*[@id=\"upass\"]")).sendKeys("Hibaaa12*");
	driver.findElement(By.xpath("//*[@id=\"sub_logbtn\"]")).click();
	Thread.sleep(300);
String	actual=driver.getCurrentUrl();
System.out.println(actual);
String exist=" https://keralaproperty.in/member/myhome";
if(actual.equals(exist)) {
	System.out.println("login success");

}
else {
	System.out.println("login fail");
}
	}}

