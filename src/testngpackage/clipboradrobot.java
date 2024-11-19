package testngpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clipboradrobot {

ChromeDriver driver;
@BeforeTest
public void setup() {
	driver=new ChromeDriver();
}
@Test
public void fileupload() throws Exception {
	driver.get("https://www.ilovepdf.com/word-to-pdf");
	driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
	fileUpload("C:\\Users\\THIS PC\\OneDrive\\Documents\\percieved risk.docx");
}
public void fileUpload(String p)throws AWTException{
	StringSelection strSelection=new StringSelection(p);
	Toolkit.getDefaultToolkit().getSystemClipboard().getContents(strSelection);
	Robot robot=new Robot();
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
