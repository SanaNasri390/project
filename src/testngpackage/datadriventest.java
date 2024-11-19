package testngpackage;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class datadriventest {
WebDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
}
@Test
public void test() throws Exception {
	FileInputStream ob=new FileInputStream("C:\\Users\\THIS PC\\OneDrive\\Book 4.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(ob);
	XSSFSheet sh=wb.getSheet("sheet1");
	int row=sh.getLastRowNum();
	for(int i=1;i<=row;i++)
	{
		String mail=sh.getRow(i).getCell(0).getStringCellValue();
		String password=sh.getRow(i).getCell(1).getStringCellValue();
		driver.findElement(By.name("email")).sendKeys(mail);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.navigate().refresh();
	}
	ob.close();
	wb.close();
}
}
