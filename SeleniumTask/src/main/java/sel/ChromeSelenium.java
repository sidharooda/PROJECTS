package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeSelenium {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.saucedemo.com/v1/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 WebElement usernameField = driver.findElement(By.id("user-name"));
		 usernameField.sendKeys("standard_user");
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 WebElement passwordField = driver.findElement(By.id("password"));
		 passwordField.sendKeys("secret_sauce");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement loginButton = driver.findElement(By.id("login-button"));
		 loginButton.click();
		 System.out.println("Login successful!");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement button = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
		 button.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement button1 = driver.findElement(By.className("shopping_cart_container"));
		 button1.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement button2 = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
		 button2.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement usernameField1 = driver.findElement(By.id("first-name"));
		 usernameField1.sendKeys("SIDDU");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement usernameField2 = driver.findElement(By.id("last-name"));
		 usernameField2.sendKeys("K");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement usernameField3 = driver.findElement(By.id("postal-code"));
		 usernameField3.sendKeys("497383");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement button3 = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
		 button3.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		 WebElement button5= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]"));
		 button5.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 driver.quit();
		 
	}

}
