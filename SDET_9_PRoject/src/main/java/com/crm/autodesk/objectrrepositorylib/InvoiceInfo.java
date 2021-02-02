package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class InvoiceInfo extends WebDriverUtiles{
	
	WebDriver driver;
	public InvoiceInfo(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLnk;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButn;
	
	@FindBy(name="Invoice")
	private WebElement invoiceLnk;
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement invoiceIcon;
	
	@FindBy(name="subject")
	private WebElement invoiceSubject;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookUp;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
		
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
    
    @FindBy(xpath="//textarea[@name='bill_street']")
    private WebElement billaddress;
    
    @FindBy(xpath="//b[contains(text(),'Billing address')]/..//input")
    private WebElement BillRadioBtn;
    
    @FindBy(xpath="//img[@title='Products']")
    private WebElement productLookUp;
    
    @FindBy(id="qty1")
    private WebElement qty;
    
    @FindBy(name="invoicestatus")
    private WebElement statusList;
    
    public void enterQuantity(String quantity) {
    	qty.sendKeys(quantity);
    }
    
     public void clickBillAddress(String bAddress) {
    	billaddress.sendKeys(bAddress);
    }
     @FindBy(name="search_text")
 	private WebElement searchEdt;
     
     @FindBy(name="search")
 	 private WebElement searchNow;
     
     @FindBy(id="shipping_handling_charge")
     private WebElement shipping;
   
    public void clickOnBillRadioBtn() {
    	BillRadioBtn.click();
    }
    public void shippingCharges(String shipscharges) {
    	shipping.clear();
    	shipping.sendKeys(shipscharges);
    }
   
	public  void orgLookUp(String Iname , String orgName ) throws Throwable {
		waitforElementToBeClickable(driver, invoiceSubject);
		invoiceSubject.sendKeys(Iname);
		orgLookUp.click();
		//swicth to Child
		swicthToWindow(driver, "Accounts&action");
		Organizations orgPage = new Organizations(driver);
		//select(orgPage.getInDropDown(),serachDropOtp);
		orgPage.getSearchEdt().sendKeys(orgName);
		orgPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		alertOK(driver);
		//switch to Parent
		swicthToWindow(driver, "Invoice");
		
	}
	 public void clickOnProductLooKUp(String pname) {
			
			productLookUp.click();
			//swicth to Child
			swicthToWindow(driver, "Products&action");
			ProductInfo pPage = new ProductInfo(driver);
			//
			pPage.getSearchEdt().sendKeys(pname);
			pPage.getSearchNow().click();
			driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
			//Switch to Parent
			swicthToWindow(driver,"Invoice");
	 }
	public void clickMoreLnk()
	{
		moreLnk.click();
	}
	public void clickInvoiceLink() {
		invoiceLnk.click();
	}
	public void ClickOnInvoiceIcon(){
		invoiceIcon.click();
	}	
	public void clickOnSaveButn() {
		saveButn.click();
	}
	public void statusCreated() {
		select(statusList, "Created");
	}
	public void statusApproved() {
		select(statusList, "Approved");
	}
	public void statusSent() {
		select(statusList, "Sent");
	}
	public void statusCreditInvoice() {
		select(statusList, "Credit Invoice");
	}
	public void statusPaid(){
		select(statusList, "Paid");
	}
	
	
}


