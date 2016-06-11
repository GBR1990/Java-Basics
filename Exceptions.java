/*Program 	
 * Exceptions.java
 *
 * Version:1.0
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */
import java.awt.Color;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

/**
 * This program creates some possible kinds of exceptions.
 *
 * @author     Ketki Gorakhnath Trimukhe
 * @author     Gireeshma Bokka Reddy
 */

/**
 * 
 * This class contains methods for each exceptions thrown
 * 
 */
public class Exceptions extends Thread {

	/**
	 * 
	 * This method throws an arithmetic exception
	 * 
	 */

	public static void ex_arithemetic() {
		try {
			int x = 2 / 0;

			int y = x;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws an Array out of bounds exceptions
	 * 
	 */

	public static void ex_arrayOutOfBound() {
		try {
			int[] a = new int[2];

			for (int i = 0; i < 5; i++) {
				int b = a[i];
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws an Array Store exception
	 * 
	 */

	public static void ex_arrayStoreExcp() {
		try {
			Object x[] = new Integer[3];
			x[0] = new String("test");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a Class Cast exception
	 * 
	 */

	public static void ex_classCastException() {
		try {
			Object i = Integer.valueOf(42);
			String s = (String) i;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a Class not found exception
	 * 
	 */

	public static void ex_ClassNotFoundException() {
		try {
			Class.forName("Test");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a file not found exception
	 * 
	 */

	public static void ex_fileNotFoundException() {
		try {
			FileReader file_to_read = new FileReader("e:/test.text");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws an Illegal Argument exception
	 * 
	 */

	public static void ex_IllegalArgumentException() {
		try {
			Color clr1 = new Color(300, 150, 200);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws an Illegal Thread exception
	 * 
	 */

	public static void ex_IllegalThreadStateException() {
		try {
			Exceptions d1 = new Exceptions();
			d1.start();
			d1.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws an Interrupted exception
	 * 
	 */

	public static void ex_InterruptedException() {
		final Thread mainThread = Thread.currentThread();

		Thread interruptingThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// Let the main thread start to sleep
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				mainThread.interrupt();
			}
		});

		try {
			interruptingThread.start();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a Negative Array Size exception
	 * 
	 */

	public static void ex_NegativeArraySizeException() {
		try {
			int[] a = new int[-5];
			a[-3] = 5;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a No such Field exception
	 * 
	 */

	public static void ex_NoSuchFieldException() {

		Exceptions a = new Exceptions();

		try {
			Field fieldValue = a.getClass().getField("test");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a No such Method exception
	 * 
	 */

	public static void ex_NoSuchMethodException() {
		try {
			Exceptions product = new Exceptions();
			Method m_set = product.getClass().getMethod("test");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a Null Pointer exception
	 * 
	 */

	public static void ex_NullPointerException() {
		try {
			int test = (Integer) null;
			int c = test;

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a Number format exception
	 * 
	 */

	public static void ex_NumberFormatException() {
		try {
			String str2 = "ten";
			int y = Integer.parseInt(str2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This method throws a String Index Out of Bounds exception
	 * 
	 */

	public static void ex_StringIndexOutOfBoundsException() {
		try {
			String name = "ketki";
			char c = name.charAt(6);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * This is the main method. It calls all the methods.
	 * 
	 */
	public static void main(String[] args) {

		ex_arithemetic();

		ex_arrayOutOfBound();

		ex_StringIndexOutOfBoundsException();

		ex_classCastException();

		ex_ClassNotFoundException();

		ex_fileNotFoundException();

		ex_IllegalArgumentException();

		ex_IllegalThreadStateException();

		ex_InterruptedException();

		ex_NegativeArraySizeException();

		ex_NullPointerException();

		ex_NumberFormatException();

		ex_arrayStoreExcp();

		ex_NoSuchMethodException();

		ex_NoSuchFieldException();

	}

}
