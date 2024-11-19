package testngpackage;



	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class assertion {
		ChromeDriver driver;
		String baseurl="https://www.google.com";
		@Before
		public void setUp()
		{driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.get(baseurl);
		
		}
		
		@Test
		public void titleverification()
		{
		String act=driver.getTitle();    //title
		String exp="Google";
				if (act.equals(exp))
				{
		            System.out.println("Pass");
		        } else {
		            System.out.println("Fail");
		        }
		}
		@Test
				public void textverification()
				{
				driver.get(baseurl);
				String src=driver.getPageSource();  //get text
				if(src.contains("Gmail"))
				{
					System.out.println("text is present");
				}
				else
				{
					System.out.println("not present");
				}
	}
		@After
		public void teardown()
		{
			driver.quit();
		}
}
