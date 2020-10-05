package classFiles;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class login_Amazon {
  
  WebDriver driver;
	
  @Test(dataProvider="testdata")
  public void loginAmazon(String emailid , String password) throws InterruptedException
  {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\munee\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.amazon.com/");
	 Thread.sleep(5000);
	 driver.manage().window().maximize();
	 Thread.sleep(3000); 
	 Test1_AmazonPOM r = new Test1_AmazonPOM(driver);
	 r.move_Accountsnlist();
	 Thread.sleep(2000);
	 r.click_Signin1();
	 Thread.sleep(2000);
	 r.enter_emailID(emailid);
	 Thread.sleep(3000);
	 r.click_contbutton();
	 Thread.sleep(2000);
	 r.enter_Password(password);
	 Thread.sleep(3000);
	 r.click_Signin2();
	 Thread.sleep(3000);
	 String ere = r.verify_error();
	 System.out.println(ere);
	 String actere = "We cannot find an account with that email address";
	 Assert.assertEquals(ere, actere);
	 Thread.sleep(3000);
	 String erp = r.verify_pwderror();
	 System.out.println(erp);
	 String acterp = "Your password is incorrect";
	 Assert.assertEquals(erp,acterp);
	 Thread.sleep(3000);
	 }
  
  @DataProvider(name="testdata")
  public Object[][] readExcel() throws BiffException, IOException
  {
	  File f = new File("C:\\Personal\\SampleProject\\src\\test\\java\\classFiles\\Amazoncredentials.xls");
	  Workbook w = Workbook.getWorkbook(f);
	  Sheet s = w.getSheet(0);
	  int rows = s.getRows();
	  int columns = s.getColumns();
	  String inputdata[][] = new String[rows-1][columns];
	  int count = 0;
	  for(int i=1; i<rows; i++){ 
		  for(int j=0; j<columns; j++){
		  Cell c = s.getCell(j,i);
		  inputdata[count][j] = c.getContents();
	  }
		  
		count++;  
		  }
	  return inputdata;
  } 
  
  @AfterMethod
  public void testResult(ITestResult result)
  {
	  System.out.println("TestCase Name is :"+result.getName());
	  System.out.println("TestCase Result is :"+result.getStatus());
	  int status = result.getStatus();
	  if(status==1){
		  driver.close();
	}
	  else {
		  File output = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(output,new File("C:\\Selenium\\flipkartProject\\src\\test\\java\\classFiles"+result.getParameters()[0]+"Defect.jpeg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}  
  }
  driver.close();
  }
}