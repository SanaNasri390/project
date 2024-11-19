package testngpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class trivago {
WebDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("https://www.booking.com");
}
@Test
public void datepicker() throws InterruptedException {
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[2]/div/div")).click();
	datepickermethod("December 2024","20");
	datepickermethod("December 2024","23");
	
}
private void datepickermethod(String expmonth,String expdate) {
	while(true) {
String month=	driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/h3")).getText();
if(month.equals(expmonth)) {
break;
}
else {
	driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/button")).click();
}
}
List<WebElement> date=driver.findElements(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr/td"));
for(WebElement d:date) {
	String datetext=d.getText();
	if(expdate.equals(datetext)) {
		d.click();
		break;
	}
}}}

