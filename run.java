package topicmodel;

import org.testng.annotations.Test;

public class run extends base {
	authentication a= new authentication();
	project p=new project();
	groups g=new groups();
	insights is=new insights();
  @Test
  public void f() throws Exception {
	 String pname="sunn";
	  a.valid_login();
	 //is.sentiment_analysis(pname, extenttest);
	is.f(pname, extenttest);
	 // p.ready_project_edit(pname, extenttest);
	 // p.ready_error_status(pname, extenttest);
	//p.import_invalid_files(pname, extenttest);
	 // p.map_alerts(extenttest, pname);
	  
	  
	 // p.import_valid_file(extenttest, pname, "D:\\irf\\Deep-Automate\\validfiles\\Topic Modeling\\Industry Valid File.csv");
	  //p.sort_import_data(extenttest, pname);
	//  p.sort_train_model(extenttest, pname);
	  // p.mapping(extenttest, pname);
	
	  //p.grid_view(extenttest);
	// p.delete_project(pname, extenttest);
	 // p.model_settings_train("deep", "count", pname, "65", extenttest);
	 // p.list_view(extenttest);
	
	//p.import_valid_file(extenttest, pname, "D:\\irf\\Deep-Automate\\validfiles\\Topic Modeling\\Industry Valid File.csv");
 // p.mapping(extenttest, pname);
  }
}
