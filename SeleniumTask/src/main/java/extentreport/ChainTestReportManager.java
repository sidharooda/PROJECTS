//package extentreport;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class ChainTestReportManager {
//	public static void main(String[] args) {
//		 ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
//	        spark.config().setReportName("extentreport Report");
//	        spark.config().setDocumentTitle("extent Automation Report");
//
//	        ExtentReports extent = new ExtentReports();
//	        extent.attachReporter(spark);
//
//	        // Create Threads for Chrome and Firefox
//	        Thread chromeThread = new Thread(() -> runTest("chrome", extent));
//	        Thread firefoxThread = new Thread(() -> runTest("firefox", extent));
//
//	        // Start threads
//	        chromeThread.start();
//	        firefoxThread.start();
//
//	        // Wait for both to finish
//	        try {
//	            chromeThread.join();
//	            firefoxThread.join();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//
//	        // Flush Report
//	        extent.flush();
//	    }
//		
//		
//		
//	
//	
//
//public static void runTest(String browser, ExtentReports extent) {
//    WebDriver driver = null;
//    ExtentTest test = null;
//
//    
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            test = extent.createTest("extent on Chrome");
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            test = extent.createTest("extent on Firefox");
//        }
//
//       
//       
//
//
//        // Chain Steps
//        driver.get("https://www.instagram.com/accounts/login/");
//        test.info("Navigated to instagram Login Page");
//        try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        test.pass("1 pass");
//
//        // Simulate login
//        driver.findElement(By.name("username")).sendKeys("siddu9999_");
//        test.info("enter usernassme");
//        test.pass("Entered username");
//        try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        
//   
//        driver.findElement(By.name("password")).sendKeys("Ksiddu9@");
//        test.info("2 test");
//        test.pass("Entered password");
//        try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//      driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button/div")).click();
//      test.pass("Clicked Login button");
//      
//      try {
//		Thread.sleep(15000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} // or use expected condition on home page
//
//      // Step 5: End
//      test.pass("Instagram login attempt completed");
//      
//      
//      
//    
//    
//        if (driver != null) {
//            driver.quit();
//        
//    }
//}
//}
//
//
//
//
//
//
//
