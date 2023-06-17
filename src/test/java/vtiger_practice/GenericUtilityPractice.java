package vtiger_practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String args[]) throws Throwable {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String value=pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String evalue=eUtil.readDataFromExcelFile("organization", 5, 2);
		System.out.println(evalue);
		
		
		eUtil.writeDataFromExcelFile("Trial", 3, 4,"SpiderMan");
		System.out.println("data added");
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemInFormat());
	}
}
