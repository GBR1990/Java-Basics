/**
 * This program displays the closest value of the euler's constant  
 * for the given value of delta.
 *
 * @author     Gireeshma Bokka Reddy
 * @author     Ketki Gorakhnath Trimukhe
 */

/**
 * This class displays the closest value of the euler's constant for the given
 * value of delta using three different methods.
 * 
 * @param e
 *            Represents the value of euler's constant.
 * @param delta
 *            The value of the acceptable difference between the real value and
 *            the calculated value.
 * 
 */
public class E {

	public static double e = Math.E;

	/**
	 * This method finds the value of the first argument raised to the power of
	 * the second argument.
	 * 
	 * @param answer
	 *            the value of the resulting power
	 */
	static double power(double i, double j) {
		double answer;
		if (i == 0) {
			answer = 0;
			return answer;
		} else if (j == 0) {
			answer = 1;
			return answer;
		} else {
			answer = 1;
			for (int k = 1; k <= j; k++) {

				answer = answer * i;

			}
			return answer;
		}

	}

	/**
	 * This method finds the value of the factorial of a number.
	 * 
	 * @param result
	 *            the value of the resulting factorial
	 */
	public static int factorial(int n) {
		int result = 1;
		if (n == 0) {
			result = 1;
		} else {
			for (int i = 1; i <= n; i++) {
				result = result * i;
			}
		}
		return result;
	}

	/**
	 * This method finds the value e using the formula (1+1/n) to the power n.
	 * 
	 * @param e2
	 *            the value of the resulting e
	 */
	public static double caculateEversion1(double d) {
		double e2 = 0, n = 1;
		for (n = 1; Math.abs(e2 - e) > d; n++) {

			e2 = power(1 + (1 / n), n);

		}

		System.out.println("The closest value of e from method 1 is: " + e2);
		return e2;

	}

	/**
	 * This method finds the value e using the formula (1+n) to the power 1/n.
	 * 
	 * @param e2
	 *            the value of the resulting e
	 */
	public static double caculateEversion2(double d) {
		double e2 = 0, n = 1;
		for (n = 1; n > 0; n = n - 0.00001) {
			if (Math.abs(e2 - e) > d) {

				e2 = power(1 + (n), (1 / n));

			}
		}
		System.out.println("The closest value of e from method 2 is: " + e2);
		return e2;
	}

	/**
	 * This method finds the value e using the formula (1/n!) summation.
	 * 
	 * @param e2
	 *            the value of the resulting e
	 */
	public static double caculateEversion3(double d) {

		double e2 = 0;

		double t = 0;

		for (int n = 0; Math.abs(e2 - e) > d; n++) {
			int k = factorial(n);

			t = (1.0 / k);

			e2 = e2 + t;
		}
		System.out.println("The closest value of e from method 3 is: " + e2);
		return e2;

	}

	/**
	 * This is the main method
	 * 
	 */
	public static void main(String args[]) {
		double delta = 0.001;

		double e1 = caculateEversion1(delta);
		double e2 = caculateEversion2(delta);
		double e3 = caculateEversion3(delta);
	}

}
