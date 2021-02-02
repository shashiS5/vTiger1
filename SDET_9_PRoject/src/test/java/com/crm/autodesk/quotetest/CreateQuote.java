package com.crm.autodesk.quotetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewConatct;

import com.crm.autodesk.objectrrepositorylib.CreateNewQuote;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;

import com.crm.autodesk.objectrrepositorylib.Quote;

/*
 * @author shashi
 * 
 */
public class CreateQuote {
	JavaUtils jLib = new JavaUtils();
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	WebDriverUtiles wLib=new WebDriverUtiles();
	
	@Test
	public void createQuote() throws Throwable {
		
		/*create common data*/
		int randomNum=jLib.generateRandomNum();
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String URL=fLib.getPropertyKeyValue("url");
		String BROWSER=fLib.getPropertyKeyValue("browser");
		
		/*test data*/
		String orgName=eLib.getExcelData("Contact","tc_03","orgName")+randomNum;
		String quoteSubject=eLib.getExcelData("Contact","tc_03", "quoteSubjectName");
		String lastName = eLib.getExcelData("Contact","tc_03", "quoteLastName")+ randomNum;
		String orgType=eLib.getExcelData("contact","tc_01","orgType");
		String orgIndustry=eLib.getExcelData("contact","tc_01","orgType");
		String orgRating=eLib.getExcelData("contact","tc_01","rating");
		String contactName=eLib.getExcelData("contact","tc_01","contactName")+randomNum;
		//String oppName=eLib.getExcelData("Contact","tc_01", "oppName");
		

		
		/*Login to Application*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);

		/* step 1 : login to APP */
		  		Login lp = new Login(driver);
		        lp.loginToApp(USERNAME, PASSWORD);
		        
		        /*organization module*/
		        Home hp = new Home(driver);
		        hp.getOrgLnk().click();
		        
		     /*contact module*/
		         hp.getContactLnk().click();
		        
		        
		 			 
		         /*click on More button*/
				hp.moreLnk().click();
		    
				/*click on Quotes link*/
				 hp.quotesLnk().click();
		 
				 /*click on new create Quotes*/
				 Quote qt=new Quote(driver);
				 qt.getCreateQuote().click();
		 
				/*click on contactlookUp */
				 CreateNewQuote newQuote=new CreateNewQuote(driver);
				 newQuote.clickOnContactLookup(quoteSubject, lastName);
				 
				 /* step 7 : creat new Contact with Org */
		            CreateNewConatct cnc = new CreateNewConatct(driver);
		            cnc.createConatct(orgName);
			 
				 /* step 8 : verify */
				 
				 /* step 9 : logout & close */
		            hp.logout();
		            driver.close();
		 
		 	}

}
