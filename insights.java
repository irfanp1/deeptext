package topicmodel;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class insights extends base{
	 
   public void ready_check(String pname) throws Exception {implisitwait(30);
	  project_search(pname);
	  js(xpath("//p[.='Ready ']"));
	  sleep(5);
  }
  public void sentiment_analysis(String pname,ExtentTest extentTest) throws Exception {implisitwait(3);
	  ready_check(pname);
	  js(xpath("//button[.='Sentiment Analysis']"));sleep(5);
	  move(xpath("//*[@class='trend-graph-cont trends-bar-chart mb-3 pb-3']/canvas"));sleep(3);
//	  search_with_pagination("product", extentTest);
//		 List<WebElement> it1 = d.findElements(By.xpath("//div[@role='columnheader']/div"));
//			System.out.println("Number of columns :"+ it1.size());
//			 for (int i = 1; i <=it1.size(); i++) {
//				 String a = xpath("(//div[@role='columnheader']/div)["+i+"]").getText();
//				 System.out.println(a);
//				 sort_with_pagination(extentTest, "//div[contains(@id,'row')]/child::div["+i+"]","(//div[@role='columnheader']/div)["+i+"]" );
//			sleep(2);
//			 }
//	  search_with_pagination("product is", extentTest);
	
	  	//topics pie chart
	  List<WebElement> list = d.findElements(By.xpath("//*[name()='g']//*[name()='text']"));
	  System.out.println("count"+list.size());
	  for (int i = 1; i <=list.size(); i++) {
		move(xpath("(//*[local-name()='svg']//*[name()='g' ]//*[name()='text'])["+i+"]"));sleep(1);
		  List<WebElement>	tolltip=d.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])"));
		System.out.println("tollsize"+tolltip.size());
		for (int j = 1; j <=tolltip.size(); j++) {
			String value = xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])["+j+"]").getText().trim();
		sleep(1);
		System.out.println(value);
		extentTest.log(Status.INFO, value);
		}
	}
	  }
  public void actionable_insights(String pname,ExtentTest extentTest) throws Exception {
	  ready_check(pname);
	  js(xpath("//button[.='Actionable Insights']"));sleep(5);
	//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div[1]
	 // (//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[@role='columnheader']/div)[2]
	  List<WebElement> positive = d.findElements(By.xpath(" (//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[@role='columnheader']/div)"));
	  for (int i = 1; i <=positive.size(); i++) {
		String column=" (//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
		System.out.println(xpath(column).getText());
		String list = "//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
	sortFunction_ascending(list, column, extentTest);
	sleep(2);
	  }
	  for (int i = 1; i <=positive.size(); i++) {
			String column=" (//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
			System.out.println(xpath(column).getText());
			String list = "//div[@class='col-9 pd-table-title ']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
		sortFunction_descending(list, column, extentTest,i);
		sleep(2);
		  }
  }
  public void f(String pname,ExtentTest extentTest) throws Exception {
	  ready_check(pname);sleep(6);
	  String topics = xpath("(//h3)[1]").getText();
	  extentTest.log(Status.INFO, "Total Number of Topics---"+topics);sleep(2);
	  String TotalRows = xpath("(//h3)[2]").getText();
	  extentTest.log(Status.INFO, "Total Number of Rows In File---"+TotalRows);sleep(2);
	  String TotalSentences = xpath("(//h3)[3]").getText();
	  extentTest.log(Status.INFO, "Total Number of Sentences---"+TotalSentences);sleep(2);
	  String TotalWordsAnalyzed = xpath("(//h3)[4]").getText();
	  extentTest.log(Status.INFO, "Total Number of Words Analyzed---"+TotalWordsAnalyzed);sleep(2);
	  
//	List<WebElement> subTopics = d.findElements(By.xpath("//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[@role='columnheader']/div"));
//	  System.out.println(subTopics.size());
//	  for (int i = 1; i <=subTopics.size();) {
//		String head = "(//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
//		System.out.println(xpath(head).getText());
//		String lt = "//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
//	  sortFunction_ascending( lt,head, extentTest);
//	  sleep(2);
//	  i++;
//	  }
//		List<WebElement> key_phrases = d.findElements(By.xpath("//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[@role='columnheader']/div"));
//		  System.out.println(key_phrases.size());
//		  for (int i = 1; i <=key_phrases.size();) {
//			String head = "(//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
//			System.out.println(xpath(head).getText());
//			String lt = "//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
//		  sortFunction_ascending( lt,head, extentTest);
//		  sleep(2);
//		  i++;
//		  }
//		  List<WebElement> subTopics1 = d.findElements(By.xpath("//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[@role='columnheader']/div"));
//		  System.out.println(subTopics1.size());
//		  for (int i = 1; i <=subTopics1.size();) {
//			String head = "(//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
//			System.out.println(xpath(head).getText());
//			String lt = "//div[.='Sub-Topics Count by Topics']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
//		  sortFunction_descending( lt,head, extentTest,i);
//		  sleep(2);
//		  i++;
//		  }
//			List<WebElement> key_phrases1 = d.findElements(By.xpath("//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[@role='columnheader']/div"));
//			  System.out.println(key_phrases1.size());
//			  for (int i = 1; i <=key_phrases1.size();) {
//				String head = "(//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[@role='columnheader']/div)["+i+"]";
//				System.out.println(xpath(head).getText());
//				String lt = "//div[.='Important Key Phrases']/../following-sibling::div/descendant::div[contains(@id,'row')]/child::div["+i+"]";
//			  sortFunction_descending( lt,head, extentTest,i);
//			  sleep(2);
//			  i++;
//			  }
	  for (int i = 1; i <=3; i++) {
			  js(xpath("(//a[.='View All'])["+i+"]"));sleep(4);
	 if (xpath("//p[.='Sunburst Chart']").isDisplayed()){
		  js(xpath("//button[.='Summary']"));sleep(4);
	  }
	  }
	  js(xpath("(//a[.='View All'])[4]"));sleep(4);
	  if (xpath("//h2[.='Actionable Insights']").isDisplayed()){
		  js(xpath("//button[.='Summary']"));sleep(4);
	  }
  }
  
  public void trends(String pname,ExtentTest extentTest) throws Exception {
	  ready_check(pname);sleep(2);
	  js(xpath("//button[.='Trends']"));sleep(5);
	  scroll(xpath("(//p[.='Topics Distribution'])[1]"));sleep(2);
	 
	//topic distribution pie chart
	  extentTest.log(Status.INFO, "topic distribution pie chart");
	  List<WebElement> list = d.findElements(By.xpath(" (//*[local-name()='svg'])[1]//*[name()='g']//*[name()='text' and @font-size='11']"));
	  System.out.println("count"+list.size());
	  for (int i = 1; i <=list.size();) {
		move(xpath(" ((//*[local-name()='svg'])[1]//*[name()='g']//*[name()='text' and @font-size='11'])["+i+"]"));sleep(1);
		  List<WebElement>	tolltip=d.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])"));
		System.out.println("tollsize"+tolltip.size());
		for (int j = 1; j <=tolltip.size(); j++) {
			String value = xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])["+j+"]").getText().trim();
		sleep(1);
		System.out.println(value);
		extentTest.log(Status.INFO, value);
		}
		
		js(xpath("(//p[.='Topics Distribution'])[1]"));
		 i++;
	}
	//topic distribution bar chart
	  extentTest.log(Status.INFO, "topic distribution bar chart");
	  List<WebElement> lt = d.findElements(By.xpath("(//*[local-name()='svg'])[2]//*[name()='g']//*[name()='g']//*[name()='rect' and @stroke-width='0' and @stroke='none' and @width>=5 ]"));
	  System.out.println("count"+lt.size());
	  for (int i = 1; i <=lt.size();) {
		  move(xpath("((//*[local-name()='svg'])[2]//*[name()='g']//*[name()='g']//*[name()='rect' and @stroke-width='0' and @stroke='none' and @width>=5 ])["+i+"]"));
		  List<WebElement>	tolltip=d.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])"));
			System.out.println("tollsize"+tolltip.size());
			for (int j = 1; j <=tolltip.size(); j++) {
				String value = xpath("(//*[local-name()='svg']//*[name()='g' and @class='google-visualization-tooltip']//*[name()='g']//*[name()='text'])["+j+"]").getText().trim();
			sleep(1);
			System.out.println(value);
			extentTest.log(Status.INFO, value);
			}
			js(xpath("(//p[.='Topics Distribution'])[1]"));
		  i++;
	  }
	}
  		public void search_with_pagination(String searchword,ExtentTest extentTest) throws Exception {
  			 String[] beforesort;List <String> contains_list=new ArrayList();
  			d.navigate().refresh();sleep(3);
  			 List<String>sorted;
  			int last_page = 0;
  			xpath("//input").sendKeys(searchword);sleep(2);
  			js(xpath("//i[@class='icon-search']"));sleep(3);
  			try {
  				if(xpath("//button[@class='last-paginate me-2 ms-1']/preceding::a[2]").isDisplayed()==true) {
  					String count = xpath("//button[@class='last-paginate me-2 ms-1']/preceding::a[2]").getText();
  					 last_page=Integer.parseInt(count);
  					 System.out.println(last_page);
  				}
			} catch (Exception e) {
				
			}
  			if (last_page!=0) {
				for (int i = 0; i <=last_page-1 ;) {
					sleep(2);
					List<WebElement> collist = d.findElements(By.xpath("//div[contains(@id,'row')]/child::div[1]"));
				      beforesort = new String[collist.size()];
				     List<WebElement> show = d.findElements(By.xpath("//div[@class='content-css']/child::span/child::span[1]/child::span[3]/child::span/child::span/child::a[text()='Show more']"));
				     System.out.println("show more count"+show.size());
				     System.out.println(collist.size());
				     if(show.size()!=0) {
						  for (int j2 = 1; j2 <=show.size(); j2++) {
							  scroll(xpath("//div[@class='content-css']/child::span/child::span[1]/child::span[3]/child::span/child::span/child::a[text()='Show more'][1]"));
							  js(xpath("//div[@class='content-css']/child::span/child::span[1]/child::span[3]/child::span/child::span/child::a[text()='Show more'][1]"));
							  sleep(1);
						  }
					  }
				  for (int j = 0; j < collist.size(); j++) {
				  beforesort[j]=collist.get(j).getText().trim();
					  System.out.println(beforesort[j]);
					  contains_list.add(beforesort[j]);
				}
				  sleep(1);
				  try {
					  xpath("(//li[@class='next'])[1]").click();sleep(2);
				} catch (Exception e) {
					
				}
					i++;
				}
			}else {
				List<WebElement> collist = d.findElements(By.xpath("//div[contains(@id,'row')]/child::div[1]"));
			      beforesort = new String[collist.size()];
			      System.out.println(collist.size());
			      List<WebElement> show = d.findElements(By.xpath("//div[@class='content-css']/child::span/child::span[1]/child::span[3]/child::span/child::span/child::a[text()='Show more']"));
				     System.out.println(show.size());
				     if(show.size()!=0) {
						  for (int j2 = 1; j2 <=show.size(); j2++) {
							  js(xpath("//div[@class='content-css']/child::span/child::span[1]/child::span[3]/child::span/child::span/child::a[text()='Show more'][1]"));
							  sleep(1);
						  }
					  }
			  for (int j = 0; j < collist.size(); j++) {
			  beforesort[j]=collist.get(j).getText().trim();
				  System.out.println(beforesort[j]);
				  contains_list.add(beforesort[j]);
			}
			}
  			for (int i = 0; i < contains_list.size(); i++) {
					String sentence = contains_list.get(i).trim();
					System.out.println("--------------------------");
					System.out.println(sentence);
					sa.assertTrue(sentence.toLowerCase().contains(searchword.toLowerCase()));
					boolean result = sentence.toLowerCase().contains(searchword.toLowerCase());
					if(result==false) {
						 extentTest.log(Status.INFO, sentence+" --does not contain--"+searchword);
					}
			}
  			sa.assertAll();
  		}
  public void sort_with_pagination(ExtentTest extentTest,String xplist, String xpcolum) throws Exception {
		
	  List<String> bsort; List<String> as_sort;List<String>sorted_ascen;List<String>sorted_descen;List<String> des_sort;
		 d.navigate().refresh();sleep(3);
			
	 bsort = sort_call(xplist);
	 System.out.println("--------l-----");
	 Collections.sort(bsort,String.CASE_INSENSITIVE_ORDER);
	 sorted_ascen = bsort.stream().collect(Collectors.toList());
	 sorted_ascen.forEach(System.out::println);
	 d.navigate().refresh();sleep(3);
   scroll(xpath(xpcolum));sleep(1);
	 d.findElement(By.xpath(xpcolum)).click();sleep(3);
	 as_sort = sort_call(xplist);
	 sleep(2);
	 if (sorted_ascen.equals(as_sort)) {
		 String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
		 extentTest.log(Status.INFO, w+" is Successfully Sorted in Ascending Order");Thread.sleep(2000);
	}else {
		String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
		 extentTest.log(Status.INFO, w+" is not  Sorted in Ascending Order");Thread.sleep(2000);
	}
	 sleep(2);
	sa.assertEquals(sorted_ascen, as_sort);
	
	Collections.reverse(bsort);
	sorted_descen = bsort.stream().collect(Collectors.toList());
	sorted_descen.forEach(System.out::println);
		 d.navigate().refresh();sleep(3);
		scroll(xpath(xpcolum));sleep(1);
		 d.findElement(By.xpath(xpcolum)).click();sleep(2);
		 d.findElement(By.xpath(xpcolum)).click();sleep(2);
		 des_sort = sort_call(xplist);
		 sleep(2);
		 if (sorted_descen.equals(des_sort)) {
			 String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
			 extentTest.log(Status.INFO, w+" is Successfully Sorted in Descending Order");Thread.sleep(2000);
		}else {
			String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
			 extentTest.log(Status.INFO, w+" is not  Sorted in Descending Order");Thread.sleep(2000);
		}
		 sleep(2);
		sa.assertEquals(sorted_descen, des_sort);
	 sa.assertAll();
  }

  public List<String> sort_call(String xplist) throws Exception{
	  int last_page = 0;
	  try {
			if(xpath("//button[@class='last-paginate me-2 ms-1']/preceding::a[2]").isDisplayed()==true) {
				String count = xpath("//button[@class='last-paginate me-2 ms-1']/preceding::a[2]").getText();
				 last_page=Integer.parseInt(count);
				 System.out.println(last_page);
			}
		} catch (Exception e) {
			
		}
	  List<String> list = new ArrayList<>();
	  if (last_page!=0) { 
	  while( xpath("(//li[@class='next'])[1]").isDisplayed()==true) {
		  sleep(2);
		  List<WebElement> colname = d.findElements(By.xpath(xplist));
		     String[] list_data = new String[colname.size()];
		for (int i = 0; i < colname.size(); i++) {
			  list_data[i]=colname.get(i).getText().trim();
			 // System.out.println(list_data[i]);
			  list.add(list_data[i]);
			  //sleep(1);
		}
		  scroll( xpath("(//li[@class='next'])[1]"));sleep(1);
		  xpath("(//li[@class='next'])[1]").click();sleep(3);
		  System.out.println("--------cliked--------------");
		  try {
			boolean o = xpath("(//li[@class='next disabled'])[1]").isDisplayed();
			if(o==true) {
			List<WebElement> colname1 = d.findElements(By.xpath(xplist));
			 for (int i = 0; i < colname1.size(); i++) {
				 list_data[i]=colname1.get(i).getText().trim();
					 // System.out.println(list_data[i]);
					  list.add(list_data[i]);
					 // sleep(1);
				}}sleep(2);
			break;
		} catch (Exception e) {
		}
	  }
	  }else {
		  List<WebElement> colname = d.findElements(By.xpath(xplist));
		     String[] list_data = new String[colname.size()];
		for (int i = 0; i < colname.size(); i++) {
			  list_data[i]=colname.get(i).getText().trim();
			  System.out.println(list_data[i]);
			  list.add(list_data[i]);
		}
	}
	  return list;
  }
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
//  public void sort_descending(ExtentTest extentTest,String xplist, String xpcolum) throws Exception {
//	  List<String> bsort; List<String> asort;List<String>sorted;
//		 d.navigate().refresh();sleep(3);
//	 bsort = sort_call(xplist);
//	 System.out.println("--------l-----");
//	 Collections.sort(bsort,String.CASE_INSENSITIVE_ORDER);
//		Collections.reverse(bsort);
//	   sorted = bsort.stream().collect(Collectors.toList());
//	   sorted.forEach(System.out::println);
//		 d.navigate().refresh();sleep(3);
//		scroll(xpath(xpcolum));sleep(1);
//		 d.findElement(By.xpath(xpcolum)).click();sleep(2);
//		 d.findElement(By.xpath(xpcolum)).click();sleep(2);
//		 asort = sort_call(xplist);
//		 sleep(2);
//		 if (sorted.equals(asort)) {
//			 String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//			 extentTest.log(Status.INFO, w+" is Successfully Sorted in Descending Order");Thread.sleep(2000);
//		}else {
//			String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//			 extentTest.log(Status.INFO, w+" is not  Sorted in Descending Order");Thread.sleep(2000);
//		}
//		 sleep(2);
//		sa.assertEquals(sorted, asort);
//		 sa.assertAll();
//}
//  public void sort_ascending_with_pagination(ExtentTest extentTest,String xplist, String xpcolum) throws Exception {
//	  	 String[] beforesort;List <String> llistbefore=new ArrayList();
//		  String[] aftersort;List <String> listafter=new ArrayList();
//		 List<String>sorted;
//		 d.navigate().refresh();sleep(3);
//	  while( xpath("(//li[@class='next'])[1]").isDisplayed()==true) {
//		  sleep(2);
//		  List<WebElement> colname = d.findElements(By.xpath(xplist));
//		     beforesort=new String[colname.size()];
//		  for (int i = 0; i < colname.size(); i++) {
//		  beforesort[i]=colname.get(i).getText().trim();
//			  System.out.println(beforesort[i]);
//			  llistbefore.add(beforesort[i]);
//		}
//		  scroll( xpath("(//li[@class='next'])[1]"));sleep(1);
//		  xpath("(//li[@class='next'])[1]").click();sleep(2);
//		  System.out.println("--------cliked--------------");
//		  try {
//			boolean o = xpath("(//li[@class='next disabled'])[1]").isDisplayed();
//			if(o==true) {
//			List<WebElement> colname1 = d.findElements(By.xpath(xplist));
//			 for (int i = 0; i < colname1.size(); i++) {
//				  beforesort[i]=colname1.get(i).getText().trim();
//					  System.out.println(beforesort[i]);
//					  llistbefore.add(beforesort[i]);
//				}}sleep(2);
//			break;
//		} catch (Exception e) {
//		}
//	  }
//	 System.out.println("--------l-----");
//
//	 Collections.sort(llistbefore,String.CASE_INSENSITIVE_ORDER);
//   sorted = llistbefore.stream().collect(Collectors.toList());
//sorted.forEach(System.out::println);
//	 d.navigate().refresh();sleep(3);
//scroll(xpath(xpcolum));sleep(1);
//	 d.findElement(By.xpath(xpcolum)).click();sleep(3);
//	 while(xpath("(//li[@class='next'])[1]").isDisplayed()==true) {
//		 sleep(2);
//		  List<WebElement> colname = d.findElements(By.xpath(xplist));
//		     aftersort=new String[colname.size()];
//		     System.out.println("----after sort-------");
//		  for (int i = 0; i < colname.size(); i++) {
//			  aftersort[i]=colname.get(i).getText().trim();
//			  System.out.println(aftersort[i]);
//			  listafter.add(aftersort[i]);
//		}
//		  scroll( xpath("(//li[@class='next'])[1]"));sleep(1);
//		  xpath("(//li[@class='next'])[1]").click();sleep(3);
//		  System.out.println("--------cliked--------------");
//		  try {
//			boolean o = xpath("//li[@class='next disabled']").isDisplayed();
//			if(o==true) {
//			List<WebElement> colname1 = d.findElements(By.xpath(xplist));
//			 for (int i = 0; i < colname1.size(); i++) {
//				 aftersort[i]=colname1.get(i).getText().trim();
//					  System.out.println(aftersort[i]);
//					  listafter.add(aftersort[i]);
//				}}sleep(2);
//			break;
//		} catch (Exception e) {
//		}
//	  }
//	 sleep(2);
//	 if (sorted.equals(listafter)) {
//		 String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//		 extentTest.log(Status.INFO, w+" is Successfully Sorted in Ascending Order");Thread.sleep(2000);
//	}else {
//		String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//		 extentTest.log(Status.INFO, w+" is not  Sorted in Ascending Order");Thread.sleep(2000);
//	}
//	 sleep(2);
//	sa.assertEquals(sorted, listafter);
//	 sa.assertAll();
//}
//public void sort_descending_with_pagination(ExtentTest extentTest,String xplist, String xpcolum) throws Exception {
//	  	 String[] beforesort;List <String> llistbefore=new ArrayList();
//		  String[] aftersort;List <String> listafter=new ArrayList();
//		 List<String>sorted;
//		 d.navigate().refresh();sleep(3);
//	  while( xpath("(//li[@class='next'])[1]").isDisplayed()==true) {
//		  sleep(2);
//		  List<WebElement> colname = d.findElements(By.xpath(xplist));
//		     beforesort=new String[colname.size()];
//		  for (int i = 0; i < colname.size(); i++) {
//		  beforesort[i]=colname.get(i).getText().trim();
//			  System.out.println(beforesort[i]);
//			  llistbefore.add(beforesort[i]);
//		}
//		  scroll( xpath("(//li[@class='next'])[1]"));sleep(1);
//		  xpath("(//li[@class='next'])[1]").click();sleep(2);
//		  System.out.println("--------cliked--------------");
//		  try {
//			boolean o = xpath("(//li[@class='next disabled'])[1]").isDisplayed();
//			if(o==true) {
//			List<WebElement> colname1 = d.findElements(By.xpath(xplist));
//			 for (int i = 0; i < colname1.size(); i++) {
//				  beforesort[i]=colname1.get(i).getText().trim();
//					  System.out.println(beforesort[i]);
//					  llistbefore.add(beforesort[i]);
//				}}sleep(2);
//			break;
//		} catch (Exception e) {
//		}
//	  }
//	 System.out.println("--------l-----");
//	Collections.sort(llistbefore,String.CASE_INSENSITIVE_ORDER);
//	Collections.reverse(llistbefore);
//sorted = llistbefore.stream().collect(Collectors.toList());
//sorted.forEach(System.out::println);
//	 d.navigate().refresh();sleep(3);
//	scroll(xpath(xpcolum));sleep(1);
//	 d.findElement(By.xpath(xpcolum)).click();sleep(2);
//	 d.findElement(By.xpath(xpcolum)).click();sleep(2);
//	 while(xpath("(//li[@class='next'])[1]").isDisplayed()==true) {
//		 sleep(2);
//		  List<WebElement> colname = d.findElements(By.xpath(xplist));
//		     aftersort=new String[colname.size()];
//		     System.out.println("----after sort-------");
//		  for (int i = 0; i < colname.size(); i++) {
//			  aftersort[i]=colname.get(i).getText().trim();
//			  System.out.println(aftersort[i]);
//			  listafter.add(aftersort[i]);
//		}
//		  scroll( xpath("(//li[@class='next'])[1]"));sleep(1);
//		  xpath("(//li[@class='next'])[1]").click();sleep(3);
//		  System.out.println("--------cliked--------------");
//		  try {
//			boolean o = xpath("//li[@class='next disabled']").isDisplayed();
//			if(o==true) {
//			List<WebElement> colname1 = d.findElements(By.xpath(xplist));
//			 for (int i = 0; i < colname1.size(); i++) {
//				 aftersort[i]=colname1.get(i).getText().trim();
//					  System.out.println(aftersort[i]);
//					  listafter.add(aftersort[i]);
//				}}sleep(2);
//			break;
//		} catch (Exception e) {
//		}
//	  }
//	 sleep(2);
//	 if (sorted.equals(listafter)) {
//		 String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//		 extentTest.log(Status.INFO, w+" is Successfully Sorted in Descending Order");Thread.sleep(2000);
//	}else {
//		String w = d.findElement(By.xpath(xpcolum)).getText();Thread.sleep(2000);
//		 extentTest.log(Status.INFO, w+" is not  Sorted in Descending Order");Thread.sleep(2000);
//	}
//	 sleep(2);
//	sa.assertEquals(sorted, listafter);
//	 sa.assertAll();
//}
  
}
