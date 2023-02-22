package topicmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class groups extends base {
  public void addgroup_with_alerts(ExtentTest extentTest,String Groupname,String Description) throws Exception {
	  implisitwait(20);
	  js(xpath("(//span[@class='menu-item-p'])[3]"));sleep(3);
	  try {//for new suer only
		//String t = xpath("//div[@class='sc-iwjdpV eBauma']/div").getText();
		//System.out.println(t);
	} catch (Exception e) {
	}
	  this.extenttest=extentTest;
	  WebElement addgroup = xpath("//i[@class='icon-add me-2']");
	  
	  js(addgroup);sleep(2);
	  WebElement groupname = xpath("//input");
	  WebElement description = xpath("//textarea");
	  WebElement add = xpath("//button[contains(@class,'btn next1 ms-3')]");
	  data_g(groupname, "abc");sleep(2);//min alert
	  js(add);sleep(1);
	  alerts_error(extenttest);
	  groupname.clear();sleep(3);
	  data_g(groupname, "Dravid holds a unique record of never getting out for a Golden duck in the 286 Test innings which he has played. He has faced 31258 balls, which is the highest number of balls faced by any player in test cricket.");sleep(3);
	  data_g(description, "Five-star hotels are properties that offer their guests the highest levels of luxury through personalized services, a vast range of amenities, and sophisticated accommodationsIn New Zealand, Qualmark, part of Tourism New Zealand, grades hotels from 12");sleep(3);
	  js(add);sleep(1);//max group name and description alert
	  alerts_error(extenttest);
	  groupname.clear();sleep(2);
	  data_g(groupname, Groupname);sleep(2);
	  description.clear();sleep(2);
	  data_g(description, Description);sleep(2);
	  js(add);sleep(4);
	  extenttest.log(Status.INFO, "Group added Successfully");
	  js(xpath("//i[@class='icon-add me-2']"));sleep(4);
	  
	  xpath("//input").sendKeys(Groupname);
	  xpath("//textarea").sendKeys(Description);
	  xpath("//button[contains(@class,'btn next1 ms-3')]").click();
	  WebElement al = d.findElement(By.xpath("(//span[@class='icon-alert me-2']/following::div)[1]"));
	  extenttest.log(Status.INFO, al.getText());
	  js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(2);
	  
  }
  public void data_g(WebElement xp,String content) {
	  WebElement c=xp; c.sendKeys(content);
  }
  public void search(String gname) throws Exception {
	  js(xpath("(//span[@class='menu-item-p'])[3]"));sleep(2);
	  xpath("//input[contains(@class,'form-control gv-search')]").sendKeys(gname+Keys.ENTER);sleep(2);
	 // xpath("//i[@class='icon-search']").click();sleep(2);
  }
  public void invalid_search(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  
	 search("pkyd452&*2");sleep(2);
	 String t = xpath("//div[@class='sc-iwjdpV eBauma']/div").getText();
	  extenttest.log(Status.INFO, t+"		for invaild search");
	  xpath("//i[contains(@class,'search-clear')]").click();sleep(2);
	  extenttest.log(Status.INFO, "		clear search icon is working fine");
  }
  public void edit_group(String gnam) throws Exception {
	  search(gnam);
	  js(xpath("(//div[@role='rowgroup'])[2]/child::div/child::div[3]/child::div/child::button/child::i[@class='icon-edit me-4']"));sleep(3);
	  xpath("//textarea").sendKeys("des");sleep(2);
	  js(xpath("//button[contains(@class,'btn next1 ms-3')]"));
	  WebElement al = d.findElement(By.xpath("(//span[@class='icon-tick me-2']/following::div)[1]"));
	  extenttest.log(Status.INFO, al.getText());sleep(3);
  }
  public void delete_group(String gnam,ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  search(gnam);
	  js(xpath("//i[@class='icon-delete']"));sleep(2);
	  js(xpath("//button[.='Cancel']"));sleep(2);
	  js(xpath("//i[@class='icon-delete']"));sleep(2);
	  js(xpath("//button[.='Delete']"));sleep(2);
	  snackbar_success(extenttest);
  }
 
}
