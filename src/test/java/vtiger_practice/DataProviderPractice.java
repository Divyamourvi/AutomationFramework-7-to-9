package vtiger_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "getdata")
	public void sampleDataTest(String name,String model,int qty) {
		System.out.println(name+"--->"+model+"--->"+qty);
	}
	
	@DataProvider
	public Object[][] getdata(){
		
		//4 different data sets consisting of 3 details
		Object[][] data=new Object[4][3];
		
		data[0][0]="Samsung";  //name
		data[0][1]="A80";		//model
		data[0][2]=10;			//quantity
		
		data[1][0]="Nokia"; 
		data[1][1]="S0";
		data[1][2]=12;	
		
		data[2][0]="Iphone"; 
		data[2][1]="A14";
		data[2][2]=15;	
		
		data[3][0]="vivo"; 
		data[3][1]="Spro";
		data[3][2]=15;	
		
		return data;
		
	}
}
