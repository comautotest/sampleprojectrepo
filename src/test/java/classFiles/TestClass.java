/* THIS IS A PRACTICE WORK ON GIT AS A BEGINNER */

package classFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
	
	static WebDriver driver;
	
  @BeforeTest
  public static void browserSetUp() 
   {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\munee\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
   }
  
  // Open a web page
  
  @Test(priority=0)
  public static void launchGoogle() throws InterruptedException
  {
	  driver.get("https://www.google.com/");
	  Thread.sleep(3000);
	  
	  System.out.println("This is a practice project in Git");
	  driver.close();	  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
