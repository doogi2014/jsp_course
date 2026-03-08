package test12;

public class Casher {

	public static int payment(int amount, Coupon coupon) {
		return coupon.discount(amount);
	}
}
