package testngpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class booking {
	ChromeDriver driver;

	@BeforeTest
	public void setup() {
		driver=new ChromeDriver(); 
		driver.get("https://www.booking.com/");
		
	}

@Test
public void test1() throws Exception{
	
		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[2]/div/div[2]/div/nav/div[1]/ul/li[1]/button")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		datepickermethod("December 2024","18");
}

private void datepickermethod(String expmonth,String expdate) {
	while(true) {
String checkin=driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/h3")).getText();
//String checkout=driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[2]/h3")).getText();
if(checkin.equals(expmonth)) {
break;
}else {
	driver.findElement(By.xpath("//*[@id=\":r61:\"]/li[5]/label/span/span[2]")).click();
}
List<WebElement> date= driver.findElements(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr[5]/td[3]/span"));
for(WebElement d:date) {
	String datetext=d.getText();
	if(datetext.equals(expdate)) {
		d.click();
		break;
}}}}}


