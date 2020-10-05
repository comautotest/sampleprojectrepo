package classFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test1_AmazonPOM {
  
WebDriver driver;

By accountsnList = By.xpath("//span[text()='Account & Lists']");
By signin = By.xpath("(//span[text()='Sign in'])[1]");
By email = By.xpath("//input[@name='email']");
By continuebutton = By.xpath("//input[@name='email']/following::*[8]");
By pwd = By.xpath("//input[@name='password']");
By signinbutton = By.xpath("//input[@name='password']/following::*[10]");
By errmsg = By.xpath("//span[contains(text(),'cannot')]");
By errmsg2 = By.xpath("//span[contains(text(),'incorrect')]");

public Test1_AmazonPOM(WebDriver driver)
{
	this.driver = driver;
}

public void move_Accountsnlist()
{
	WebElement a = driver.findElement(accountsnList);
	Actions s = new Actions(driver);
	s.moveToElement(a).build().perform();
}

public void click_Signin1()
{
	driver.findElement(signin).click();
}

public void enter_emailID(String emailid)
{
	driver.findElement(email).sendKeys(emailid);
}

public void click_contbutton()
{
	driver.findElement(continuebutton).click();
}

public void enter_Password(String password)
{
	driver.findElement(pwd).sendKeys(password);
}

public void click_Signin2()
{
	driver.findElement(signinbutton).click();
}

public String verify_error()
{
	return driver.findElement(errmsg).getText();
}

public String verify_pwderror()
{
	return driver.findElement(errmsg2).getText();
}
  }