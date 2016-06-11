import java.util.Scanner;

/**
 * This program displays the steps in moving the tower of hanoi from one 
 * pole to the other using a third pole.
 *
 * @author     Gireeshma Bokka Reddy
 * @author     Ketki Gorakhnath Trimukhe
 */

/**
 * This class displays the steps in moving the tower of hanoi from one pole to
 * the other using a third pole..
 *
 * @param array
 *            2D array to display the updated positions of the three poles
 * @param nZero
 *            The value that represents the number of discs in pole 0.
 * @param nOne
 *            The value that represents the number of discs in pole 1.
 * @param nTwo
 *            The value that represents the number of discs in pole 2.
 * @param number
 *            The number of discs.
 */
class Hanoi {

	public static String array[][] = new String[100][100];

	public static int nZero = -1;
	public static int nOne, nTwo, number;

	public static int j = 0, k = 0;

	/**
	 * This method sets the value of nOne.
	 * 
	 * @param m
	 *            The value that represents the number of discs.
	 */
	public static int setnOne(int m) {
		int n = m - 1;
		return n;
	}

	/**
	 * This method sets the value of nTwo.
	 * 
	 * @param m
	 *            The value that represents the number of discs.
	 */
	public static int setnTwo(int m) {
		int n = m - 1;
		return n;
	}

	/**
	 * This method makes the initial array that represents the position of the
	 * discs.
	 * 
	 * @param m
	 *            The value that represents the number of discs.
	 */
	public static void makeArray(int m) {
		for (int i = 0; i < m; i++) {

			for (int l = 0; l < 3; l++) {
				if (l == 0) {
					int M = i + 1;

					array[i][l] = String.valueOf(M);
				} else {
					array[i][l] = "0";
				}
				System.out.print(array[i][l]);
			}
			System.out.println("\n");
		}
	}

	/**
	 * This method uses recursion to indicate the steps to be taken to move the
	 * discs from start pole to end pole.
	 * 
	 * @param m
	 *            The value that represents the number of discs.
	 * @param poleStart
	 *            The pole at which the discs are placed initially.
	 * @param poleOver
	 *            The pole that is used to move from start pole to end pole.
	 * @param poleEnd
	 *            The pole at which the discs are placed finally.
	 */
	public static void move(int n, String poleStart, String poleOver,
			String poleEnd) {
		if (0 == n)
			return;

		// calling the move method recursively
		move(n - 1, poleStart, poleEnd, poleOver);

		System.out.println("Move the disk " + n + " from Pole " + poleStart
				+ " to Pole " + poleEnd);
		int poleEnd2 = Integer.parseInt(poleEnd);
		int poleStart2 = Integer.parseInt(poleStart);

		// changing the values of nZero,nOne and nTwo based on the starting
		// pole.
		if (poleStart2 == 0) {
			nZero++;
			j = nZero;

		} else if (poleStart2 == 1) {
			nOne++;
			j = nOne;

		} else if (poleStart2 == 2) {
			nTwo++;
			j = nTwo;

		}

		// changing the values of nZero,nOne and nTwo based on the ending pole.
		if (poleEnd2 == 0) {
			k = nZero;
			nZero--;
		} else if (poleEnd2 == 1) {
			k = nOne;
			nOne--;
		} else if (poleEnd2 == 2) {
			k = nTwo;
			nTwo--;
		}
		array[k][poleEnd2] = Integer.toString(n);
		array[j][poleStart2] = "0";

		for (int i = 0; i < number; i++) {
			for (int l = 0; l < 3; l++) {
				System.out.print(array[i][l]);
			}
			System.out.println("\n");
		}

		// calling the move method recursively
		move(n - 1, poleOver, poleStart, poleEnd);
	}

	/**
	 * This is the main method.
	 * 
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of discs: ");
		String N = sc.next();
		number = Integer.parseInt(N);
		makeArray(number);
		nOne = setnOne(number);
		nTwo = setnTwo(number);
		move(number, "0", "1", "2");
		sc.close();
	}
}