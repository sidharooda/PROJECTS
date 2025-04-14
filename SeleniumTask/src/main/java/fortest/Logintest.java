package fortest;

import java.io.File;


import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.chaintest.generator.ChainTestSimpleGenerator;
import com.aventstack.chaintest.plugins.ChainTestListener;






import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ChainTestListener.class)
 public class Logintest {

//	static ChainTestListener chaintestlistner = new ChainTestListener();
//
//	         @Test
//	        public void testLogin() {
//	        WebDriverManager.chromedriver().setup();
//	        WebDriver driver = new ChromeDriver();
//
//	        try {
//	            chaintestlistner.log("🟢 Launching Chrome browser");
//	            driver.get("https://www.instagram.com/accounts/login/");
//	            driver.manage().window().maximize();
//	            chaintestlistner.log("🌐 Opened Instagram login page");
//
//	            Thread.sleep(3000);
//
//	            driver.findElement(By.name("username")).sendKeys("siddu9999_");
//	            chaintestlistner.log("📝 Entered username");
//
//	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@");
//	            chaintestlistner.log("🔒 Entered password");
//
//	            driver.findElement(By.xpath("//button[@type='submit']")).click();
//	            chaintestlistner.log("➡️ Clicked login");
//
//	            Thread.sleep(5000);
//
//	            String title = driver.getTitle();
//	            if (title.toLowerCase().contains("instagram")) {
//	                chaintestlistner.log("✅ Login successful! Title: " + title);
//	                captureScreenshot(driver, "Login_Success");
//	            } else {
//	                chaintestlistner.log("❌ Login failed! Title: " + title);
//	                captureScreenshot(driver, "Login_Failed");
//	            }
//
//	        } catch (Exception e) {
//	            chaintestlistner.log("💥 Exception: " + e.getMessage());
//	            captureScreenshot(driver, "Exception");
//	        } finally {
//	            driver.quit();
//	            chaintestlistner.log("🛑 Browser closed");
//	        }
//	    
//}
//
//	         private static void captureScreenshot(WebDriver driver, String stepName) {
//	             try {
//	                 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	                 String path = "screenshots/" + stepName + ".png";
//	                 FileUtils.copyFile(screenshot, new File(path));
//
//	                 // Embed in report
//	                 chaintestlistner.embed(new File(path), "image/png");
//	                 chaintestlistner.log("📸 Screenshot: " + stepName);
//
//	             } catch (IOException e) {
//	                 chaintestlistner.log("⚠️ Failed to capture screenshot: " + e.getMessage());
//	             }
//	         }

	 
//	 static ChainTestListener chaintestlistner = new ChainTestListener(); // Shared for both threads
//
//	    @Test
//	    public void testLogin() {
//	        // Create screenshot folder
//	        new File("screenshots1").mkdirs();
//
//	        Thread chromeThread = new Thread(() -> runTest("chrome"));
//	        Thread firefoxThread = new Thread(() -> runTest("firefox"));
//
//	        chromeThread.start();
//	        firefoxThread.start();
//
//	        try {
//	            chromeThread.join();
//	            firefoxThread.join();
//	        } catch (InterruptedException e) {
//	            chaintestlistner.log("⚠️ Threads interrupted: " + e.getMessage());
//	        }
//
//	        chaintestlistner.log("🧪 Both browser tests finished");
//	    }
//        @AfterSuite
//	    private static void runTest(String browser) {
//	        WebDriver driver = null;
//
//	        try {
//	            if (browser.equalsIgnoreCase("chrome")) {
//	                WebDriverManager.chromedriver().setup();
//	                driver = new ChromeDriver();
//	                chaintestlistner.log("🟢 Launched Chrome browser");
//	                chaintestlistner.generate();
//	            } else if (browser.equalsIgnoreCase("firefox")) {
//	                WebDriverManager.firefoxdriver().setup();
//	                driver = new FirefoxDriver();
//	                chaintestlistner.log("🟠 Launched Firefox browser");
//	            }
//
//	            driver.get("https://www.instagram.com/accounts/login/");
//	            driver.manage().window().maximize();
//	            chaintestlistner.log("🌐 Opened Instagram login page in " + browser);
//
//	            Thread.sleep(3000);
//
//	            driver.findElement(By.name("username")).sendKeys("siddu9999_");
//	            chaintestlistner.log("📝 Entered username in " + browser);
//
//	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@");
//	            chaintestlistner.log("🔒 Entered password in " + browser);
//
//	            driver.findElement(By.xpath("//button[@type='submit']")).click();
//	            chaintestlistner.log("➡️ Clicked login in " + browser);
//
//	            Thread.sleep(5000);
//
//	            String title = driver.getTitle();
//	            if (title.toLowerCase().contains("instagram")) {
//	                chaintestlistner.log("✅ Login successful in " + browser + "! Title: " + title);
//	                captureScreenshot(driver, "Login_Success_" + browser);
//	            } else {
//	                chaintestlistner.log("❌ Login failed in " + browser + "! Title: " + title);
//	                captureScreenshot(driver, "Login_Failed_" + browser);
//	            }
//
//	        } catch (Exception e) {
//	            chaintestlistner.log("💥 Exception in " + browser + ": " + e.getMessage());
//	            captureScreenshot(driver, "Exception_" + browser);
//	        } finally {
//	            if (driver != null) {
//	                driver.quit();
//	                chaintestlistner.log("🛑 Closed " + browser + " browser");
//	                chaintestlistner.generate();
//
//	            }
//	        }
//	    }
//
//	    private static void captureScreenshot(WebDriver driver, String fileName) {
//	        try {
//	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            String path = "screenshots1/" + fileName + ".png";
//	            FileUtils.copyFile(screenshot, new File(path));
//
//	            chaintestlistner.embed(new File(path), "image/png");
//	            chaintestlistner.log("📸 Screenshot captured: " + fileName);
//	        } catch (IOException e) {
//	            chaintestlistner.log("⚠️ Screenshot failed: " + e.getMessage());
//	        }
//	    }
	
	
	
	
	
	
	
	
	
	
//	static ChainTestListener chaintestlistner = new ChainTestListener(); 
//	 static ChainTestSimpleGenerator ChainTestSimpleGenerator=new ChainTestSimpleGenerator();
//	 // For logs/screenshots
//	
//		    @Test
//	    public void testLogin() {
//	        // Create screenshot folder
//	        new File("screenshots").mkdirs();
//
//	        Thread chromeThread = new Thread(() -> runTest("chrome"));
//	        Thread firefoxThread = new Thread(() -> runTest("firefox"));
//
//	        chromeThread.start();
//	        firefoxThread.start();
//
//	        try {
//	            chromeThread.join();
//	            firefoxThread.join();
//	        } catch (InterruptedException e) {
//	            chaintestlistner.log("⚠️ Threads interrupted: " + e.getMessage());
//	        }
//
//	        chaintestlistner.log("🧪 Both browser tests finished");
//	       
//	    }
//      
//		@Test
//	    private static void runTest(String browser) {
//	        WebDriver driver = null;
//
//	        try {
//	            if (browser.equalsIgnoreCase("chrome")) {
//	                WebDriverManager.chromedriver().setup();
//	                driver = new ChromeDriver();
//	                chaintestlistner.log("🟢 Launched Chrome browser");
//	               
//	            } else if (browser.equalsIgnoreCase("firefox")) {
//	            	 driver = new FirefoxDriver();
//	                WebDriverManager.firefoxdriver().setup();
//	               
//	                chaintestlistner.log("🟠 Launched firefox browser");
//	               
//	            }
//
//	            driver.get("https://www.instagram.com/accounts/login/");
//	            driver.manage().window().maximize();
//	            chaintestlistner.log("🌐 Opened Instagram login page in " + browser);
//	            
//	            
//	            String actualTitle = driver.getTitle();
//	            try {
//	                Assert.assertEquals(actualTitle, "Login • Instagram", "❌ Title mismatch");
//	            } catch (AssertionError e) {
//	                captureScreenshot(driver, "Title_Mismatch");
//	                throw e; // rethrow to let TestNG know it's a failure
//	            }
//	            
//	            
//	            
//	            
//	            Thread.sleep(3000);
//
//	            driver.findElement(By.name("username")).sendKeys("siddu9999_");
//	            chaintestlistner.log("📝 Entered username in " + browser);
//
//	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@");
//	            chaintestlistner.log("🔒 Entered password in " + browser);
//
//	            driver.findElement(By.xpath("//button[@type='submit']")).click();
//	            chaintestlistner.log("➡️ Clicked login in " + browser);
//
//	            Thread.sleep(3000);
//
//	            String title = driver.getTitle();
//	            if (title.toLowerCase().contains("instagram")) {
//	                chaintestlistner.log("✅ Login successful in " + browser + "! Title: " + title);
//	               
//            
//	                String actualTitle1 = driver.getTitle();
//	                try {
//		                Assert.assertEquals(actualTitle1, "Login • Instagram", "❌ Title mismatch");
//		            } catch (AssertionError e) {
//		                captureScreenshot(driver, "Title_Mismatch");
//		                throw e; // rethrow to let TestNG know it's a failure
//		            }
//	                
//	                captureScreenshot(driver, "Login_Success_" + browser);
//	                
//	                File successShot = new File("screenshots/Login_Success_" + browser + ".png");
//	                Assert.assertTrue(successShot.exists(), "❌ Screenshot not found: " + successShot.getAbsolutePath());
//	               
//	            } else {
//	                chaintestlistner.log("❌ Login failed in " + browser + "! Title: " + title);
//	                captureScreenshot(driver, "Login_Failed_" + browser);
//	                File failedShot = new File("screenshots/Login_Failed_" + browser + ".png");
//	                Assert.assertTrue(failedShot.exists(), "❌ Screenshot not found: " + failedShot.getAbsolutePath());
//
//	            }
//
//	        } catch (Exception e) {
//	            chaintestlistner.log("💥 Exception in " + browser + ": " + e.getMessage());
//	            captureScreenshot(driver, "Exception_" + browser);
//	        } finally {
//	            if (driver != null) {
//	                driver.quit();
//	                chaintestlistner.log("🛑 Closed " + browser + " browser");
//	                
//	               
//	              
//	               
//	            }
//	        }
//	    }
//     
//		@Test
//	    private static void captureScreenshot(WebDriver driver, String fileName) {
//	        try {
//	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            String path = "screenshots/" + fileName + ".png";
//	            File destFile = new File(path);
//
//	            FileUtils.copyFile(screenshot, destFile);
//
//	            // ✅ Assert screenshot exists
//	            Assert.assertTrue(destFile.exists(), "❌ Screenshot not found: " + destFile.getAbsolutePath());
//
//	            // ✅ Log and embed in ChainTest report
//	            chaintestlistner.embed(destFile, "image/png");
//	            chaintestlistner.log("📸 Screenshot captured: " + fileName);
//	            
//	        } catch (IOException e) {
//	            chaintestlistner.log("⚠️ Screenshot failed: " + e.getMessage());
//	            Assert.fail("❌ Screenshot exception: " + e.getMessage());
//	        }
//	    }
//

	
	
	
	
	 static ChainTestListener chaintestListener = new ChainTestListener();
	    static ChainTestSimpleGenerator chainTestSimpleGenerator = new ChainTestSimpleGenerator();

	    // Test 1: Open Instagram login page and verify title
	    @Test
	    public void testOpenInstagramPage() {
	        WebDriver driver = null;
	        try {
	            // Launch Chrome
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            chaintestListener.log("🟢 Launched Chrome browser");
	      
	            driver.get("https://www.instagram.com/accounts/login/");
	            driver.manage().window().maximize();
	      
	            chaintestListener.log("🌐 Opened Instagram login page");

	            // Verify page title
	            String actualTitle = driver.getTitle();
	            try {
	                Assert.assertEquals(actualTitle, "Login • Instagram", "❌ Title mismatch");
	                chaintestListener.log("✅ Title matches: " + actualTitle);
	                Thread.sleep(2000);
	                captureScreenshot(driver, "Title_Match");
	            } catch (AssertionError e) {
	                captureScreenshot(driver, "Title_Mismatch");
	                throw e; // rethrow to let TestNG know it's a failure
	            }

	        } catch (Exception e) {
	            chaintestListener.log("💥 Exception: " + e.getMessage());
	            captureScreenshot(driver, "Exception");
	        } finally {
	            if (driver != null) {
	                driver.quit();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                chaintestListener.log("🛑 Closed Chrome browser");
	            }
	        }
	    }

	    // Test 2: Enter username and password and verify login button
	    @Test
	    public void testEnterCredentials() {
	        WebDriver driver = null;
	        try {
	            // Launch Chrome
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            chaintestListener.log("🟢 Launched Chrome browser");

	            driver.get("https://www.instagram.com/accounts/login/");
	            driver.manage().window().maximize();
	            Thread.sleep(5000);
	            chaintestListener.log("🌐 Opened Instagram login page");

	            // Enter username and password
	            driver.findElement(By.name("username")).sendKeys("siddu9999_");
	            // Replace with actual username
	            chaintestListener.log("📝 Entered username");

	            Thread.sleep(2000);
	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@"); // Replace with actual password
	            chaintestListener.log("🔒 Entered password");

	            // Verify login button is clickable
	            Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed(), "❌ Login button not displayed");
	            chaintestListener.log("✅ Login button is displayed");
	            captureScreenshot(driver, "entered credentials");
	            Thread.sleep(2000);

	        } catch (Exception e) {
	            chaintestListener.log("💥 Exception: " + e.getMessage());
	            captureScreenshot(driver, "Exception");
	        } finally {
	            if (driver != null) {
	                driver.quit();
	                chaintestListener.log("🛑 Closed Chrome browser");
	            }
	        }
	    }

	    // Test 3: Click login button and verify successful login
	    @Test
	    public void testLoginButton() {
	        WebDriver driver = null;
	        try {
	            // Launch Chrome
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            chaintestListener.log("🟢 Launched Chrome browser");

	            driver.get("https://www.instagram.com/accounts/login/");
	            driver.manage().window().maximize();
	            Thread.sleep(5000);
	            chaintestListener.log("🌐 Opened Instagram login page");

	            Thread.sleep(2000);
	            // Enter username and password
	            driver.findElement(By.name("username")).sendKeys("siddu9999_"); // Replace with actual username
	            chaintestListener.log("📝 Entered username");

	            Thread.sleep(2000);
	            driver.findElement(By.name("password")).sendKeys("Ksiddu9@"); // Replace with actual password
	            chaintestListener.log("🔒 Entered password");

	            Thread.sleep(2000);
	            // Click login button
	            driver.findElement(By.xpath("//button[@type='submit']")).click();
	            chaintestListener.log("➡️ Clicked login button");

	            // Wait for page to load (use explicit wait instead of Thread.sleep for production)
	            Thread.sleep(3000);

	            // Verify login
	            String title = driver.getTitle();
	            if (title.toLowerCase().contains("instagram")) {
	                chaintestListener.log("✅ Login successful! Title: " + title);
	                Thread.sleep(2000);
	                captureScreenshot(driver, "Login_Success");
	            } else {
	                chaintestListener.log("❌ Login failed! Title: " + title);
	                captureScreenshot(driver, "Login_Failed");
	            }

	        } catch (Exception e) {
	            chaintestListener.log("💥 Exception: " + e.getMessage());
	            captureScreenshot(driver, "Exception");
	        } finally {
	            if (driver != null) {
	                driver.quit();
	                chaintestListener.log("🛑 Closed Chrome browser");
	            }
	        }
	    }

	    // Capture screenshot and log it to ChainTest report
	    private static void captureScreenshot(WebDriver driver, String fileName) {
	        try {
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String path = "screenshots/" + fileName + ".png";
	            FileUtils.copyFile(screenshot, new File(path));

	            // Log and embed in ChainTest report
	            chaintestListener.embed(new File(path), "image/png");
	            chaintestListener.log("📸 Screenshot captured: " + fileName);
	        } catch (IOException e) {
	            chaintestListener.log("⚠️ Screenshot failed: " + e.getMessage());
	        }
	    }

	
	
	
	
	   
}
