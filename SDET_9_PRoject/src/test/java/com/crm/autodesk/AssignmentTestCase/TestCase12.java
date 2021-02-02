package com.crm.autodesk.AssignmentTestCase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.InvoiceInfo;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;
import com.crm.autodesk.objectrrepositorylib.PriceBookInfo;
import com.crm.autodesk.objectrrepositorylib.ProductInfo;
@Listeners(com.crm.autodesk.genericlib.ListenerIMP.class)
public class TestCase12 extends BaseClass{
		@Test(groups = "regressionTest")
		public void invoice_1() throws Throwable {
		Home hp=new Home(driver);
		int randomNum = jLib.generateRandomNum();
		
		/*test Data*/
		String orgName = eLib.getExcelData("Contact", "tc_01", "OrgName")+ randomNum;
		String orgType = eLib.getExcelData("Contact", "tc_01", "orgType");
		String orgIndustry = eLib.getExcelData("Contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("Contact", "tc_01", "rating");

		String pname=eLib.getExcelData("Product", "123", "proname")+randomNum;
		String unitPrice=eLib.getExcelData("Product", "123", "prounitPrice1")+randomNum;
		String commisionPrice=eLib.getExcelData("Product", "123","procommissionrate");
		String inStock1=eLib.getExcelData("Product", "123", "proinStock1");
		String quantityPerUnit1=eLib.getExcelData("Product", "123", "proquantityPerUnit1");
		String reOrderLevel1=eLib.getExcelData("Product", "123", "proreOrderLevel1");
		String quantityInDemand1=eLib.getExcelData("Product", "123", "proquantityInDemand1");

		String pBookName=eLib.getExcelData("BookPrice","PB1","PriceBookName")+"PB";

		String Iname=eLib.getExcelData("Invoice","I0_1","InvoiceName")+"I";
		//String orgName=eLib.getExcelData("Invoice","I0_1","OrgName");
		String quantity=eLib.getExcelData("Invoice","I0_1","IQuantity");
		String bAddress=eLib.getExcelData("Invoice","I0_1","IAddress");
		String shipingHandling=eLib.getExcelData("Invoice","I0_1","IShipping");
		
		/* precondition create  Organization \ */
  
        hp.getOrgLnk().click();
        
        /*  navigate to create Org Page */
		   Organizations orgPage = new Organizations(driver);
		        orgPage.getCreateOrgImg().click();

        
        /*create new Organization with industry & type, rating */
	    CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
	    createOrgPage.creatOrganization(orgName, orgIndustry, orgType, orgRating);
	    
	  /*verify */
	    OrganizationInfo info = new OrganizationInfo(driver);
	    String actSuccessfullMsg1 = info.getSuccessFullMsg().getText();
	    Assert.assertTrue(actSuccessfullMsg1.contains(orgName));  
	    
	    /*precondition create  product \ */
        ProductInfo prod=new ProductInfo(driver);
        prod.ClickOnProductLnk();
        prod.ClickOnProductIcon();
        
        prod.productDetails1(pname,unitPrice,commisionPrice);
        prod.selectCheckBox();
        prod.productDetails2(inStock1,quantityPerUnit1,reOrderLevel1, quantityInDemand1);
        
        /*verify product information title*/
        String actSuccessfullMsg2 = prod.getSuccessFullMsg().getText();
        Assert.assertTrue(actSuccessfullMsg2.contains(pname));	
		
	    
	    /* precondition create  priceBook \ */
        
	    PriceBookInfo priceInfo=new PriceBookInfo(driver);
		priceInfo.clickMoreLnk();
		priceInfo.clickOnPriceBook();
		priceInfo.clickPriceBookInformation();
		priceInfo.clickOnPriceBookName(pBookName);
		priceInfo.clickOnSaveButn();
		
		/*to verify*/
		String verifyMsg3=priceInfo.verify().getText();
		Assert.assertTrue(verifyMsg3.contains(pBookName));
		
		 /* step 2 :Invoice  module \ */
		InvoiceInfo in=new InvoiceInfo(driver);
		in.clickMoreLnk();
		in.clickInvoiceLink();
		in.ClickOnInvoiceIcon();
		in.orgLookUp(Iname, orgName);
		
		/*status as created*/
		in.statusCreated();
		in.clickBillAddress(bAddress);
		in.clickOnBillRadioBtn();
		in.clickOnProductLooKUp(pname);
		in.enterQuantity(quantity);
		in.shippingCharges(shipingHandling);
		in.clickOnSaveButn();
		
		/*to verify*/
		String verifyMsg4=priceInfo.verify().getText();
		Assert.assertTrue(verifyMsg4.contains(Iname));
        }
		 
   }





