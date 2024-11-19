package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class selenium1 {
public static void main(String[]args) {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
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
