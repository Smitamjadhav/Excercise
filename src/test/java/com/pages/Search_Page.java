package com.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Search_Page {
	
	WebDriver driver ;
	
	public Search_Page(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	
	@FindBy(name="q")
	WebElement searchbox; 
	
	@FindBy(name="btnK")
	WebElement searchButton; 
	

	@FindBy(xpath="//h1[contains(text(),'Search Results')]//following::a[1]")
	List<WebElement> searchResult;
	
	@FindBy(xpath="//ul[@role='listbox']//li/descendant::div[@class='sbtc']")
	List<WebElement> dynamicSearchOptions;
	
	public WebElement getSearchButton(){
		return searchbox;
	}
	 
	public void verifySearchFields(){
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");	
		
		if(this.searchbox!= null){
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		if(this.searchButton!= null){
			Assert.assertTrue(true);
			}else{
				Assert.assertTrue(false);
			}

    }
    public void search(String searchTerm){
    	searchbox.sendKeys(searchTerm);
       
    }
    
    public void clickSearch() {
    	searchButton.click();
    }
    
    public void clearSearchData() {
    	searchbox.clear();
    }
    
    public void verifySearchResult(String searchTerm){
  	    // To check search result
   	    List<WebElement> results = searchResult;
  	    String actual = results.get(0).getText().toLowerCase();
  	    System.out.println("seached term "+ searchTerm);
  	   System.out.println("result "+ actual);
  	    Assert.assertTrue(actual.contains(searchTerm), "Search result validation failed at instance [ + i + ].");
    }
    
    
    public void verifyDynamicSearchOptions(String searchTerm){
    	List<WebElement> results = dynamicSearchOptions;
    		
    	for(int i=0; i<results.size();i++){
    		String actual = results.get(i).getText();
       		Assert.assertTrue(actual.contains(searchTerm), "Search result validation failed at instance [ + i + ].");	
    	}
    	//clicking on one of the element
    	for(int i=0; i<results.size();i++){
        	if(results.get(i).getText().contains(searchTerm)){
    		results.get(i).click();
    		break;
    	}
    }
    	
    
    }

}
