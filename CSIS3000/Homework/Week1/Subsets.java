package Week1;

import java.util.*;

//2. Write a program that, given a positive integer n, prints out all the subsets of {1,2,…,n}.
//Hint: (use Integer toBinaryString() and the String method toCharArray() ).
public class Subsets {

	public static void main(String[] args) {
		int N = 3;
		int totalSubsets = (int)Math.pow(2, N); //2^N subsets
		for (int i = 0; i < totalSubsets; i++)
		{
			System.out.print("{ ");
		    for (int j = 0; j < N; j++){
		        if ((i & (1 << j)) > 0)	//if it is not 0, grab the number
		           System.out.print((j + 1) + " ");
		    }
		    System.out.println("}");
		}
	}

}
