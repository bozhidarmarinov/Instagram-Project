package Instagram_Project;

import java.sql.*;

public class DbQuery {
	public static void main(String[] args) {

		try (Connection connection = JavaDatabaseConnection.connectToDB();
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE user_name='Pesho"
						+ "'")) {
			System.out.println("");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("user_id") + "\t" + resultSet.getString("user_name") + "\t"
						 + resultSet.getString("email") + "\t"
						+ resultSet.getString("name") + "\t" + resultSet.getString("gender") + "\t"
						+ resultSet.getString("biography") + "\t");
			}
			//resultSet.absolute(1); //move the cursor to the first row in the ResultSet object
			//resultSet.updateString(4, "pesho@gmail.bg");
			//resultSet.updateRow();
			//resultSet.beforeFirst();
			resultSet.moveToInsertRow();
			resultSet.updateInt("user_id",4);
			resultSet.updateString("user_name","Mara");
			resultSet.updateString("password", "test");
			resultSet.updateString("email","marcheto@gmail.com");
			resultSet.updateString("name","Mariya Dimitrova");
			resultSet.updateString("gender","female");
			resultSet.updateString("biography",null);
			resultSet.insertRow();
			
			
			
			System.out.println();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("user_id") + "\t" + resultSet.getString("user_name") + "\t"
						 + resultSet.getString("email") + "\t"
						+ resultSet.getString("name") + "\t" + resultSet.getString("gender") + "\t"
						+ resultSet.getString("biography") + "\t");
			}			

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
