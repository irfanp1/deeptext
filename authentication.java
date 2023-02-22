package topicmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class authentication extends base {
 
  public void valid_login() throws Exception {
	  implisitwait(20);
	  d.get("https://qa-deeptext.tech.us/#/login");
	  sendkeys("email", "nirfanpalyam@compindia.com");
	  sendkeys("password", "test@123");
	  js(xpath("//button[.='Log In']"));sleep(3);
  }
  public void click(String s) {
	  js(xpath("//*[@id='"+s+"']"));
  }
  public void clear(String s) {
	  xpath("//*[@id='"+s+"']").clear();
  }
  public void sendkeys(String s,String keys) {
	  xpath("//*[@id='"+s+"']").sendKeys(keys);
  }
  public void invalid_login(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  implisitwait(1);
	  d.get("https://qa-deeptext.tech.us/#/login");
	  js(xpath("//button[.='Log In']"));
	  alerts_login(extenttest);sleep(2);
	  sendkeys("email", "nirfanpalyamcompindia.com");
	  sendkeys("password", "demon1234");
	  js(xpath("//button[.='Log In']"));
	  alerts_login(extenttest);sleep(2);
	  clear("email");
	  sendkeys("email", "nirfanpalyam@compindia.com");
	  js(xpath("//button[.='Log In']"));sleep(2);
	  snackbar_fail(extenttest);
	  xpath("//*[@id='remember']").isSelected();
	  extenttest.log(Status.INFO, "Defaulty Remember Me is not Selected");
	  click("remember");sleep(2);
	  System.out.println(xpath("//*[@id='remember']").isSelected());
  }
  public void forgot_password_with_alerts(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  js(xpath("//button[.='Forgot Password?']"));sleep(2);
	  js(xpath("//button[.='Submit']"));sleep(2);
	  alerts_login(extenttest);sleep(2);
	  sendkeys("email", "nirfanpa.lyamcompindia.com");
	  js(xpath("//button[.='Submit']"));sleep(2);
	  alerts_login(extenttest);sleep(2);
	  clear("email");
	  sendkeys("email", "nirfanpalyam@compindia.com");
	  js(xpath("//button[.='Submit']"));sleep(2);
	  snackbar_success(extentTest);
	  js(xpath("//span[.='Sign In']"));
  }
  public void reset_password_with_alerts(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest; implisitwait(1);
	  d.get("https://mail.google.com/");Thread.sleep(4000); 
	  d.findElement(By.xpath("//input[@type='email']")).sendKeys("nirfanpalyam@compindia.com");
	  d.findElement(By.xpath("//span[.='Next']")).click();Thread.sleep(4000); 
	  d.findElement(By.xpath("//input[@type='password']")).sendKeys("V>GgA7Am!");
	  d.findElement(By.xpath("//span[.='Next']")).click();Thread.sleep(10000); 
	  d.findElement(By.xpath("//input[@name='q']")).sendKeys("forgot password  email  ",Keys.ENTER);Thread.sleep(4000);
	 js(xpath("(//*[@role='row'])[1]"));Thread.sleep(3000); 
	 js(xpath("(//a[contains(text(),'Reset my ')])[1]"));Thread.sleep(3000); 
	 windowhandlechild();
	 nav();sleep(2);
	 sendkeys("password", "dem");
	 sendkeys("confirm_password", "demon1234");
	 nav();sleep(2);
	 sendkeys("password", "demo");
	 sendkeys("confirm_password", "demo");
	 nav();sleep(2);
	 sendkeys("password", "TEST1");
	 sendkeys("confirm_password", "test1");
	nav();sleep(2);
	sendkeys("password", "test@123");
	 sendkeys("confirm_password", "test@123");
	 js(xpath("//button[.='Reset Password']"));sleep(2);
	 WebElement al = d.findElement(By.xpath("(//span[@class='icon-tick me-2']/following::div)[1]"));
	  extenttest.log(Status.INFO, al.getText());sleep(2);
	 close_window();
}
  public void nav() throws Exception {
	  js(xpath("//button[.='Reset Password']"));sleep(2);
		 alerts_login(extenttest);sleep(2);
		 d.navigate().refresh();
  }
}