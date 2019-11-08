package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	//Writing reusable excel utility methods to read data from excel
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xfile, String xsheet) throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount(String xfile, String xsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xfile, String xsheet, int rownum, int colnum)throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		}
		catch (Exception e)
		{
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xfile, String xsheet, int rownum, int colnum, String data)throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xfile);
		wb.write(fo);
		wb.close();
		fi.close();
			}
}
