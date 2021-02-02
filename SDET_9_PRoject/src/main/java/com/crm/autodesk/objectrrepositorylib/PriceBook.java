package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * 
 * @author Shashi
 *
 */
public class PriceBook {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	

	@Test
	public void createContactWitORgTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		/*Test Data*/
		String pBookName=eLib.getExcelData("BookPrice","PB1","PriceBookName")+"PB";
		
		/* step 1 : login to APP */
		WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
		    driver= new FirefoxDriver();  
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);
		
		/* step 1 : login to APP */
		  Login lp = new Login(driver);
		  lp.loginToApp(USERNAME, PASSWORD);
		  wLib.windowMax(driver);
		
		PriceBookInfo priceInfo=new PriceBookInfo(driver);
		priceInfo.clickMoreLnk();
		priceInfo.clickOnPriceBook();
		priceInfo.clickPriceBookInformation();
		priceInfo.clickOnPriceBookName(pBookName);
		priceInfo.clickOnSaveButn();
		
		/*to verify*/
		String verifyMsg=priceInfo.verify().getText();
		Assert.assertTrue(verifyMsg.contains(pBookName));
		
	}
}
