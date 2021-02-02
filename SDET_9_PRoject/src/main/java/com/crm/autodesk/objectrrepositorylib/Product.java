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
public class Product {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void newProductCreation() throws Throwable
	{
		/*********
		 * /* Common Data */
		int randomNum = jLib.generateRandomNum();
		//String USERNAME = flib.getPropertyKeyValue("username");
		//String PASSWORD = flib.getPropertyKeyValue("password");
		//String URL = flib.getPropertyKeyValue("url");
		//String BROWSER = flib.getPropertyKeyValue("browser");
		
	
		 
		
		
		
		
		/* step 1 : login to APP */
		WebDriver driver = null;
		//if(BROWSER.equalsIgnoreCase("firefox")) {
		// driver= new FirefoxDriver();  
		//}else if(BROWSER.equalsIgnoreCase("chrome")) {
		//	 driver = new ChromeDriver();
		//}else if(BROWSER.equalsIgnoreCase("ie")) {
		// driver = new InternetExplorerDriver();
		//}
		
		//	wLib.waitForHTMLDOM(driver);
		//driver.get(URL);
		
			/* step 1 : login to APP */
		//Login lp = new Login(driver);
		//      lp.loginToApp(USERNAME, PASSWORD);
		//      wLib.windowMax(driver);
		        
		        
		    	/* test Data */
				String pname=eLib.getExcelData("Product", "123", "proname")+randomNum;
				String unitPrice=eLib.getExcelData("Product", "123", "prounitPrice1")+randomNum;
				String commisionPrice=eLib.getExcelData("Product", "123","procommissionrate");
				String inStock1=eLib.getExcelData("Product", "123", "proinStock1");
				String quantityPerUnit1=eLib.getExcelData("Product", "123", "proquantityPerUnit1");
				String reOrderLevel1=eLib.getExcelData("Product", "123", "proreOrderLevel1");
				String quantityInDemand1=eLib.getExcelData("Product", "123", "proquantityInDemand1");
		        /*click on product*/
		        ProductInfo prod=new ProductInfo(driver);
		        /*click on productLink*/
		        prod.ClickOnProductLnk();
		        /*click on product Icon*/
		        prod.ClickOnProductIcon();
		        
		        prod.productDetails1(pname,unitPrice,commisionPrice);
		        prod.selectCheckBox();
		        prod.productDetails2(inStock1,quantityPerUnit1,reOrderLevel1, quantityInDemand1);
		        
		        /*verify product information title*/
		        String actSuccessfullMsg = prod.getSuccessFullMsg().getText();
			    Assert.assertTrue(actSuccessfullMsg.contains(pname));		
			    
			    
			    
		        
	}

							



		
}
