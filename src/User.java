import java.util.Date;

public class User {

	public int id;
	public String longt;
	public String latit;
	public String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLongt() {
		return longt;
	}

	public void setLongt(String longt) {
		this.longt = longt;
	}

	public String getLatit() {
		return latit;
	}

	public void setLatit(String latit) {
		this.latit = latit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User(int id, String longt, String latit, String date) {
		// super();
		this.id = id;
		this.longt = longt;
		this.latit = latit;
		this.date = date;
	}

	public User() {
	}

}
