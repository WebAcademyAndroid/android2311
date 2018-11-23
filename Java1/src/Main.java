
public class Main {

	static String mStr = "";
	
	public static void main(String[] args) {
		/*
		 * String s = "Hello world!"; System.out.println(s);
		 * 
		 * System.out.println("Hello world!");
		 * 
		 * int a = 3 + 2; int b = (a - 33) * 5; System.out.println(b * 4);
		 * 
		 * float c = 5/2f; System.out.println(c);
		 * 
		 * String ss = "Hello" + "world" + "(5 + 6)"; System.out.println(ss);
		 */

		/*
		 * String s = "abcabc"; System.out.println(s.indexOf("b"));
		 * System.out.println(s.indexOf("b", 3));
		 */

		/*
		 * String s = "abcabc"; System.out.println(s.replace("ab", "AB"));
		 */

		/*
		 * String s = "  abc abc   "; s = s.trim().replace(" ", "").toLowerCase();
		 * System.out.println(s.replace(" ", ""));
		 */

		/*
		 * String s = "abcabc"; char c = s.charAt(1); System.out.println(c);
		 */

		/*
		 * String s = "abcabc"; System.out.println(s.substring(4));
		 * System.out.println(s.substring(1, 4));
		 */

		/*
		 * String email = "vasya@mail.com"; int dog = email.indexOf("@"); String login =
		 * email.substring(0, dog); System.out.println(login);
		 */

		//String s = test("Hello function!", 1, true);
		//System.out.println(s);
		
		/*String s = "abc";
		test(s);
		
		System.out.println(s);*/
	
		
		
		int a = 3;
		String s = Integer.toString(a);
		
		float f = Float.valueOf("3");
		
		String ss = String.valueOf(a);
		
		int i = Integer.valueOf("1");
		int iy = Integer.parseInt(" 1 000".replace(" ", ""));
		
		Float.parseFloat("2.000,2");
	}
	
	public static void test(String s) {
		s = "aaa";
		
		String sss = "";
		sss = "123";
		
		String str = "";
		
		str="";
	}
	
	
	
	

	/*public static String test(String s, int a, boolean b) {
		System.out.println(s);

		return s + a + b;
	}
	
	public static String test(String s, int a) {
		System.out.println(s);

		return s + a;
	}

	public static String test(String s) {
		System.out.println(s);

		return s;
	}*/
}
