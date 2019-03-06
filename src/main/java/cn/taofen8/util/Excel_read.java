package cn.taofen8.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_read {
	private static final String EXCEL_XLS = "XLS";
	private static final String EXCEL_XLSX = "xlsx";
	
	private static XSSFWorkbook excelWBook;  //Excel工作簿
	private static XSSFSheet excelWSheet;    //工作表
	private static XSSFRow row;              //行
	private static XSSFCell cell;            //列
	
	@Test
	public void test(){
		//test("使用淘宝账号快速登录");
	}
	
/*	public static Set test(String text){ */
	public static String test(String text,int id){ 
		Set<String> set = new HashSet<String>();
		String t1, t2 = null;
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"apps");
		//File app = new File(appDir,"tf8_5.1.0.xlsx");
		File app = new File(appDir,"tf8_8.1.0.xlsx");
		
		/*String text = "版本升级弹窗";*/
		
		try {
			
			FileInputStream ecxelFile = new FileInputStream(app);
			
			excelWBook = new XSSFWorkbook(ecxelFile);
			excelWSheet = excelWBook.getSheetAt(id);

			for(int i=1; i<excelWSheet.getPhysicalNumberOfRows(); i++){
/*				System.out.println(getValue(excelWSheet.getRow(i).getCell(4)));
				System.out.println(text);*/
				try{
					if(text.equals(getValue(excelWSheet.getRow(i).getCell(5)))){
						/*t1 = getValue(excelWSheet.getRow(i).getCell(6));*/
						t2 = getValue(excelWSheet.getRow(i).getCell(7));
						//System.out.println("t2: "+t2);
						/*set.add(t2);*/
						break;
					}
				}catch(NullPointerException e){
					e.printStackTrace();
					System.out.println("文档有空行，请删除");
				}

			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t2;
	}
	
	private static String getValue(XSSFCell xssfCell){
		if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){
			return String.valueOf(xssfCell.getBooleanCellValue());
		}else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){
			return String.valueOf(xssfCell.getNumericCellValue());
		}else{
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}
}

/*		cell = excelWSheet.getRow(rowNum).getCell(cellNum);
String cellData = "";

if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
	cellData = cell.getStringCellValue();
}else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
	DecimalFormat df = new DecimalFormat("0");
	cellData = df.format(cell.getNumericCellValue());
}

System.out.println(cellData);
System.out.println(excelWSheet.getPhysicalNumberOfRows());*/
