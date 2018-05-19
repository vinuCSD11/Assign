/**ADMIN
 * 
 */
package edu.bcas.Array;

import java.util.Arrays;

/**
 * @author ADMIN
 *
 */
public class ArrayExercise {
	public static void main(String[] args) {
		
		int marks [] = {10,20,30,40,50,60,70,80,90,100};
		int sum=0;
		int average = 0;
		int max = 0;
		int min = 0;
	    int ctr = 0;
		int smallest = 0;
	    int secondSmallest = 0;
		for(int counter=0;counter<marks.length;counter++) {
			sum+=marks[counter];
		}
		System.out.println("the total marks is"+ " " +sum);
		average= sum /marks.length;
		System.out.println("the Average is"+" " + average);
		for(int i =0;i < marks.length;i++) 
		 max= marks [i];
		System.out.println("max"+" "+ max);
		 
		 for(int j =0;j > marks.length;j--) 
		 min=marks [j];
		 System.out.println("min"+ " "+min);
		 for(int x= 0; x < marks.length; x++)
			{
				if(marks[x] % 2 == 0)
					ctr++;
			}
			System.out.println("Number of even numbers : "+ctr);
			System.out.println("Number of odd numbers  : "+(marks.length-ctr));

            for (int a = 0; a < marks.length; a++) 
		    {
		        if(marks[a]==smallest)
		        {
		          secondSmallest=smallest;
		        } 
		        else if (marks[a] < smallest) 
		        {
		            secondSmallest = smallest;
		            smallest = marks[a];
		        } 
		        else if (marks[a] < secondSmallest) 
		        {
		            secondSmallest = marks[a];
		        }

		    }
		    System.out.println(secondSmallest);
	}

	
			     }
			  
		 





