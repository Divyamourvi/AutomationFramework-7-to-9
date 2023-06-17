package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file 
 * @author Vinay G
 */


public class PropertyFileUtility {
	
	
/**
 * This method will read data from property file
 * @param key
 * @return
 * @throws Throwable
 */
	
	public String readDataFromPropertyFile(String key) throws Throwable {

	FileInputStream fis=new FileInputStream(IConstantsUtility.propertyFilePath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
	}	
}
