
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			//connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/testdb", "mkyong", "123456");

			connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/dco8tkjakrusuh", "cdkxzqakhjojtw", "iSwVqlYEeZ8XQEBdSfMuJHZI3Y");

			connection.close();
			
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}
