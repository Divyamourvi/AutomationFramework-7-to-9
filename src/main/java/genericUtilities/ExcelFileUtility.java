package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to read the from from excel
 * @author Vinay G
 *
 */
public class ExcelFileUtility {
	
	
	public String readDataFromExcelFile(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		
	FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	String value= wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	return value;
	
}
	
	/**
	 * This method will write data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataFromExcelFile(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);

		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();

	}	
	
	/**
	 * This method will read multiple data from excel and has to given to data provider
	 * @param sheetname
	 * @return 
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleData(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		 int lastRowNum = sh.getLastRowNum();
		int lastCellNum=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRowNum][lastCellNum];
		
		for(int i=0;i<lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}