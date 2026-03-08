package test_12;

public class Rectangle implements Shape {
	
	private double w;
	private double h;
	
	public Rectangle(double w,double h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double getArea() {
		
		return this.w * this.h;
	}

	@Override
	public double getPerimeter() {
		return this.w*2 + this.h*2;
	}

}
