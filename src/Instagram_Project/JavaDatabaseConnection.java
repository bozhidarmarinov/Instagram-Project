package Instagram_Project;

import java.sql.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JavaDatabaseConnection {

	// JDBC driver name and database URL

	public static Connection connectToDB() throws SQLException {
		
		
		
		//String jdbcDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String database= "instagram_project";
		 

		// Database credentials
		String userName = "lility";
		String password = "QWEasd123";
		
		return DriverManager.getConnection(url+database, userName, password);


	}
}
