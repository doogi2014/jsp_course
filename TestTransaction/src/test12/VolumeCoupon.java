package test12;

public class VolumeCoupon extends Coupon {

	private int volume;
	
	public VolumeCoupon(int volume) {
		this.volume = volume;
	}
	
	@Override
	public int discount(int amount) {
		return amount - volume;
	}
}
