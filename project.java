package topicmodel;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class project extends base {
	static List<String> collect;
	//String[] data;
	public void add_project(ExtentTest extentTest) throws Exception {
		this.extenttest=extentTest;
		  js(xpath("(//span[@class='menu-item-p'])[2]"));sleep(2);
			/*
			 * try {//new user only
			 * js(xpath("//button[@class='cp-btn d-flex align-items-center flex-nowrap']"));
			 * } catch (Exception e) {
			 * js(xpath("//button[@class='gv-btn btn-hover-blue']"));sleep(2); }
			 */
		 js(xpath("//button[@class='gv-btn btn-hover-blue']"));sleep(2);
		  extenttest.log(Status.INFO, "Navigate to Project Details");
	}
  public void project_alerts(ExtentTest extentTest) throws Exception {
	  this.extenttest=extentTest;
	  implisitwait(20);
	  add_project(extentTest);
	  WebElement name = xpath("//label[.='Project Name']/following::input[1]");
		WebElement description = xpath("//label[.='Project Description']/following::textarea");
		WebElement continue1 = xpath("//button[.='Continue']");
	  if (xpath("//button[.='Continue']").isEnabled()==true) {
		  extenttest.log(Status.INFO, "Defaulty Continue button is Disabled");
	} else {
		extenttest.log(Status.INFO, "Defaulty Continue button is not Disabled");
	}
	  //min
	  name.sendKeys("abc");sleep(1);description.sendKeys("klo");sleep(1);scroll(continue1);
		js(continue1);
		alerts_error(extentTest);sleep(2);
		// descriptiop max
		name.clear();sleep(1);name.sendKeys("abcd");
		description.clear();description.sendKeys("Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Never quit. Neve ");
		js(continue1);
		alerts_error(extentTest);sleep(2);
	}
	public void project_detasils(String project_name, ExtentTest extentTest ) throws Exception {
		add_project(extentTest);
		WebElement name = xpath("//label[.='Project Name']/following::input[1]");
		Select group = new Select(xpath("//select[.='Select Group']"));
		WebElement description = xpath("//label[.='Project Description']/following::textarea");
		WebElement keywords = xpath("//label[.='Keywords']/following::input");
		WebElement continue1 = xpath("//button[.='Continue']")	;
		WebElement draft = xpath("//button[.='Save as Draft']");
		name.sendKeys(project_name);sleep(2);
		group.selectByVisibleText("topic@1");sleep(2);
		description.sendKeys(" the problem the project will address, a set of goals for "
				+ "the project, the overall objectives for the project, as well as a project "
				+ "plan that describes the activities the members will undertake.");
		scroll( xpath("//button[.='Save as Draft']"));sleep(2);
		js(draft);snackbar_success(extentTest);
		sleep(2);js(continue1);
		js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(3);
	}
	public void project_name_duplicate(String project_name, ExtentTest extentTest ) throws Exception {
		add_project(extentTest);
		implisitwait(20);
		WebElement name = xpath("//label[.='Project Name']/following::input[1]");
		Select group = new Select(xpath("//select[.='Select Group']"));
		WebElement description = xpath("//label[.='Project Description']/following::textarea");
		WebElement continue1 = xpath("//button[.='Continue']")	;
		name.sendKeys(project_name);sleep(2);
		group.selectByVisibleText("topic@1");sleep(2);
		description.sendKeys("desc");sleep(2);
		js(continue1);snackbar_fail(extentTest);
  }
	public void invalid_project_search(ExtentTest extentTest) throws Exception {
		  this.extenttest=extentTest;
		  project_search("pkyd452&*2");sleep(2);
		 String t = xpath("//h2[@class='cp-proj-title']").getText();
		  extenttest.log(Status.INFO, t+"		for invaild search");
		  xpath("//i[contains(@class,'search-clear')]").click();sleep(2);
		  extenttest.log(Status.INFO, "		clear search icon is working fine");
	  }
	public void edit_project_grid(String project_name,int n) throws Exception {
		implisitwait(20);
       project_search(project_name);sleep(2);
		js(xpath("//i[contains(@class,'icon-more')]"));sleep(2);
		js(xpath("//p[.='Edit']"));sleep(2);
		for (int i = 1; i <=n ; i++) {
			WebElement continue1 = xpath("//button[.='Continue']")	;sleep(2);
			js(continue1);sleep(2);
		}
	}
	public void edit_project_list(String project_name) throws Exception {
		implisitwait(20);
		js(xpath("//button[@class='gv-lv-icon-a']")); sleep(2);
       project_search(project_name);sleep(2);
			WebElement resume = xpath("//button[@class='gv-next-btn ms-4']");sleep(2);
			js(resume);sleep(2);
	}
	public void analysis_type(String project_name,ExtentTest extentTest) throws Exception {
		 this.extenttest=extentTest;
		 implisitwait(20);
		edit_project_grid(project_name, 1);
		back_continue();sleep(3);
		boolean a = xpath("(//input)[1]").isSelected();
		System.out.println(a);
		  if ( xpath("(//input)[1]").isSelected()==true) {
			  extenttest.log(Status.INFO, "Defaulty Analysis type -Topic Modelling is seleceted ");
			  WebElement draft = xpath("//button[.='Save as Draft']");
			  js(draft);
			  snackbar_success(extentTest);
			  WebElement continue1 = xpath("//button[.='Continue']")	;
				js(continue1);
				js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(3);
		} else {
			extenttest.log(Status.INFO, "Defaulty Analysis type -Topic Modelling is not seleceted");
		}
	}
	public void import_invalid_files(String project_name,ExtentTest extentTest) throws Exception {
		 this.extenttest=extentTest;
		 implisitwait(20);
			//edit_project_list(project_name);
			edit_project_grid(project_name, 2);
			WebDriverWait wait= new WebDriverWait(d, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(xpath("//p[@class='cv-drop-title mt-3 mb-0']")));
			//js(xpath("//p[@class='cv-drop-title mt-3 mb-0']"));sleep(2);
invalid_file_snack(extentTest, "Header name is Missed in File","D:\\irf\\Deep-Automate\\invalidfiles\\columnnamemissed.csv");sleep(3);
invalid_file_snack(extentTest, "Duplicate Header Name in File","D:\\irf\\Deep-Automate\\invalidfiles\\duplicateheader.csv");sleep(3);
invalid_file_snack(extentTest, "One Empty Column in File","D:\\irf\\Deep-Automate\\invalidfiles\\oneemptycolumn.csv");sleep(3);
invalid_file_snack(extentTest, "Two  Column Header Merged in File","D:\\irf\\Deep-Automate\\invalidfiles\\twocolumnheadermerge.csv");sleep(3);	
invalid_file_snack(extentTest, " Empty Header in File","D:\\irf\\Deep-Automate\\invalidfiles\\emptyheader.csv");sleep(3);			
invalid_file_snack(extentTest, "  File Having Only Two Rows","D:\\irf\\Deep-Automate\\invalidfiles\\onlyonerow.csv");sleep(3);						
try {
	try {
		xpath("//p[@class='cv-drop-title mt-3 mb-0']").click();
		addfile("D:\\irf\\Deep-Automate\\invalidfiles\\emptyfile.csv");
		String q = xpath("//div[@class='sc-iwjdpV eBauma']/div").getText();
		extenttest.log(Status.INFO, "For empty file			"+q);
	} catch (Exception e) {
		js(xpath("//p[@class='cv-drop-title mt-3 mb-0']"));
		addfile("D:\\irf\\Deep-Automate\\invalidfiles\\emptyfile.csv");
		String q = xpath("//div[@class='sc-iwjdpV eBauma']/div").getText();
		extenttest.log(Status.INFO, "For empty file			"+q);
	}
} catch (Exception e) {
}
	}
	public void invalid_file_snack(ExtentTest extentTest,String fna,String file) throws Exception {
		 this.extenttest=extentTest;
		 implisitwait(20);
			WebDriverWait wait= new WebDriverWait(d, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(xpath("//p[@class='cv-drop-title mt-3 mb-0']")));
			try {
				xpath("//p[@class='cv-drop-title mt-3 mb-0']").click();
			} catch (Exception e) {
				js(xpath("//p[@class='cv-drop-title mt-3 mb-0']"));
			}
			sleep(2);
		 addfile(file);
		  WebElement al = d.findElement(By.xpath("(//span[@class='icon-alert me-2']/following::div)[1]"));
		  extenttest.log(Status.INFO, fna+"		-		"+al.getText());sleep(2);
	       js(xpath("(//span[@class='icon-alert me-2']/following::button)[1]"));
	}
	public void import_valid_file(ExtentTest extentTest,String project_name,String file) throws Exception {
		 this.extenttest=extentTest;
		 implisitwait(20);
			//edit_project_list(project_name);
			edit_project_grid(project_name, 2);
			back_continue();sleep(3);
			WebDriverWait wait= new WebDriverWait(d, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(xpath("//p[@class='cv-drop-title mt-3 mb-0']")));
			try {
				xpath("//p[@class='cv-drop-title mt-3 mb-0']").click();
			} catch (Exception e) {
				js(xpath("//p[@class='cv-drop-title mt-3 mb-0']"));
			}
			sleep(2);
			 addfile(file);
			WebElement al = xpath("//div[@class='mt-3 completed-import']");
			extenttest.log(Status.INFO, "	File	-		"+al.getText());sleep(5);
			WebDriverWait wait1= new WebDriverWait(d, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.visibilityOfAllElements(xpath("//div[@class='sc-egiyK bigAlm']")));
		WebElement continue1 = xpath("//button[.='Continue']")	;
		WebElement draft = xpath("//button[.='Save as Draft']");
		scroll( xpath("//button[.='Save as Draft']"));sleep(2);
		js(draft);snackbar_success(extentTest);
		sleep(2);js(continue1);
		js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(3);
	}
	public void sort_import_data(ExtentTest extentTest,String project_name) throws Exception {
		 this.extenttest=extentTest;
		 edit_project_grid(project_name, 2);
		List<WebElement> it = d.findElements(By.xpath("//div[@role='columnheader']/div"));
		System.out.println("Number of columns :"+ it.size());
		 for (int i = 1; i <=it.size(); i++) {
			 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
			 System.out.println(a);
			 sortFunction_ascending("//div[contains(@id,'row')]/child::div["+i+"]", "(//div[@role='columnheader']/div)["+i+"]", extentTest);
		sleep(2);
		 }
			sleep(2);
			List<WebElement> it1 = d.findElements(By.xpath("//div[@role='columnheader']/div"));
			 for (int i = 1; i <=it1.size(); i++) {
				 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
				 System.out.println(a);
				 sortFunction_descending("//div[contains(@id,'row')]/child::div["+i+"]", "(//div[@role='columnheader']/div)["+i+"]", extentTest,i);
			sleep(2);
			 }
	}
	public void sort_train_model(ExtentTest extentTest,String project_name) throws Exception {
		 this.extenttest=extentTest;
		 edit_project_grid(project_name, 3);
		List<WebElement> it = d.findElements(By.xpath("//div[@role='columnheader']/div"));
		System.out.println("Number of columns :"+ it.size());
		 for (int i = 1; i <=it.size(); i++) {
			 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
			 System.out.println(a);
			 sortFunction_ascending("//div[contains(@id,'row')]/child::div["+i+"]", "(//div[@role='columnheader']/div)["+i+"]", extentTest);
		sleep(2);
		 }
			sleep(2);
			List<WebElement> it1 = d.findElements(By.xpath("//div[@role='columnheader']/div"));
			 for (int i = 1; i <=it1.size(); i++) {
				 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
				 System.out.println(a);
				 sortFunction_descending("//div[contains(@id,'row')]/child::div["+i+"]", "(//div[@role='columnheader']/div)["+i+"]", extentTest,i);
			sleep(2);
			 }
	}
	public void model_settings_train(String Model,String Type,String name,String count,ExtentTest extentTest) throws Exception {
		//edit_project_grid(name, 3);
		 this.extenttest=extentTest;
		edit_project_list(name);
		WebElement train = d.findElement(By.xpath("//button[.='Start Training']"));
		Select model=new Select(xpath("(//label[.='Model Architecture Type ']/following::select)[1]"));
		Select topic=new Select(xpath("(//label[.='Model Architecture Type ']/following::select)[2]"));
		//Automatic Model Selection,Classic LDA,Deep Neural Network,BERT
		scroll(xpath("//label[.='Model Architecture Type ']"));sleep(2);
		if (Model.equalsIgnoreCase("BERT")) {
			model.selectByVisibleText("BERT");sleep(2);
		}else if (Model.equalsIgnoreCase("Classic LDA")||Model.contains("lassic")||Model.equalsIgnoreCase("lda")) {
			model.selectByVisibleText("Classic LDA");sleep(2);
		}else if (Model.equalsIgnoreCase("Deep Neural Network")||Model.contains("eep")) {
			model.selectByVisibleText("Deep Neural Network");sleep(2);
		}else if (Model.equalsIgnoreCase("Automatic Model Selection")||Model.contains("uto")) {
			model.selectByVisibleText("Automatic Model Selection");sleep(2);
		}
		if (Type.equalsIgnoreCase("auto")) {
			topic.selectByVisibleText("Auto");sleep(3);
			js(xpath("//button[.='Start Training']"));sleep(5);
		}else if (Type.equalsIgnoreCase("Preferred Count")||Type.contains("ount")) {
			topic.selectByVisibleText("Preferred Count");sleep(3);
			js(xpath("//button[.='Start Training']"));sleep(2);
			alerts_error(extenttest);
				xpath("//input[@type='number']").sendKeys(count);
				js(xpath("//button[.='Start Training']"));sleep(5);
			}
		String su = xpath("//h2[@class='st-mdl-h2 mb-4 px-4']").getText();
		extenttest.log(Status.INFO, su);sleep(2);
		js(xpath("//button[.='Go to Project Page']"));sleep(3);
	}

	public void map3(String v,String ctype) throws Exception {
		Select column_name1= new Select(xpath("(//select[@id='column_name'])[1]"));
		Select column_type1= new Select(xpath("(//select[@id='column_type'])[1]"));
		String q1 = column_name1.getFirstSelectedOption().getText();
		System.out.println(q1);
		if (q1.equalsIgnoreCase("Select Column")) {
			column_name1.selectByVisibleText(v);
			column_type1.selectByVisibleText(ctype);sleep(2);
		}else  {
			Select column_name2= new Select(xpath("(//select[@id='column_name'])[2]"));
			Select column_type2= new Select(xpath("(//select[@id='column_type'])[2]"));
			String q2 = column_name2.getFirstSelectedOption().getText();
			System.out.println(q2);
			if (q2.equalsIgnoreCase("Select Column")) {
				column_name2.selectByVisibleText(v);
				column_type2.selectByVisibleText(ctype);
			}else {
				Select column_name3= new Select(xpath("(//select[@id='column_name'])[3]"));
				Select column_type3= new Select(xpath("(//select[@id='column_type'])[3]"));
				String q3 = column_name3.getFirstSelectedOption().getText();
				System.out.println(q3);
				column_name3.selectByVisibleText(v);
				column_type3.selectByVisibleText(ctype);
			}
		}
		xpath("(//button[@id='addCol'])[1]").click();sleep(2);
	}
	public void map2(String v,String ctype) throws Exception {
		Select column_name1= new Select(xpath("(//select[@id='column_name'])[1]"));
		Select column_type1= new Select(xpath("(//select[@id='column_type'])[1]"));
		String q1 = column_name1.getFirstSelectedOption().getText();
		System.out.println(q1);
		if (q1.equalsIgnoreCase("Select Column")) {
			column_name1.selectByVisibleText(v);
			column_type1.selectByVisibleText(ctype);sleep(2);
		}else  {
			Select column_name2= new Select(xpath("(//select[@id='column_name'])[2]"));
			Select column_type2= new Select(xpath("(//select[@id='column_type'])[2]"));
			String q2 = column_name2.getFirstSelectedOption().getText();
			System.out.println(q2);
			if (q2.equalsIgnoreCase("Select Column")) {
				column_name2.selectByVisibleText(v);
				column_type2.selectByVisibleText(ctype);
			}
		}
		xpath("(//button[@id='addCol'])[1]").click();sleep(2);
	}
	public void map1(String v,String ctype) throws Exception {
		Select column_name1= new Select(xpath("(//select[@id='column_name'])[1]"));
		Select column_type1= new Select(xpath("(//select[@id='column_type'])[1]"));
		String q1 = column_name1.getFirstSelectedOption().getText();
		System.out.println(q1);
			column_name1.selectByVisibleText(v);
			column_type1.selectByVisibleText(ctype);sleep(2);
		xpath("(//button[@id='addCol'])[1]").click();sleep(2);
	}
	public void map_alerts(ExtentTest extentTest,String project_name) throws Exception {
		this.extenttest=extentTest;
		implisitwait(20);
		String file="D:\\irf\\Deep-Automate\\validfiles\\Topic Modeling\\mapalerts.csv";
	import_valid_file(extenttest, project_name, file);
	edit_project_grid(project_name, 3);sleep(3);
	
	
	WebElement b = xpath("(//button[@id='addCol'])[1]");
		WebElement add = xpath("//label[.='Add more Column']");
		sleep(3);
		js(b);sleep(2);js(xpath("(//button[@id='addCol'])[1]"));sleep(2);js(xpath("(//button[@id='addCol'])[1]"));sleep(2);
		snackbar_fail(extentTest);
		js(xpath("(//i[@class='icon-delete'])[2]"));js(xpath("(//i[@class='icon-delete'])[1]"));sleep(2);
		Select column_name1= new Select(xpath("(//select[@id='column_name'])[1]"));
		Select column_type1= new Select(xpath("(//select[@id='column_type'])[1]"));
		column_name1.selectByIndex(1);column_type1.selectByIndex(2);js(xpath("//label[.='Add more Column']"));sleep(4);
		Select column_name2= new Select(xpath("(//select[@id='column_name'])[2]"));
		Select column_type2= new Select(xpath("(//select[@id='column_type'])[2]"));
		column_name2.selectByIndex(1);sleep(2);snackbar_fail(extentTest);sleep(3);
		column_name2.selectByIndex(2);column_type2.selectByIndex(2);snackbar_fail(extentTest);sleep(3);js(xpath("//label[.='Add more Column']"));sleep(3);
		js(xpath("//button[contains(@class,'btn mf4-map-btn btn-hover-blue')]"));snackbar_fail(extentTest);sleep(3);
		Select column_name3= new Select(xpath("(//select[@id='column_name'])[3]"));
		column_name3.selectByIndex(3);
		js(xpath("//button[contains(@class,'btn mf4-map-btn btn-hover-blue')]"));snackbar_fail(extentTest);sleep(2);
	}
	public void mapping(ExtentTest extentTest,String project_name ) throws Exception {
		 this.extenttest=extentTest;
		 implisitwait(20);
		edit_project_grid(project_name, 3);sleep(3);
		List<WebElement> it = d.findElements(By.xpath("//div[@class='sc-crHmcD hFlTTV rdt_TableCol_Sortable']/div"));
		System.out.println("Number of columns :"+ it.size());
		it.stream().map(s->s.getText()).forEach(s->System.out.println(s));
		collect = it.stream().map(d->d.getText()).collect(Collectors.toList());
		back_continue();sleep(3);
		WebElement map_column =  xpath("//button[@class='btn mf4-map-btn btn-hover-blue disabled']");
		if (xpath("//button[@class='btn mf4-map-btn btn-hover-blue disabled']").isEnabled()==true) {
			  extenttest.log(Status.INFO, "Defaulty Map Column button is Disabled");
		} else {
			extenttest.log(Status.INFO, "Defaulty Map Column button is not Disabled");
		}
		try {
			d.findElement(By.xpath("//button[.='Start Training']"));
			extenttest.log(Status.INFO, "Before Mapping Training Button is  Displayed");
		} catch (Exception e) {
			extenttest.log(Status.INFO, "Before Mapping Training Button is Not Displayed");
		}
		collect.size();
		System.out.println(collect.size());
		if (collect.size()>3) {
			for (int i = 0; i <collect.size(); ) {
				String v = collect.get(i);
				System.out.println(collect.get(i));
				sleep(2);//||v.equalsIgnoreCase("text")||v.contains("eview")
				if(v.equalsIgnoreCase("text")||v.contains("ontent")||v.contains("eview")||v.equalsIgnoreCase("reviews")||v.contains("entence")) {
					map3(v, "Content");
				}else if (v.equalsIgnoreCase("Date")) {
				map3(v, "Date");
				}
				else if (v.equalsIgnoreCase("location")) {
					map3(v, "Location");
				}
 				i++;
			}
		}if (collect.size()==3) {
			for (int i = 0; i <collect.size(); ) {
				String v = collect.get(i);
				System.out.println(collect.get(i));
				sleep(2);//||v.equalsIgnoreCase("text")||v.contains("eview")
				if(v.equalsIgnoreCase("text")||v.contains("ontent")||v.contains("eview")||v.equalsIgnoreCase("reviews")||v.contains("entence")) {
					map3(v, "Content");
				}else if (v.equalsIgnoreCase("Date")) {
				map3(v, "Date");
				}
				else if (v.equalsIgnoreCase("location")) {
					map3(v, "Location");
				}else {
					map3(v, "Location");
				}
 				i++;
			}
		}
		if (collect.size()==2) {
			for (int i = 0; i <collect.size(); ) {
				String v = collect.get(i);
				System.out.println(collect.get(i));
				sleep(2);//||v.equalsIgnoreCase("text")||v.contains("eview")
				if(v.equalsIgnoreCase("text")||v.contains("ontent")||v.contains("eview")||v.equalsIgnoreCase("reviews")||v.contains("entence")) {
					map2(v, "Content");
					
				}else if (v.equalsIgnoreCase("Date")) {
					map2(v, "Date");
				}
				else if (v.equalsIgnoreCase("location")) {
					map2(v, "location");
				}else {
					map2(v, "Location");
				}
 				i++;
			}
		}if (collect.size()==1) {
			for (int i = 0; i <collect.size(); ) {
				String v = collect.get(i);
				System.out.println(collect.get(i));
				sleep(2);//||v.equalsIgnoreCase("text")||v.contains("eview")
				if(v.equalsIgnoreCase("text")||v.contains("ontent")||v.contains("eview")||v.equalsIgnoreCase("reviews")||v.contains("entence")) {
					map1(v, "Content");
					
				}else if (v.equalsIgnoreCase("Date")) {
					map1(v, "Date");
				}
				else if (v.equalsIgnoreCase("location")) {
					map1(v, "location");
				}else {
					map1(v, "Location");
				}
 				i++;
			}
		}
		js(map_column);sleep(2);
		snackbar_success(extentTest);
		 for (int i = 1; i <=it.size(); i++) {
			 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
			 System.out.println(a);
			 sortFunction_ascending("//div[contains(@id,'row')]/child::div["+i+"]", "(//div[@role='columnheader']/div)["+i+"]", extentTest);
		sleep(2);
		 }
		js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(3);
		
	}
	public void back_continue() throws Exception {
		implisitwait(20);
		sleep(2);
		scroll(xpath("//button[.='Back']"));sleep(2);
		js(xpath("//button[.='Back']"));sleep(3);
		scroll(xpath("//button[.='Continue']"));sleep(2);
		js(xpath("//button[.='Continue']"));sleep(3);
	}
	public void grid_view(ExtentTest extentTest) throws Exception {
		js(xpath("//span[.='Groups']"));sleep(2);
		js(xpath("//span[.='Projects']"));sleep(2);
		implisitwait(20);
		WebElement grid = xpath("(//div[@class='col-12 col-sm-12 col-lg-4 col-md-6 col-xl-3 mb-3 mb-sm-3 mb-md-4 mb-lg-4 d-flex justify-content-center'])[1]");
		sleep(3);
		extentTest.log(Status.INFO,"Is the project displayed in grid view : "+ grid.isDisplayed());
		
	}
	public void list_view(ExtentTest extentTest) throws Exception {
		implisitwait(20);
		js(xpath("//span[.='Projects']"));sleep(2);
		js(xpath("//button[@class='gv-lv-icon-a']")); sleep(3);
		WebElement list = xpath("(//div[@class='row d-flex align-items-center lv-row mb-3 p-0 mx-0'])[1]");
		sleep(3);
		extentTest.log(Status.INFO,"Is the project displayed in list view : "+ list.isDisplayed());
	}
	public void delete_project(String gnam,ExtentTest extentTest) throws Exception {
		implisitwait(20);
		  js(xpath("(//span[@class='menu-item-p'])[2]"));sleep(2);
		  js(xpath("//button[@class='gv-lv-icon-a']")); sleep(2);
		  project_search(gnam);
		 js(xpath("//i[contains(@class,'icon-more')]"));sleep(2);
		  js(xpath("//i[@class='icon-delete']"));sleep(2);
		  js(xpath("//button[.='Cancel']"));sleep(2);
		  js(xpath("//i[contains(@class,'icon-more')]"));sleep(2);
		  js(xpath("//i[@class='icon-delete']"));sleep(2);
		  js(xpath("(//button[.='Delete'])[2]"));sleep(2);
		  String a = xpath("//div[@class='swal-title']").getText();sleep(2);
		  extentTest.log(Status.INFO,a);
		  js(xpath("//button[.='OK']"));sleep(2);
	  }
	public void undelete_project(ExtentTest extentTest,String gname) throws Exception {
		// this.extenttest=extentTest;
		js(xpath("(//span[@class='menu-item-p'])[2]"));sleep(2);
		Select deleted = new Select(xpath("//select[@class='form-control gv-delete-drop']"));
		deleted.selectByVisibleText("Deleted");
		sleep(3);
		xpath("//input[contains(@class,'form-control gv-search')]").sendKeys(gname);sleep(2);
		 xpath("//i[@class='icon-search']").click();sleep(2);
		js(xpath("(//button[.='Undelete'])[1]"));
		snackbar_success(extentTest);
	}
	public void permanent_delete(ExtentTest extentTest,String gname) throws Exception {
		js(xpath("(//span[@class='menu-item-p'])[2]"));sleep(2);
		Select deleted = new Select(xpath("//select[@class='form-control gv-delete-drop']"));
		deleted.selectByVisibleText("Deleted");
		sleep(3);
		xpath("//input[contains(@class,'form-control gv-search')]").sendKeys(gname);sleep(2);
		 xpath("//i[@class='icon-search']").click();sleep(2);
		js(xpath("(//button[.='Delete'])[1]"));sleep(2);
		 js(xpath("//button[.='Cancel']"));sleep(2);
		 js(xpath("(//button[.='Delete'])[1]"));sleep(2);
		 js(xpath("(//button[.='Delete'])[2]"));sleep(2);
		snackbar_success(extentTest);
	}
	public void under_training_status(String project_name,ExtentTest extentTest) throws Exception {
		this.extenttest=extentTest;
		d.navigate().refresh();
		implisitwait(20);
		project_search(project_name);
		js(xpath("//p[.='Under Training']"));sleep(4);
		WebElement under_train_mes = xpath("//h2[@class='st-mdl-h2 mb-4 ']");
		extentTest.log(Status.INFO, project_name+"  -  "+under_train_mes.getText());
		System.out.println("Project is in under training");
		js(xpath("//button[.='Close']"));
		d.navigate().refresh();
		}
	
	public void ready_error_status(String project_name,ExtentTest extentTest) throws Exception {
		this.extenttest=extentTest;
		implisitwait(20);
		for(int i =0 ; i<11 ;i++) {
			try {
				project_search(project_name);sleep(3);
				try {
					if(xpath("//p[.='Ready ']").isDisplayed()==true) {
						sleep(3);
						extentTest.log(Status.INFO, project_name+"  is Ready");
						break;
						}
					}
					catch (Exception e) {
					if(xpath("//p[.='Error']").isDisplayed()==true) {
						js(xpath("//p[.='Error']"));sleep(7);
						String reason = xpath("//div[@class='text-start mb-4']/h2").getText();
						extentTest.log(Status.INFO, project_name+"  - Error occurred due to  "+reason);sleep(3);
						js(xpath("//i[@class='icon-add']"));sleep(3);
						break;
						}
				}
			} catch (Exception e) {
				sleep(10);
				d.navigate().refresh();
				i++;
			}
		}
	}
public void ready_project_edit(String project_name,ExtentTest extentTest) throws Exception {
	//edit_project_list(project_name);
	implisitwait(20);
	js(xpath("//i[contains(@class,'icon-more')]"));sleep(2);
	js(xpath("//p[.='Edit']"));sleep(3);
	WebElement description = xpath("//label[.='Project Description']/following::textarea");
	description.sendKeys("desc");sleep(3);
	scroll(xpath("//button[.='Update']"));sleep(2);
	js(xpath("//button[.='Update']"));sleep(2);
	snackbar_success(extentTest);
	js(xpath("//i[@class='icon-Back mf-icon-Back']"));sleep(3);
	}
	
	
	
	
}
