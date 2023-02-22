package topicmodel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class base {
	ExtentReports extent ;
	Date currentdate=new Date();
	String name=currentdate.toString().replace(":", "-");
	public ExtentTest extenttest;
	private ExtentTest extentTest;
	public static  WebDriver d;
	
	public static SoftAssert sa=new SoftAssert();
	 @Parameters("s")
	@BeforeTest
	 public void browser(String s ) throws Exception {
		if (s.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup(); d=new ChromeDriver();
			  d.manage().window().maximize(); }
		 else if (s.equalsIgnoreCase("opera")) {
			  WebDriverManager.operadriver().setup(); d= (WebDriver) new OperaDriverManager();
			  d.manage().window().maximize(); } 
			  else {
			  WebDriverManager.edgedriver().setup(); d=new EdgeDriver();
			  d.manage().window().maximize(); }
		
	}
  public WebElement xpath(String spath) {
	 WebElement xp = d.findElement(By.xpath(spath));
	  return xp;
  }
  public void sleep(int a) throws Exception {
	  Thread.sleep(a*1000);
  }
  public void implisitwait(int seconds) {
	  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
  }
  public void webwait(int minutes,WebElement element) {
	  WebDriverWait wait=new WebDriverWait(d, Duration.ofMinutes(minutes));
	  wait.until(ExpectedConditions.visibilityOfAllElements(element));
  }
  public void scroll(WebElement Element) {
	  JavascriptExecutor js = (JavascriptExecutor) d;
	  js.executeScript("arguments[0].scrollIntoView();", Element);
  }
  public   void js(WebElement findElement) {
	  JavascriptExecutor executor =(JavascriptExecutor) d;
		  executor.executeScript("arguments[0].click();", findElement);
  }
  
  public void alerts_login(ExtentTest extentTest) {
	  this.extenttest=extentTest;
	  List<WebElement> var = d.findElements(By.xpath("//span[@class='login-error']"));
	  for (WebElement alert : var) {
		extenttest.log(Status.INFO, alert.getText());
	}}
	  public void alerts_error(ExtentTest extentTest) {
		  this.extenttest=extentTest;
		  List<WebElement> var = d.findElements(By.xpath("//span[@class='error-msg']"));
		  for (WebElement alert : var) {
			extentTest.log(Status.INFO, alert.getText());
		}
		  
  }
	  
  public void snackbar_fail(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  WebElement al = d.findElement(By.xpath("(//span[@class='icon-alert me-2']/following::div)[1]"));
	  extenttest.log(Status.INFO, al.getText());sleep(2);
       js(xpath("(//span[@class='icon-alert me-2']/following::button)[1]"));
  }
  public void snackbar_success(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  WebElement al = d.findElement(By.xpath("(//span[@class='icon-tick me-2']/following::div)[1]"));
	  extenttest.log(Status.INFO, al.getText());sleep(2);
       js(xpath("(//span[@class='icon-tick me-2']/following::button)[1]"));
  }

	 public void project_search(String gname) throws Exception {
		 implisitwait(20);
		 // js(xpath("(//span[@class='menu-item-p'])[2]"));sleep(2);
		 js(xpath("//span[.='Projects']"));sleep(2);
		  xpath("//input[contains(@class,'form-control gv-search')]").sendKeys(gname);sleep(2);
		 xpath("//i[@class='icon-search']").click();sleep(2);
	  }
	 public void addfile(String s) throws AWTException, Exception {
		 Thread.sleep(2000);
		  Robot robot = new Robot();
		     Transferable trans = new StringSelection(s);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
		    robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_V);
		    robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(2000);
	  }
  
  public   void windowhandlechild() throws Exception {
	  d.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	  Set<String> handles = d.getWindowHandles();//parent id,child id,child 2
		 Iterator<String> it = handles.iterator();
		 String parent=it.next();
		 String child1=it.next();
		 d.switchTo().window(child1);Thread.sleep(4000);
  }
  public void close_window() throws Exception {
		 d.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		Set<String> handles = d.getWindowHandles();//parent id,child id
		 Iterator<String> it = handles.iterator();
		 String parent=it.next();
		 String child1=it.next();Thread.sleep(2000);
		 d.switchTo().window(child1);Thread.sleep(5000);
		 d.close();
		 d.switchTo().window(parent);Thread.sleep(3000);
		 }
  public  void sortFunction_ascending(String xplist,String xpcolum,ExtentTest extentTest) throws Exception {
	   List <String> llistbefore=new ArrayList();
		 List <String> listafter=new ArrayList();
	  List<WebElement> colname = d.findElements(By.xpath(xplist));
	  String[] beforesort=new String[colname.size()];
	  for (int i = 0; i < colname.size(); i++) {
		  beforesort[i]=colname.get(i).getText().trim();
		  System.out.println(beforesort[i]);
		  llistbefore.add(beforesort[i]);
	}
	  Collections.sort(llistbefore,String.CASE_INSENSITIVE_ORDER);
      List<String> sorted = llistbefore.stream().collect(Collectors.toList());
      System.out.println("java - sort");
   sorted.forEach(System.out::println);
	  scroll(xpath(xpcolum));
   sleep(2);
	js(xpath(xpcolum));sleep(2);
	String[] aftersort=new String[colname.size()];
	  for (int i = 0; i < colname.size(); i++) {
		  aftersort[i]=colname.get(i).getText().trim();
		  System.out.println("afte sort-----------");
		  System.out.println(aftersort[i]);
		  listafter.add(aftersort[i]);
	}
		 if (sorted.equals(listafter)) {
			 String w = d.findElement(By.xpath(xpcolum)).getText();sleep(2);
			 extentTest.log(Status.INFO, w+" is Successfully Sorted in Ascending Oreder");sleep(2);
		}else {
			String w = d.findElement(By.xpath(xpcolum)).getText();sleep(2);
			 extentTest.log(Status.INFO, w+" is not  Sorted in Ascending Oreder");sleep(2);
		}
		sleep(2);
		sa.assertEquals(sorted, listafter);
		 sa.assertAll();
  } 

  public  void sortFunction_descending(String xplist,String xpcolum,ExtentTest extentTest,int n) throws Exception {
	  implisitwait(3);
	// d.navigate().refresh();sleep(3);
	   List <String> llistbefore=new ArrayList();
		 List <String> listafter=new ArrayList();
//		 try {
//			js(xpath("//button[.='Continue']"));sleep(2);
//			js(xpath("//button[.='Continue']"));sleep(2);
//			if (screenname.equalsIgnoreCase("import")) {
//				System.out.println("done at import");
//			}else {
//				js(xpath("//button[.='Continue']"));sleep(2);
//			}
//			
//		} catch (Exception e) {
//			
//		}
	  List<WebElement> colname = d.findElements(By.xpath(xplist));
	  String[] beforesort=new String[colname.size()];
	  for (int i = 0; i < colname.size(); i++) {
		  beforesort[i]=colname.get(i).getText().trim();
		  System.out.println(beforesort[i]);
		  llistbefore.add(beforesort[i]);
	}
	  Collections.sort(llistbefore,String.CASE_INSENSITIVE_ORDER);
	  Collections.reverse(llistbefore);
     List<String> sorted = llistbefore.stream().collect(Collectors.toList());
  sorted.forEach(System.out::println);
  scroll(xpath(xpcolum));
  sleep(3);
  
  if (n==1) {
	  System.out.println(xpath(xpcolum).getText());
	  js(xpath(xpcolum));sleep(2);
	  js(xpath(xpcolum));sleep(2);
  }else {
	  System.out.println(xpath(xpcolum).getText());
	  js(xpath(xpcolum));sleep(2);
  }
	String[] aftersort=new String[colname.size()];
	  for (int i = 0; i < colname.size(); i++) {
		  aftersort[i]=colname.get(i).getText().trim();
		  System.out.println("afte sort-----------");
		  System.out.println(aftersort[i]);
		  listafter.add(aftersort[i]);
	}
		 if (sorted.equals(listafter)) {
			 String w = d.findElement(By.xpath(xpcolum)).getText();sleep(2);
			 extentTest.log(Status.INFO, w+" is Successfully Sorted in Descending Oreder");sleep(2);
		}else {
			String w = d.findElement(By.xpath(xpcolum)).getText();sleep(2);
			 extentTest.log(Status.INFO, w+" is not  Sorted in Descending Oreder");sleep(2);
		}
		sleep(2);
		sa.assertEquals(sorted, listafter);
		 sa.assertAll();
 }
  public void move(WebElement xp) throws Exception {
	  Actions ac=new Actions(d);
	 ac.moveToElement(xp).build().perform();;sleep(1);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @BeforeMethod
	public void  portal(ITestContext context, Method m) {
		Capabilities cap= ((RemoteWebDriver)d).getCapabilities();
		String device = cap.getBrowserName() + "  -  " +cap.getBrowserVersion();
			ExtentTest extenttest1 = extent.createTest(context.getName()+" - "+m.getName());
			this.extenttest=extenttest1;
			extenttest.assignDevice(device);
	}
	@AfterMethod
	public void checkstatus(ITestResult result, Method m) throws Exception {
		Thread.sleep(2000);
		if(result.getStatus()==ITestResult.FAILURE) {
			  TakesScreenshot ss= (TakesScreenshot)d; String sourcefile =
			  ss.getScreenshotAs(OutputType.BASE64);
			  extenttest.addScreenCaptureFromBase64String(sourcefile);
			  extenttest.fail(m.getName()+" is failed     "+result.getThrowable());Thread.sleep(3000);
		} 
			  else if (result.getStatus()==ITestResult.SUCCESS) {
				extenttest.pass(m.getName()+" is passed");
	}
		else if (result.getStatus()==ITestResult.SKIP) {
			extenttest.skip(m.getName()+" is skipped");
		}
	}
	 @BeforeSuite
		public void Before_report() throws Exception {
		 extent = new ExtentReports();
		  ExtentSparkReporter spark = new ExtentSparkReporter("  - Extentreport.html");
			extent.attachReporter(spark);
			  spark.config().setReportName("Comp India-QA");
			ExtentSparkReporter spark1 = new ExtentSparkReporter("  - Failedcases.html");
			spark1.filter().statusFilter().as(new Status[] {Status.FAIL});
			extent.attachReporter(spark1);
			spark1.config().setReportName("Comp India-QA");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			 Thread.sleep(1000);
		}
		@AfterSuite
		public void After_report() {
			extent.flush();
		}
		public void pagination_only() throws Exception {
			WebElement next = xpath("//li[@class='next']");
			  while(next.isDisplayed()==true) {
				  next.click();sleep(2);
				  System.out.println("cliked");
				  try {
					xpath("//li[@class='next disabled']").isDisplayed();
					break;
				} catch (Exception e) {
				}
			  }
		}
}
