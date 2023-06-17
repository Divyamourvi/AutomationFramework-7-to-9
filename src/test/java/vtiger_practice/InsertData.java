package vtiger_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertData {

public static void main(String[] args) throws Throwable {
		
		//1.Register driver(object creation of driver)
		Driver driverRef=new Driver();
		
		//load mysql database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: connection to database which we want to communicate out of multiple databases and store in some variable
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weekendbatch","root","root");
														//url                                     //username//password   
		
		//Step 3:create a sql statement for that connection. in that databse what you want to fetch write the query for that
		Statement stat = conn.createStatement();
		
		//inserting data into table
		String query = "INSERT INTO STUDENT(FIRST_NAME,LAST_NAME)VALUES('AMITH','SHAH')";
		
		//Step 4:Execute
		int result=stat.executeUpdate(query);
		
		//step 5:close
		conn.close();
}
}

