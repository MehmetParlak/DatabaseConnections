import java.util.ArrayList;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DB_Functions db = new DB_Functions();
		// db.createConnection();
		User u = new User();
		u.setId(1);
		ArrayList<User> a = db.getDataFromDatabase(u);
		System.out.println(a.get(0).id + " " + a.get(0).latit + " " + a.get(0).longt + " " + a.get(0).date);
		System.out.println("Bitti!");

		User u2 = new User(7, "44.444", "55.555", "21 Oct");
		if (db.insertDataToDatabase(u2)) {
			System.out.println("Basarili bir insert oldu");
		}

		else {

			System.out.println("Olmasaydi sonumuz boyle");
		}

	}

}
