package testngpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonwindowhandler {
WebDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("https://www.amazon.in");
}
	@Test
	public void test() {
WebElement searchbar=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
searchbar.sendKeys("mobiles");
WebElement button=driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
button.click();
((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
WebElement add=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
add.click();
ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(windowdetails.get(1));
driver.getTitle();
WebElement cart=driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input"));
cart.click();

}
}
