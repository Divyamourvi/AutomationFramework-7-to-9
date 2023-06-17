package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WriteDataIntoExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
				//Step 1:Open the file in java readable format
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx.xlsx");

				//Step 2:Create a Workbook factory
				Workbook wb = WorkbookFactory.create(fis);

				//Step 3:get the control of sheet
				 Sheet sh = wb.getSheet("Organization");

				//Step 4:get the control of row
				   Row rw = sh.createRow(5);

				//Step 5:get the control of cell
				Cell cl = rw.createCell(8);
				
				//Step 6:set the cell value
				cl.setCellValue("divya");
				
				//Step 7:OPen the file in java write format
				FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx.xlsx");
				
				//Step 8:Write the data into file
				wb.write(fos);
				System.out.println("data written");
				wb.close();
			}
}
