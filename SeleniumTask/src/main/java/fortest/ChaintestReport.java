package fortest;


import org.testng.TestNG;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners
public class ChaintestReport {
	
	   public static void main(String[] args) {
		
		   System.setProperty("chaintest.config.file", "src/main/resources/application.properties");

			  TestNG testng = new TestNG();
		        testng.setTestClasses(new Class[] { Logintest.class });
		        testng.addListener(new ChainTestListener());
		        testng.run();
		       
		   
	}
	

}
