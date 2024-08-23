package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class Excel_Utilities {

public static FileInputStream f;	

public static XSSFWorkbook w; 

public static XSSFSheet s;

public static String getStringData(int a,int b,String sheet) throws IOException{
	//int a and b for rep rows and coloums in excel
	String filepath=Constants.TESTDATAFILE;
	f=new FileInputStream(filepath);
	w= new XSSFWorkbook(f);
	s=w.getSheet(sheet);
	
	XSSFRow t= s.getRow(a);
	XSSFCell h=t.getCell(b);
	return h.getStringCellValue();	
	
}

/*public static String getIntegerData(int a,int b,String sheet) throws IOException{
	//int a and b for rep rows and coloums in excel
	f=new FileInputStream("‪C:\\Users\\Manu Das M\\Documents\\manudas.xlsx");
	w= new XSSFWorkbook(f);
	s=w.getSheet(sheet);
	XSSFRow t= s.getRow(a);    
	XSSFCell h= t.getCell(b);
	int p= (int) h.getNumericCellValue();
	return String.valueOf(p);
}*/
public static String getIntegerData(int a,int b,String sheet) throws IOException{
	//int a and b for rep rows and coloums in excel
	String filepath=Constants.TESTDATAFILE;
	f=new FileInputStream(filepath);
	w= new XSSFWorkbook(f);
	s=w.getSheet(sheet);
	XSSFRow t= s.getRow(a);    
	XSSFCell h= t.getCell(b);
	int p= (int) h.getNumericCellValue();
	return String.valueOf(p);
}
}
