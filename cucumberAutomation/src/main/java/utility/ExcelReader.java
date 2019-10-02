package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
XSSFWorkbook wb=null;
XSSFSheet sh;
public ExcelReader(String excelPath) 
{
	try{
		File src=new File(excelPath);
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
public static int getRowCount(String path,String sheet,String data)
{
	FileInputStream stream;
	int rowcount=0;
	boolean found=false;
	try{
		stream=new FileInputStream(path);
		XSSFWorkbook book=new XSSFWorkbook(stream);
		XSSFSheet shet=book.getSheet(sheet);
		Iterator<Row> iterator=shet.iterator();
		while(true){
			if(iterator.hasNext())
		{
			XSSFRow row=shet.getRow(rowcount);
			XSSFCell cell=row.getCell(0);
			String value=cell.getStringCellValue();
			if(value.contains(data))
			{
				found=true;
				break;
			}
			iterator.next();
			rowcount++;
			}else{
				rowcount=0;
				break;
			}
		}
		if(!found){
			iterator=shet.iterator();
		}
		while(!found){
			if(iterator.hasNext()){
				rowcount++;
				iterator.next();
			}else{
				break;
			}
		}
	}catch(IOException e){
		e.printStackTrace();
	}
	return rowcount++;
}
public HashMap<String,String> fetchData(String sheetName)
{
	String key="";
	String value="";
	HashMap<String,String> lst=new HashMap<String, String>();
	sh=wb.getSheet(sheetName);
	int row=wb.getSheet(sheetName).getLastRowNum();
	int cell=sh.getRow(0).getPhysicalNumberOfCells();
	for(int i=0;i<=row;i++)
	{
		for(int j=0;j<=cell;j++)
		{
			DataFormatter fmt=new DataFormatter();
			if(j==0){
			key=fmt.formatCellValue(sh.getRow(i).getCell(j));
			}else{
				value=fmt.formatCellValue(sh.getRow(i).getCell(j));
			}
			
		}
		lst.put(key, value);
		
	}
	return lst;
	
}
}
