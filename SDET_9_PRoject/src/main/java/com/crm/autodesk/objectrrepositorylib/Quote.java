package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author shashi
 *
 */
public class Quote extends WebDriverUtiles {
	WebDriver driver;
	
public Quote(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@title=\"Create Quote...\"]")
private WebElement createQuotes;

@FindBy(name="search_field")
private WebElement inDropDown;

@FindBy(name="search_text")
private WebElement searchEdt;


public WebElement getCreateQuote()
{
	return createQuotes;
}

public WebElement getInDropDown() {
	return inDropDown;
}

public WebElement getSearchEdt() {
	return searchEdt;
}
}
