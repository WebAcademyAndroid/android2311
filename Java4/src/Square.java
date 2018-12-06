
public class Square extends BaseShape  {

	private int side;

	public Square(int side) {
		this.type = Shapes.Square;
		this.side = side;
	}

	@Override
	public double calculate() {
		return side * side;
	}

	@Override
	public String toString() {
		return type + ": " + calculate();
	}
	
	@Override
	public boolean equals(Object o) {
		return ((Square)o).side == side;
	}
}
