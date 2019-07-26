package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ConnectExcel {

	public Workbook getWorkBook(String sFilePath,String sFileName) throws IOException
	{
		//create an object of filepath
		File file = new File(sFilePath + "\\" + sFileName);
		//create an object from fileinputstream class to read file
		FileInputStream fis = new FileInputStream(file);
		Workbook wbk = null;
		//find the file extension by splitting the file name in substring and getting only extension.
		String sFileExtension = sFileName.substring(sFileName.indexOf("."));
		if(sFileExtension == ".xslx") 
		{
			wbk = new XSSFWorkbook(fis);
			
		}
		if(sFileExtension == ".xls")
		{
			wbk = new HSSFWorkbook(fis);
		}
		
		return wbk;
	}
	public void readSheet(Workbook wbk,String sSheetName) throws IOException
	{
		//Read Sheet inside the workbook by its name
		Sheet sheet = wbk.getSheet(sSheetName);
		//find number of rows in the sheet
		int iRow = sheet.getLastRowNum();
		
		for(int i=0;i<iRow;i++)
		{
			
		}		
	}
}
