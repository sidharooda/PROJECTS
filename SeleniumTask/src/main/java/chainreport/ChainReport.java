//package chainreport;
//
//import java.io.File;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.TestNG;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.aventstack.chaintest.domain.ChainTestEntity;
//import com.aventstack.chaintest.generator.ChainTestPropertyKeys;
//import com.aventstack.chaintest.generator.ChainTestSimpleGenerator;
//import com.aventstack.chaintest.generator.Generator;
//import com.aventstack.chaintest.plugins.ChainTestListener;
//
//
//
//
//
//@Listeners(com.aventstack.chaintest.plugins.ChainTestListener.class)
//public class ChainReport {
//	 static  WebDriver driver;
//	   static  ChainTestListener chaintestlistner=new ChainTestListener();
//	   
//	 
//	
//	public static void main(String[] args) {
//		 System.setProperty("chaintest.config.file", "src/main/resources/application.properties");
//			 
//		 Thread chromeTest = new Thread(() -> runTest("chrome"));
//       Thread firefoxTest = new Thread(() -> runTest("firefox"));
//
//	        chromeTest.start();
//	        firefoxTest.start();
//	        try {
//	            chromeTest.join(); // Wait for both threads to finish
//	            firefoxTest.join();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	        
//	        TestNG testng = new TestNG();
//	        testng.setTestClasses(new Class[] { Logintest.class }); // now it will resolve correctly
//	        testng.addListener(new ChainTestListener());
//	        testng.run();
//	       
//	}
//	 public static void runTest(String browser) {
//	        WebDriver driver = null;
//	        ChainTestListener chaintestlistner = new ChainTestListener();
//
//	        try {
//	            if (browser.equalsIgnoreCase("chrome")) {
//	                driver = new ChromeDriver();
//	                chaintestlistner.log("🟦 Running test on Chrome");
//	            } else if (browser.equalsIgnoreCase("firefox")) {
//	                driver = new FirefoxDriver();
//	                chaintestlistner.log("🟧 Running test on Firefox");
//	            }
//
//	            driver.get("https://www.instagram.com/accounts/login/");
//	            driver.manage().window().maximize();
//	            chaintestlistner.log("🚀 Launched browser and navigated to Instagram login");
//	            Thread.sleep(2000); // wait for page to load
//
//	            driver.findElement(By.name("username")).sendKeys("siddu9999_");
//	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@");
//	            driver.findElement(By.xpath("//*[@id='loginForm']/div[1]/div[3]/button/div")).click();
//
//	            Thread.sleep(5000); // wait for login
//
//	            String title = driver.getTitle();
//	            if (title.contains("Instagram")) {
//	            	chaintestlistner.log("✅ Login successful on " + browser);
//	            	captureScreenshot(driver, browser, chaintestlistner, "Login_Success_" + browser);
//	            } else {
//	                chaintestlistner.log("❌ Login failed on " + browser + " | Title: " + title);
//	                captureScreenshot(driver, browser, chaintestlistner, "Login_Failed_" + browser);
//	            }
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (driver != null) {
//	                driver.quit();
//	                chaintestlistner.log("🔚 Browser closed for " + browser);
//	            }
//	        }
//	    }
//
//	 private static void captureScreenshot(WebDriver driver, String browser, ChainTestListener chaintestlistner, String stepDescription) {
//	        try {
//	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            String screenshotPath = "screenshots/" + stepDescription + ".png";
//	            FileUtils.copyFile(screenshot, new File(screenshotPath));
//	            chaintestlistner.embed(new File(screenshotPath), "image/png");
//	            chaintestlistner.log("📸 Screenshot captured for " + browser + ": " + stepDescription);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	
//}
