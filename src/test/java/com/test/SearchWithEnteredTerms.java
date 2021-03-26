package com.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import utilities.OS_BrowserFactory;




public class SearchWithEnteredTerms {
	Search_Page objSearchPage;
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		String baseUrl = "https://www.google.com";
		OS_BrowserFactory osBrowserObj = new OS_BrowserFactory();
		driver = osBrowserObj.OsBrowser(browser);
		objSearchPage = new Search_Page(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void clearSearch() {
		objSearchPage.clearSearchData();
	}
	
	 // User enters some text and hits enter
	@Test
	  public void searchWithEnteredData() throws InterruptedException {
		objSearchPage.verifySearchFields();
		objSearchPage.search("selenium");
		Thread.sleep(1000);
		objSearchPage.clickSearch();
		Thread.sleep(1000);
		objSearchPage.verifySearchResult("selenium");
	}
	
	 
	
	
	//user selects some test then verify dynamic search options
	@Test
	public void searchdynamicOptions() throws InterruptedException {
		objSearchPage.search("selenium");
		Thread.sleep(1000);
		objSearchPage.verifyDynamicSearchOptions("selenium");
		objSearchPage.verifySearchResult("selenium");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
