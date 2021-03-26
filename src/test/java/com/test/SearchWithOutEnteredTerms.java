package com.test;

import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.testng.Arquillian;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.Search_Page;

import utilities.OS_BrowserFactory;
import utilities.SpeakUtil;



public class SearchWithOutEnteredTerms extends Arquillian{
	 WebDriver driver;
	
	
	Search_Page objSearchPage;
	
    @BeforeClass
    public void setup(){
    	SpeakUtil.allocate();
    }
    
    //
		    
    @Test(dataProvider = "voiceSearch")
    public void googleVoiceSearchTest(String searchText, String browser) throws Exception {
		
		OS_BrowserFactory osBrowserObj = new OS_BrowserFactory();
		driver = osBrowserObj.OsBrowser(browser);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://www.google.com"); 	
		objSearchPage = new Search_Page(driver);
       	WebElement element= objSearchPage.getSearchButton();
       	element.click();
    	element.sendKeys(Keys.TAB, Keys.ENTER);
    	Thread.sleep(1000);
    	SpeakUtil.speak(searchText);
    	Thread.sleep(10000);
    	objSearchPage.verifySearchResult(searchText);
  
    }
    
    @DataProvider(name = "voiceSearch")
    public static Object[][] voiceSearchTestData() {
       return new Object[][] {
    		   {"openclinica", "chrome"}
       };
    }
    
    @AfterClass
    public void deallocate(){
    	SpeakUtil.deallocate();
    	driver.quit();
    }
    
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
