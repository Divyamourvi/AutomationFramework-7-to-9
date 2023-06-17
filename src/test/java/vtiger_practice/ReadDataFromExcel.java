package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {

		//Step 1:Open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx.xlsx");

		//Step 2:Create a Workbook factory
		Workbook wb = WorkbookFactory.create(fis);

		//Step 3:get the control of sheet
		Sheet sh = wb.getSheet("Organization");

		//Step 4:get the control of row
		Row rw = sh.getRow(1);

		//Step 5:get the control of coloumn
		Cell cl = rw.getCell(2);
		Cell c2 = rw.getCell(1);

		//Step 6:capture the information inside the cell
		String value = cl.getStringCellValue();
		String value2=c2.getStringCellValue();
		System.out.println(value);
		System.out.println(value2);
	}


}
