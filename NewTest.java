package topicmodel;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	 String str[]= {"fj","GFSDJB","FJWFBJ","asdBN"};
	 String temp;
	 for (int j = 0; j < str.length; j++) {
		for (int i = j+1; i < str.length; i++) {
			if (str[i].compareTo(str[j])<0) {
				temp=str[j];
				str[j]=str[i];
				str[i]=temp;
			}
		}
		System.out.println(str[j]);
	}
	 
  }
}
