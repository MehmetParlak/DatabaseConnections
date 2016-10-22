import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//All functions about database must be declared here

public class DB_Functions {

	public static String host = "ec2-54-75-232-50.eu-west-1.compute.amazonaws.com";
	public static String db = "dco8tkjakrusuh";
	public static String user = "cdkxzqakhjojtw";
	public static String pass = "iSwVqlYEeZ8XQEBdSfMuJHZI3Y";
	public static int port = 5432;

//Just open a connection to db, don't forget to close the connection inside each function 	
public static Connection createConnection() {
		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			// return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db
					+ "?sslmode=require&user=" + user + "&password=" + pass + "");
			System.out.println("Hahahahah");

			// connection.close();

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			// return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		return connection;

	}

	// Verilen userid ye göre db den data getirecek(kullanıcı id, enlem, boylam,
	// zaman)

	public static ArrayList<User> getDataFromDatabase(User u) {

		ArrayList<User> al = new ArrayList<User>();
		al.add(u);
		Connection con = createConnection();
		try {
			String query = "Select * from public.location where user_id=(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, u.id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				al.get(0).id = rs.getInt("user_id");
				al.get(0).latit = rs.getString("latitude");
				al.get(0).longt = rs.getString("longitude");
				al.get(0).date = rs.getString("d_date");

			}
			ps.close();
			con.close();

			System.out.println("Tamamdir!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public static boolean insertDataToDatabase(User u) {

		boolean b=false;

		try {
			Connection con = createConnection();

			String query = "INSERT INTO public.location(user_id, longitude, latitude, d_date) VALUES (?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(query);			
			ps.setInt(1, u.id);
			ps.setString(2, u.longt);
			ps.setString(3, u.latit);
			ps.setString(4, u.date);

			ps.executeUpdate();

			ps.close();
			con.close();
			b = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			b = false;
			e.printStackTrace();
		}

		return b;
	}

}	
