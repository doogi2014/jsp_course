package test12;

public class PercentageCoupon extends Coupon {
	
	private double rate;
	
	public PercentageCoupon(double rate) {
		this.rate = rate;
	}

	@Override
	public int discount(int amount) {
		return (int) (amount*rate);
	}
}
