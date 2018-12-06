
public class Circle extends BaseShape {

	private int radius;

	public Circle(int radius) {
		this.type = Shapes.Circle;
		this.radius = radius;
	}

	@Override
	public double calculate() {
		return 3.14 * radius * radius;
	}
	
	public void test() {
		
	}
}
