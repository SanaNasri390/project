package testngpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class rightbutton {
ChromeDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
}
@Test
public void test() 
{
	WebElement clickme=driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
	Actions act=new Actions(driver);
	act.contextClick(clickme).perform();
	WebElement edit=driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]"));
	edit.click();
	Alert a=driver.switchTo().alert();
	a.accept();
	WebElement doubleclick=driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
	act.doubleClick(doubleclick).perform();
	Alert b=driver.switchTo().alert();
	String text=b.getText();
	System.out.println("alert text="+text);
	b.accept();
}
}
