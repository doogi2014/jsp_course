package test_12;

public class Cube implements Solid {
	
	private double w;
	private double h;
	private double l;
	
	public Cube(double w, double h, double l) {
		this.w=w;
		this.h=h;
		this.l=l;
	}

	@Override
	public double getArea() {
		return 2*w*h+2*w*l+2*h*l;
	}

	@Override
	public double getVolume() {
		return w*h*l;
	}
}
