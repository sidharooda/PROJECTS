package extentreport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	public static void main(String[] args) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
		 spark.config().setReportName("Login Report");
	        spark.config().setDocumentTitle("Chrome Test Report");
       ExtentReports extent=new ExtentReports();
       extent.attachReporter(spark);
       ExtentTest test = extent.createTest("Login - Chrome");
       WebDriver driver=new ChromeDriver();
       test.info("Chrome browser launched");
       driver.get("https://www.saucedemo.com/v1/");
       test.pass("1 pass");
       try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       test.info("Navigated to login page");
    // Enter username
       driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
       try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       test.info("enter usename");
       test.pass("2 success");
       driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
       test.pass("Entered password");
       try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
       test.pass("Clicked Login button");
       
       try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // or use expected condition on home page

       // Step 5: End
       test.pass("login attempt completed");
       driver.quit();
       extent.flush();
       
      
		
		
	}
}
		
		
       
        
       

      