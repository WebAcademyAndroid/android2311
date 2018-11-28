import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		/*
		 * int time = 5;
		 * 
		 * if (salary < 500 || salary > 2000) { System.out.println("NO!"); } else {
		 * System.out.println("YES!"); }
		 * 
		 * if (!(salary < 500 || salary > 2000)) { System.out.println("YES!"); } else {
		 * System.out.println("NO!"); }
		 * 
		 * boolean b = salary < 500 || salary > 2000; if (b) {
		 * System.out.println("NO!"); } else { System.out.println("YES!"); }
		 * 
		 * System.out.println(salary < 500 ? "NO!" : salary > 2000 ? "NO!" : "YES!");
		 */

		/*
		 * int salary = 1000; if (salary < 500 || salary > 2000) {
		 * System.out.println("NO!"); } System.out.println("NO!");
		 */

		/*
		 * int salary = 100; switch (salary) { case 100: case 2000:
		 * System.out.println("NO!"); break; case 1000: System.out.println("YES!");
		 * break; default: System.out.println("I dont nkow"); break; }
		 */

		/*
		 * int a = 0; int b = 0;
		 * 
		 * System.out.println(a++); System.out.println(++b);
		 * 
		 * System.out.println(a); System.out.println(b);
		 */

		/*
		 * int salary = 1000; int money = 0;
		 * 
		 * for (int i = 0; i < 3; i++) { //for (int i = 3; i > 0; i--) { money +=
		 * salary; //System.out.println(money); }
		 * 
		 * System.out.println(money);
		 */

		/*
		 * int count = 0; int salary = 5000; while(salary < 1000) { salary += 10;
		 * 
		 * count++; if(count > 99999) { break; } } System.out.println(salary);
		 * 
		 * 
		 * salary = 5000; do { salary += 10; } while(salary < 1000);
		 * System.out.println(salary);
		 */

		/*
		 * int[] arr = new int[10]; for (int i = 0; i < arr.length; i++) { arr[i] = i +
		 * 1; }
		 * 
		 * arr[5] = 222;
		 * 
		 * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i]);
		 * 
		 * if (i < arr.length - 1) { System.out.print("-"); } }
		 * 
		 * String str = "1-2-33-4-5-66-7-8-9-----101"; String[] arr2 = str.split("-");
		 * 
		 * System.out.println(""); int count = 0; for (int i = 0; i < arr2.length; i++)
		 * { System.out.print(arr2[i]);
		 * 
		 * if (i < arr.length - 1) { //System.out.print("="); } } int[] arr4 = new
		 * int[count];
		 */

		/*
		 * String email = "vasya@mail.com"; String[] arr = email.split("@");
		 * if(arr.length == 2) { System.out.print(arr[0]); }
		 */

		/*
		 * ArrayList<String> arr = new ArrayList<>(); arr.add("AAA"); arr.add(0, "BBB");
		 * arr.set(1, "CCC"); arr.remove(0);
		 * 
		 * for (int i = 0; i < arr.size(); i++) { System.out.println(arr.get(i)); }
		 */

		ArrayList<String> arr = new ArrayList<>();
		arr.add("AAA");
		arr.add("BBB");
		arr.add("CCC");
		arr.add("DDD");
		arr.add("BBB");
		arr.add("BBB");
		arr.add("AAA");
		arr.add("EEE");

		/*
		 * for (int i = 0; i < arr.size(); i++) { if(arr.get(i).equals("BBB")) {
		 * arr.remove(i); i--; } }
		 */

		/*
		 * for (int i = arr.size() - 1; i >= 0; i--) { if (arr.get(i).equals("BBB")) {
		 * arr.remove(i); } }
		 */

		/*
		 * int index = findBBB(arr); while (index >= 0) { arr.remove(index); index =
		 * findBBB(arr); }
		 * 
		 * for (int i = 0; i < arr.size(); i++) { System.out.println(arr.get(i)); }
		 * 
		 * int i = 0; for (String str : arr) { System.out.print(str); i++; }
		 * System.out.println(""); for (int i = 0; i < arr.size(); i++) { String str =
		 * arr.get(i); System.out.print(str); }
		 */

		ArrayList<ArrayList<HashMap<String, Integer>>> arrrr;
		
		int[][][][][] a2;
		a2[1][3][0][4444][3] = 5;
		
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("E", 3);
		map.put("D", 4);
		map.put("Z", 5);

		for (String key : map.keySet()) {
			//System.out.println("key: " + key + " value: " + map.get(key));
			System.out.println(String.format("key: %s value: %d", key, map.get(key)));
		}
		
		test("template", "v1", "v2", "v3");
	}
	
	
	public static void test(String template, String... values) {
		values[7] = "qwe";
	}

	public static int findBBB(ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals("BBB")) {
				return i;
			}
		}

		return -1;
	}

	public static boolean check(int salary) {
		// boolean result;

		if (salary < 500 || salary > 2000) {
			return false;
		}
		return true;

		// return result;
	}

	public static boolean check2(int salary) {
		switch (salary) {
		case 100:
		case 2000:
			return false;
		case 1000:
			return true;
		default:
			return false;
		}
	}

	public static void check3(int salary) {
		if (salary < 500 || salary > 2000) {
			return;
		}

	}

}
