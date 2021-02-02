package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfo {
	public ProductInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement newProductIcon;
	
	@FindBy(name="productname")
	private WebElement pname1;
	
	@FindBy(id="unit_price")
	private WebElement unitPrice1;
	
	@FindBy(name="commissionrate")
	private WebElement commisionPrice1;
	
	@FindBy(name="tax1_check")
	private WebElement vatCheckbox;
	
	@FindBy(id="tax1")
	private WebElement vat;

	@FindBy(name="tax2_check")
	private WebElement salesCheckBox;
	
	@FindBy(id="tax2")
	private WebElement sales;
	
	@FindBy(name="tax3_check")
	private WebElement  serviceCheckBox;
	
	@FindBy(id="tax3")
	private WebElement service;
	
	
	@FindBy(name="qtyinstock")
	private WebElement inStock;
	
	@FindBy(name="qty_per_unit")
	private WebElement quantityPerUnit;
	
	@FindBy(name="reorderlevel")
	private WebElement reOrderLevel;
	
	@FindBy(name="qtyindemand")
	private WebElement quantityInDemand;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successFullMsg;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchNow;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSuccessFullMsg() {
		return successFullMsg;
	}
	public void ClickOnProductLnk()
	{
			productLnk.click();
	}
	
	public void ClickOnProductIcon()
	{
			newProductIcon.click();
	}
	
	
	public void selectCheckBox() {
		vatCheckbox.click();
		salesCheckBox.click();
		serviceCheckBox.click();
			
	}
	public void getProductName(String pname) {
		pname1.sendKeys(pname);
	}
	public void productDetails1(String pname,String unitPrice,String commisionPrice)
	{
		pname1.sendKeys(pname);
		unitPrice1.clear();
		unitPrice1.sendKeys(unitPrice);
		commisionPrice1.sendKeys(commisionPrice);
	}
		
	public void productDetails2(String inStock1,String quantityPerUnit1,String reOrderLevel1,String quantityInDemand1)
	{
		inStock.sendKeys(inStock1);
		quantityPerUnit.sendKeys(quantityPerUnit1);
		reOrderLevel.sendKeys(reOrderLevel1);
		quantityInDemand.sendKeys(quantityInDemand1);
		saveBtn.click();
	}
	public WebElement getInDropDown() {
		return inDropDown;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}






	public WebElement getSearchNow() {
		return searchNow;
	}

	
	
	
	
	
	
	
	
	
}
