package com.project.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataprovider {


	public static Object[][] getdata() throws IOException
	{

		//System.out.println("Hii");
		FileInputStream fis = new FileInputStream("C:\\Users\\madhu\\OneDrive\\Desktop\\RealProject\\Aid\\Data Driven\\Exceldata.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);

		int sc = book.getNumberOfSheets();

		XSSFSheet sheet= book.getSheet("Sauce");
		//XSSFSheet sheet= book.getSheetAt(3);

		int rw = sheet.getLastRowNum();
		System.out.println(rw);

		XSSFRow r1 = sheet.getRow(0);

		int cell = r1.getLastCellNum();
		System.out.println(cell);

		Object[][]  data =  new Object [rw][cell];

		DataFormatter dat = new DataFormatter();

		for(int i=0; i<rw; i++)
		{
			XSSFRow rows =  sheet.getRow(i+1);

			for(int j=0 ; j<cell; j++)
			{
				XSSFCell c = rows.getCell(j);

				data[i][j] = dat.formatCellValue(c);
				//System.out.println("HELLO "+data[i][j]);
			}
		}


		return data;



	}

	public static void main(String[] args) throws IOException {
		
	}	//getdata();	}

}
