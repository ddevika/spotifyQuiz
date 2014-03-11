import java.io.*;
import java.util.Scanner;

/*********
 * 
 * @author ddevika
 *
 */

public class ReversedBinary {


	
	//main class
	public static void main (String [] args) throws IOException
	{
		//Step 0: get user's input from scanner stdin
		long input;
		
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		//System.out.println("Input: ");
		
		input = stdin.nextLong();
		
		//read every line of input
       // while (stdin.hasNext()) {
        	
        	//Step 1: convert each line to be binary
        	//String input = Long.toBinaryString(stdin.nextLong());
        	String a = Long.toBinaryString(input);
        	
        	//exception if input is out of range
        	  // if ((Long.parseLong(input) == 0 || Long.parseLong(input) >= 1000000000))
        	  // {
        	//	System.out.println("enter number between 1 to 1000000000");
        	//	break;
        	 //  }
        	   
        	//Step 2: call reverseBinary method to output the reverse binary
        	reverseBinary(a);
        	//System.out.println("Input: ");
          	
         
  
  //  }
        stdin.close();
	}
    
    	
  //Method (for Step 2): get the user's input, reverse the binary, and output the result
    public static void reverseBinary(String binary)
    {
    	//Step 2.0: convert binary String to be array
    	char[] a;
    	a = binary.toCharArray();
    		
    	//array to hold the reverse value
    	char [] num = new char [a.length];
    		
    	int basecase =2;
    		
    	//Step 2.1: adding elements to the new array with the binary backwards
    	for (int i=0; i < a.length; i++)
    	{
    		num[i]= a[a.length - 1 -i];
    			
    	}
    		
    	//Step 2.2: convert char to String
    	String bin = String.valueOf(num);
    		
    	//Step 2.3: convert String back to Binary
    	int reverseBin = Integer.parseInt(bin, basecase);
    	//System.out.println("Output: " +reverseBin);
    	System.out.println(reverseBin);
    		
    }
}

