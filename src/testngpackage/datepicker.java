package testngpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class datepicker {
	ChromeDriver driver;

	@BeforeTest
	public void setup() {
		driver=new ChromeDriver(); 
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
	}

@Test
public void datepicker() throws Exception{
	
		driver.findElement(By.xpath("//*[@id=\"datepicker1\"]")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		datepickermethod("December 2024","18");
	}

private void datepickermethod(String expmonth,String expdate) {
	while(true) {
String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
if(month.equals(expmonth)) {
	break;
}
	else {
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
	}
	
}
	List<WebElement> date= driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
	for(WebElement d:date) {
		String datetext=d.getText();
		if(datetext.equals(expdate)) {
			d.click();
			break;
		}
		
}
}}
