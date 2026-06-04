package com.cts.urbanladder.util;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
public class ExcelUtil {
	 
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static CellStyle style;  
		
		public static int getRowCount(String xlfile,String xlsheet) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			int rowcount=ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;		
		}
		
	 
		public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			int cellcount=row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
		
		public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.getCell(colnum);
		
			String data;
			try
			{
				DataFormatter formatter = new DataFormatter();
	            data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
	       	}
			catch (Exception e)
			{
				data="";
			}
			
			wb.close();
			fi.close();
			return data;
		}
		
		
	 
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
		{
			fo=new FileOutputStream(xlfile);
			wb=new XSSFWorkbook();
			ws=wb.createSheet(xlsheet);
			row=ws.createRow(rownum);
			
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			
			wb.write(fo);		
			wb.close();
			//fi.close();
			fo.close();
					
		}
		
}


