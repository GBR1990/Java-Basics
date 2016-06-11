import java.util.Arrays;

import java.util.Scanner;
import java.io.File;
/**
 * This program finds the palindromes in the given text file and all the possible sub palindromes.
 * 
 *
 * @author     Ketki Gorakhnath Trimukhe
 * @author     Gireeshma Bokka Reddy
 */
public class Palindrome 
{
	/**
   * This method reverses the string
   * 
   *
   * @param    str                 the string which we are reversing
   * @param    chars               the characters of the string
   * @param    length              the length of the string
   * @param    tempVar             the temporary variable used to store the value
   * 
   */
    	   
    	  
    	   
    	   
	
	public static String reverseString(String str) 
		{
		if ((null == str) || (str.length() <= 1)) 
			{
			return str;
			}
			char[] chars = str.toCharArray();
			int length = chars.length - 1;
			for (int i = 0; i < length; i++) 
			{
			char tempVar = chars[i];
			chars[i] = chars[length];
			chars[length--] = tempVar;
			}
			return new String(chars);
		}
           
	public static void main( String[] args ) 
	{
	try 
		{	
		int counter=0;
		Scanner sc  = new Scanner( new File("palindrome_1.txt"));
		while ( sc.hasNext() )  
			{
			String line = sc.nextLine();
			System.out.println("The line is:"+line);// your code goes here
			int length = line.length();
                              
                              
			line=line.toLowerCase();
			String substr;
			String reverse;
                              
			for(int k=2;k<=length;k++)
				{
				for(int x=0;x<k;x++)
					{
					substr=line.substring(x,k);
					reverse=reverseString(substr);
                            	  
					if(substr.length()>2)
						{
                            	  
						if(substr.equals(reverse))
							{
							counter++;
                              		
							System.out.println(substr);
							}
						}
                            	  
                            	  
                          	  
                          	  
                          	  
                          	  
                            	  
                            		
	}
}
                              
                              
                              
                              
                              
                              
System.out.println("Total palindromes: "+counter);
}
                         
                              
                              
                              
                                                 
sc.close();
} 
catch ( Exception e ) 
{
System.err.println("Something went wrong!");
}
}
}
