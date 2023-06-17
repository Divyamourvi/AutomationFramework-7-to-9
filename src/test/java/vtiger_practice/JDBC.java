package vtiger_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC {
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
		String query="select * from student";
									//tablename
		
		//step 4:Execute (fetching the data from db to eclipse,so to do that we need to create query i.e select * in above line))
		ResultSet result= stat.executeQuery(query);
		
		//if you have any data next then print that.1,2,3,are column index
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			
		}
		
		//Step 5: close the dabase connection(mandatory)
		conn.close();
	}
}
