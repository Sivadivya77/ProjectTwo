package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utilie;

public class ProjectSpecificationMethod extends Utilie {
	
	@BeforeSuite
	public void reportiniatialization() {
		ExtentSparkReporter reports= new ExtentSparkReporter("D:\\Eclipes\\MiniProject2\\reports\\MiniProject2.html");
		reports.config().setReportName("Projectone");
		
		extents = new ExtentReports();
		extents.attachReporter(reports);
	}
	@BeforeClass
	public void testDetails() {
	 test = extents.createTest("Contact List App", "");
	 test.assignCategory("Test Contact");
	 test.assignAuthor("siva");
	}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void lunchbrowser(String url,String browser) {
		
		LunchURL(url,browser);
		
	}
	
	@AfterMethod
	public void  browserclose() {
		 
		closingBrowser();
		
	}
	@DataProvider(name="readdata")
	public String[][] readData() throws Exception {
		
		String[][] data = readExcel(sheetname);
		return data;
	}

	
  @AfterSuite
  public void reportclose() {
	  extents.flush();
	  
  }
  
	

}
