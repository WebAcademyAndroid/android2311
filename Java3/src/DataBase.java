
public class DataBase {

	private DataBase() {
		
	}
	
	
	private static DataBase db;
	
	public static DataBase getInstance() {
		if(db == null) {
			db = new DataBase();
		}
		
		return db;
	}
	
	
	public void test() {
		
	}
}
