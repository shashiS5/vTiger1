package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

/*
 * @author shashi
 */
public class CreateNewQuote extends WebDriverUtiles{
WebDriver driver;
public CreateNewQuote(WebDriver driver) { 
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="subject")
private WebElement subject;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(xpath="//input[@name='contact_name']/following-sibling::img")
private WebElement clickOnContactLookupImage;

public void createContact(String sub) {
	subject.sendKeys(sub);
	saveBtn.click();
}
public void clickOnContactLookup(String quoteSubject,String serachDropOtp,String lastName)
{
		waitforElementToBeClickable(driver, subject);
		subject.sendKeys(quoteSubject);
		clickOnContactLookupImage.click();
		//swicth to Child
		swicthToWindow(driver, "Accounts&action");
		Contacts contactPage = new Contacts(driver);
		select(contactPage.getInDropDown(),serachDropOtp);
		contactPage.getSearchEdt().sendKeys(lastName);
		contactPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		//swict to Parent
		swicthToWindow(driver, "Quotes");
		saveBtn.click();
	}
public  void clickOnContactLookup(String quoteSubject , String lastName ) {
	waitforElementToBeClickable(driver, subject);
	subject.sendKeys(quoteSubject);
	//swicth to Child
	swicthToWindow(driver, "Accounts&action");
	Contacts contactPage = new Contacts(driver);
	
	contactPage.getSearchEdt().sendKeys(lastName);
	contactPage.getSearchNow().click();
	driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
	//switch to Parent
	swicthToWindow(driver, "Quotes");
	saveBtn.click();
}

}
