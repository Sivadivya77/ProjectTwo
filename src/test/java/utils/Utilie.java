package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utilie {
	
   
	public static WebDriver driver;
	public static Properties prop;
	public static String filepath;
	public static ExtentReports extents;
	public static ExtentTest test;
	public  String sheetname;
public static void LunchURL(String url,String browser) {
		
		//cross browser Test
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			
			driver= new EdgeDriver();
		}else {
			driver = new ChromeDriver();
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
		
public static void closingBrowser() {
		
		driver.close();
	}
public static String[][] readExcel(String sheetname) throws IOException {
    XSSFWorkbook book = new XSSFWorkbook("D:\\Eclipes\\MiniProject2\\src\\test\\resources\\ContactDetails.xlsx");
    XSSFSheet sheet = book.getSheet(sheetname);
    int rownum = sheet.getLastRowNum();
    int colnum = sheet.getRow(0).getLastCellNum();

    String[][] data = new String[rownum][colnum];

    for (int i = 1; i <= rownum; i++) {
        XSSFRow row = sheet.getRow(i);
        for (int j = 0; j < colnum; j++) {
            XSSFCell cell = (row != null) ? row.getCell(j) : null;

            // Check if cell is null or empty
            if (cell == null || cell.getCellType() == CellType.BLANK) {
                data[i - 1][j] = "";  // Assign empty string if cell is null
            } else {
                data[i - 1][j] = cell.getStringCellValue().trim();
            }
            
            System.out.println("Row " + i + ", Column " + j + ": " + data[i - 1][j]);
        }
    }
    book.close();
    return data;
}

		
public static void readFromPropFile(String filepath) throws IOException {
	
	FileReader file = new FileReader(filepath);
	prop = new Properties();
	prop.load(file);
}
		
	
	public static String screenshot(String name) throws IOException {
			
			String path="D:\\Eclipes\\MiniProject2\\screenshot\\"+name+".png";
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File test= new File(path);
			FileUtils.copyFile(scr, test);
			return path;
	}
	
			
			
		
		
	}

