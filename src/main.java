
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdk.internal.dynalink.beans.StaticClass;

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

			//connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/dco8tkjakrusuh", "cdkxzqakhjojtw", "iSwVqlYEeZ8XQEBdSfMuJHZI3Y");

			connection=DriverManager.getConnection("jdbc:postgresql://ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/dco8tkjakrusuh?sslmode=require&user=cdkxzqakhjojtw&password=iSwVqlYEeZ8XQEBdSfMuJHZI3Y");
			String query = "Select longitude from public.location where user_id=1";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {
				String st_long = rs.getString("longitude");
				System.out.println(st_long);

			}

			s.close();
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
	
	public static void insert_data(int id, String longt, String lat, String date){
		
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

			connection=DriverManager.getConnection("jdbc:postgresql://ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/dco8tkjakrusuh?sslmode=require&user=cdkxzqakhjojtw&password=iSwVqlYEeZ8XQEBdSfMuJHZI3Y");
			System.out.println("Congrats!!!");
			
			/*String query = "INSERT INTO public.location(user_id, longitude, latitude, d_date)VALUES (?,?,?,?);";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, longt);
			ps.setString(3, lat);
			ps.setString(4, date);

			ps.executeQuery();
			
			//Statement s = connection.createStatement();
			/*ResultSet rs = s.executeQuery(query);

			while (rs.next()) {
				String st_long = rs.getString("longitude");
				System.out.println(st_long);

			}*/

			//ps.close();
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
