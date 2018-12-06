
public class Main {

	public static final int SHAPE_CIRCLE = 1;
	public static final int SHAPE_SQUARE = 2;

	public static void main(String[] args) {

		/*
		 * Circle c = new Circle(100); c.test(); print(c);
		 * 
		 * Square s = new Square(100); print(s);
		 * 
		 * System.out.println(s.toString());
		 * 
		 * // IShape[] arr = new IShape[] { c, s };
		 * 
		 * Square s2 = new Square(10); System.out.println(s.equals(s2) ? "Equal" :
		 * "Not equal");
		 * 
		 * // Circle c = null; // print(c);
		 * 
		 * try { test(); } catch (Exception e) {
		 * 
		 * }
		 * 
		 * test2();
		 */

		//s..tarOut("\"ab*cd\"");
		xyBalance("aaxbby");
	}

	public static boolean xyBalance(String str) {
		for (int i = str.length() - 1; i <= 0; i--) {
			if (str.charAt(i) == 'y') {
				return true;
			} else if (str.charAt(i) == 'x') {
				return false;
			}
		}

		return false;
	}

	public static String starOut(String str) {
		str = str.replaceAll("[\\*]{2,}", "*");

		String[] ar = str.split("\\*");

		String res = "";
		for (int i = 0; i < ar.length; i++) {
			if (ar[i].equals("")) {

			} else if (i == 0) {
				res += ar[i].substring(0, ar[i].length() - 1);

			} else if (i == ar.length - 1) {
				res += ar[i].substring(1);
			} else {
				res += ar[i].substring(1, ar[i].length() - 1);
			}
		}

		return res;
	}

	public static void test() {
		throw new ArithmeticException();
	}

	public static void test2() throws ArithmeticException {
		throw new ArithmeticException();
	}

	public static void print(BaseShape bShape) {
		/*
		 * bShape.print(); System.out.println(bShape.calculate());
		 * 
		 * if (bShape instanceof Circle) { Circle c = (Circle) bShape; c.test(); }
		 */

		// throw new ArithmeticException();

		try {
			int i = 5 / 0;
			bShape.print();
		} catch (NullPointerException e) {
			System.out.println("Null");
		} catch (ArithmeticException e) {
			System.out.println("Zero");
			return;
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("finally");
		}

	}

}
