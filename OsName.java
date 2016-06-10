/*
 * OsName.java
 *
 * Version:1.0
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */
/**
 * This program prints the operating system name of the user.
 * 
 *
 * @author     Gireeshma Bokka Reddy
 */

public class OsName 
{

	public static void main(String Args[])
	{
	String osName;
	osName=System.getProperty("os.name");//getting the value of "os.name" from the system properties
	System.out.println("The operating system running on this system is: " +osName);
	}

}
