import java.math.BigInteger;
import java.util.Random;

public class ExistForg {

	public static void main(String[] args) {

		/**
		 * A random number is generated that is used in the bigInteger creator. This produces a random number that is 128 bits
		 * that is modded by 10000 to assess the last 4 digits
		 */
		Random num = new Random(System.currentTimeMillis());
		BigInteger e = new BigInteger("128018892198659869438744267"
				+ "891728377199295753981791399033460102259322494388756606728373121043154809790249663472677206622549"
				+ "24720490903440140409487830138442554051215639407252719582615491056895127372123401970340184655821416714383833567438594837829393436"
				+ "445708175846840391647287652219983832401360628720836954408208209");

		System.out.println("1st Problem");

		BigInteger sigma = new BigInteger(128, num);
		System.out.println(makeLastFour(sigma, e));

		BigInteger eb = new BigInteger("99985828020191359900880286869683035709839584003728838462445577041064"
				+ "9259059950052168890075728986418115945133344092917628"
				+ "7686491104489407462355371113514648093");

		System.out.println("2nd Problem");
		for (int i = 0; i < 6; i++) {
			sigma = new BigInteger(128, num);
			System.out.println(makeLastFour(sigma, eb));
		}
	}

	// sigma is created. This is verified to have 2017 at the end of the message
	public static String makeLastFour(BigInteger sigma, BigInteger e) {
		BigInteger large = new BigInteger("10000");
		BigInteger output = null;
		long twentyseventeen = sigma.modPow(e, e).mod(large).longValue();
		while (twentyseventeen != 2017) {
				sigma = sigma.add(BigInteger.ONE);
				output = sigma.modPow(e, e);
				twentyseventeen = output.mod(large).longValue();
		}
		return "sigma: " + output;
	}

}
