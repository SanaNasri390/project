package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pagefactorylogin {
WebDriver driver;
@FindBy(xpath="//*[@id=\"reg_pages_msg\"]/a")
WebElement buttonclick;
@FindBy(xpath=("//*[@id=\"headerInnerContainer\"]/div[1]"))
WebElement textcheck;
@FindBy(xpath="//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a")
WebElement signup;
public pagefactorylogin (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void check() {
	buttonclick.click();
signup.click();
}

public void testcheck() {
	
	String src=driver.getPageSource();
	
	if(src.contains("Create a Page")) {
		
		
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
}
}