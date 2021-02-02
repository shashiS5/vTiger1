package com.pratice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class p1 {
@Test
public void excel1() throws EncryptedDocumentException, IOException
{
	FileInputStream  fs=new FileInputStream("./testData/TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fs);
	Sheet s=wb.getSheet("Contact");
	Row r=s.getRow(0);
	Cell c=r.getCell(0);
	String username=c.getStringCellValue();
	System.out.println(username);
}
}
