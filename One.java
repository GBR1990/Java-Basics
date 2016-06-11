import java.util.*;

/* This program runs abc in the given pattern.
 *
 * @author     Gireeshma Reddy
 * @author     Ketki Trimukhe
 */

/**
 * This class helps in running the pattern.
 * 
 *
 */

public class One extends Thread {
	String name;// name of the string entering
	static String id;// value being printed out
	static Vector aVector = null;// the shared vector object
	static int setValue = 1;// the value used to control the order
	static int i = 0;// the index of the vector

	public One(String name, Vector v) {
		this.name = name;
		this.aVector = v;
	}

	public void run() {
		while (true) {

			synchronized (aVector) {

				try {
					sleep(100);
				} catch (InterruptedException e) {
				}

				if (this.name == "a") {

					if (setValue == 1) {
						id = "a";
						setValue = 2;
					} else {
						try {
							aVector.notify();
							aVector.wait();
						} catch (InterruptedException e) {
							System.out.println("Interrupted!");
						}
					}
				}

				else if (this.name == "b") {
					if (setValue == 2) {
						id = "b";
						setValue = 3;
					} else {
						try {
							aVector.notify();
							aVector.wait();
						} catch (InterruptedException e) {
							System.out.println("Interrupted!");
						}
					}
				}

				else if (this.name == "c") {
					if (setValue == 3) {
						id = "c";
						setValue = 1;
					} else {
						try {
							aVector.notify();

							aVector.wait();
						} catch (InterruptedException e) {
							System.out.println("Interrupted!");
						}
					}
				}

				if (aVector.elementAt(i) != id) {
					aVector.add(id);
					System.out.print(id);
					i++;
				}

				aVector.notifyAll();

			}

		}
	}

	public static void main(String args[]) {
		Vector aVector = new Vector();

		{
			aVector.add(0);
			One o1 = new One("a", aVector);
			One o2 = new One("b", aVector);
			One o3 = new One("c", aVector);

			o1.start();

			o2.start();

			o3.start();

		}

	}
}
