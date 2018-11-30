import java.util.ArrayList;

import test.TestClass;

public class Main {

	public static void main(String[] args) {
		/*
		 * Student s = new Student(); s.name = "Ivan"; s.age = 22;
		 * 
		 * Student s2 = new Student("Ivan", 22);
		 */

		/*
		 * int a = 1; int b = a; a = 2;
		 * 
		 * Student s = new Student(); s.age = 10;
		 * 
		 * Student s2 = s; s2.age = 20;
		 * 
		 * test(b, s);
		 */

		/*
		 * int a = 1; int b = 1; if (a == b) {
		 * 
		 * }
		 * 
		 * Student s = new Student("Ivan", 22); Student s2 = new Student("Ivan", 22); if
		 * (s == s2) {
		 * 
		 * }
		 * 
		 * String str = "AAA"; String str2 = "AAA"; if (str.equals(str2)) {
		 * 
		 * }
		 * 
		 * 
		 * ArrayList<Student> arr = new ArrayList<>();
		 * 
		 * Student sss = new Student("Ivan", 22); arr.add(sss);
		 * 
		 * sss = new Student("Ivan", 22); arr.add(sss);
		 * 
		 * sss = arr.get(0);
		 */

		Student sss = new Student("Ivan", 22);
		sss = null;

		Student s = null;
		test(s);

		TestClass tc = new TestClass();

		Settings.setFontSize(20);

		DataBase.getInstance().test();

		Student[] arr = new Student[] { new Student() };

		Group g = new Group();
		g.name = "2311";
		g.students.add(new Student("Ivan", 22));
	}

	public static void test(Student s) {
		if (s != null) {
			s.setAge(44);
		}
	}

}
