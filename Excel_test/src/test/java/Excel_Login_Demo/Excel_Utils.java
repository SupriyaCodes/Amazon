package Excel_Login_Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileOutputStream;


	import org.apache.poi.xssf.usermodel.XSSFCell;

	import org.apache.poi.xssf.usermodel.XSSFRow;

	import org.apache.poi.xssf.usermodel.XSSFSheet;

	

	public class Excel_Utils {

		private static XSSFSheet ExcelWSheet;

		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;


	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

	{   

	   String[][] tabArray = null;

	   try{

		   FileInputStream ExcelFile = new FileInputStream(FilePath);

		   // Access the required test data sheet

		   ExcelWBook = new XSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(SheetName);

		   int startCol = 1;
		   int StartRow=1;

		   int ci=0,cj=0;

		   
		   int totalRows = 5;

		   int totalCols = 3;

		   tabArray=new String[totalRows][totalCols];
		   for(int k=StartRow;ci<totalRows;ci++,k++)
		   {
                cj=0;
			   for (int j=startCol;j<=totalCols;j++, cj++)

			   {

				   tabArray[ci][cj]=getCellData(k,j);

				   System.out.println(tabArray[ci][cj]);

		   }

		}}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{

	   try{

		  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		  String CellData = Cell.getStringCellValue();

		  return CellData;

		  }catch (Exception e){

			return"";

			}

		}


		

	

	}

