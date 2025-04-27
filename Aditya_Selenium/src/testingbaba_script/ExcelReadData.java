package testingbaba_script;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData
{

	
	public String getReaddata(String path,int sheetno, int colno,int rowno)
	{
		String value="";
		try 
		{
		FileInputStream fis=new FileInputStream(path);
			 XSSFWorkbook wb = new  XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(sheetno);
				value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
			
		} catch (Exception e) 
		{
			System.out.println("issue in Get read_data "+e);
		}
		return value;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		ExcelReadData ob = new ExcelReadData();
		String path="D:\\JavaWorkspace\\24_dec_newJavaBatch_8Pm_ashwani\\testdata\\testdata_excel.xlsx";
		for(int i=0;i<=10;i++)
		{
		
		String data = ob.getReaddata(path, 0, 0, i);
		
		String data1 = ob.getReaddata(path, 0, 1, i);
		System.out.println(data+"    "+data1);
		
		
		
		}
	}
}
