package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.pagefactorylogin;

public class pagefactorytest extends baseurl {

@Test
public void pagefactory() {
	pagefactorylogin ob=new pagefactorylogin(driver);
	ob.check();
	ob.testcheck();
	
}

}
