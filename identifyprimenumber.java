/**ADMIN
 * 
 */
package bcas.as;

/**
 * @author ADMIN
 *
 */
//java program to  check  whether number is prime or not*/
	import java.util.Scanner;
	public class identifyprimenumber {
		public static void main (String args[]){
	    {
	        int num, i, count=0;
	        Scanner scan = new Scanner(System.in);
			//Enter the number to next box
	        System.out.print("Enter a Number : ");
	        //capture input in a integer
	        num = scan.nextInt();
			//check for loop condition
	        for(i=2; i<num; i++)
	        {
	        	//condition for not prime number
	            if(num%i == 0)
	            {
	                count++;
	                break;
	            }
	        }
	        if(count == 0)
	        {
	        	// if this number is prime number to show
	            System.out.print("This is a Prime Number");
	        }
	        else
	        {
	        	//if this number is  not prime number to show 
	            System.out.print("This is not a Prime Number");
	        }
	    }
	}
}
