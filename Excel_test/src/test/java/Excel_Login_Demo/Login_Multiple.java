package Excel_Login_Demo;






import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;

import Excel_Login_Demo.ExcelUtils;

public class Login_Multiple {

	private String sTestCaseName;

	private int iTestCaseRow;

	WebDriver driver;

  @BeforeMethod

  public void beforeMethod() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prasan21\\Downloads\\Selenium_Sup\\chromedriver_win32\\chromedriver.exe");


	   driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("https://facebook.com");	 

      driver.manage().window().maximize();
  }	

  @Test(dataProvider = "Authentication")

  public void f(String sUserName, String sPassword,String sEmail) {

	  //  driver.findElement(By.id("email")).click();

	    try {
			driver.findElement(By.id("email")).sendKeys(sUserName);

			System.out.println(sUserName);

			driver.findElement(By.id("pass")).sendKeys(sPassword);

			System.out.println(sPassword);

			driver.findElement(By.xpath("//input[contains(@value,\"Log\")]")).click();
			
			Thread.sleep(3000);
            System.out.println("the third argument is"+sEmail);
			System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 //   driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

  }

  
 @AfterMethod
 public void afterMethod() {

	   driver.close();

  }

  @DataProvider

  public Object[][] Authentication() throws Exception{

	    // Setting up the Test Data Excel file

	 	ExcelUtils.setExcelFile("C:\\Users\\Prasan21\\Test\\Test_Sample_data.xlsx","Sheet1");

	 //	sTestCaseName = this.toString();

	  	// From above method we get long test case name including package and class name etc.

	  	// The below method will refine your test case name, exactly the name use have used

	  	//sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
	 	
	 	sTestCaseName="test4";

	    // Fetching the Test Case row number from the Test Data Sheet

	    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

	    Object[][] testObjArray = Excel_Utils.getTableArray("C:\\Users\\Prasan21\\Test\\Test_Sample_data.xlsx","Sheet1",iTestCaseRow);

	    	return (testObjArray);

		}

}