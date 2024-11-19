package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class junitdemo {
	ChromeDriver driver;
@Before
public void setup(){
	driver=new ChromeDriver();
	driver.get("https://www.google.com");
}
@Test
public void test() {
	String actual=driver.getTitle();
	String expctd="Google";
	if(actual.equals(expctd)) {
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
}
}


