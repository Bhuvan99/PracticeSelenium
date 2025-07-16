package Data_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\SeleniumData.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		int totalCols = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of Rows: "+ totalRows);
		System.out.println("Number of Cols: "+ totalCols);
		
		for(int r=0;r<=totalRows;r++) {
			XSSFRow  currentRow = sheet.getRow(r);
			for(int c=0;c<totalCols;c++) {
				
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell.toString()+"\t");				
			}
			System.out.println();			
		}
		workBook.close();
		file.close();
		
	}

}
