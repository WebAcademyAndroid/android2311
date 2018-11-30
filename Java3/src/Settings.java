
public class Settings {
	public static final String fontColor = "000";
	// public static String getColor() {
	// return fontColor;
	// }

	private static int fontSize = 16;

	public static void setFontSize(int size) {
		fontSize = size;

		Settings s = new Settings();
		s.test();
	}

	public void test() {
		fontSize = 33;
	}
}
