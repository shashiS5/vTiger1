package com.crm.autodesk.objectrrepositorylib;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class PriceBookInfo {

		public PriceBookInfo(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//a[text()='More']")
		private WebElement moreLnk;
		
		@FindBy(name="Price Books")
		private WebElement priceBook;
		
		@FindBy(xpath="//img[@title='Create Price Book...']")
		private WebElement  priceLnk;
		
		@FindBy(xpath="//input[@name='bookname']")
		private WebElement priceBookName;
		
		@FindBy(xpath="//span[@Class='lvtHeaderText']")
		private WebElement verifyHeader;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButn;
		
		public void clickMoreLnk()
		{
			moreLnk.click();
		}
		public void clickOnPriceBook() {
			priceBook.click();	
		}
		public void clickPriceBookInformation() {
			priceLnk.click();	
		}
		public void clickOnPriceBookName(String pBookName) {
			priceBookName.sendKeys(pBookName);
		}
		public WebElement verify() {
			return verifyHeader;
		}
		public void clickOnSaveButn() {
			saveButn.click();
		}
	}


