package test_12;

public class Cylinder implements Solid {
	
	private static double PI = 3.1415926;
	private double r;
	private double h;
	
	public Cylinder(double r, double h) {
		this.r = r;
		this.h = h;
	}

	@Override
	public double getArea() {
		
		return 2*PI*r*h + 2*PI*r*r;
	}

	@Override
	public double getVolume() {
		
		return PI*r*r*h;
	}
}
