package binaryGap;
import java.util.Scanner;

public class Solution {
	
	public static int solution(int N) {
		int binaryGap = 0, j=0;
		Character c;
		
		//Converting input number into its Binary form, storing into String
		String binaryString = Integer.toBinaryString(N);
		System.out.println("Binary Representation :- "+binaryString);
		
		//Calculating highest binary gap
		for (int i = 0; i < binaryString.length(); i++) {
			//Taking element at index i from String to character
			c = binaryString.charAt(i);
			
			//Checking the character equals to 0 or 1
			//Calculating length of binary gap
			if (c.equals('0')) {
				j += 1;
			}
			
			//Starting or ending of binary gap and calculting hihest of them;
			if (c.equals('1')) {
				if (j > binaryGap ){
					binaryGap = j;
				}
				j = 0;
			}
		}
		return binaryGap;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Input decimal number
		System.out.println("Enter no. to find binary gap :- ");
		int n = sc.nextInt();
		
		//Calling solution function
		int highestBinaryGap = solution(n);
		
		//Highest Binary Gap in binary form of input number
		System.out.println("Highest binary gap :- "+highestBinaryGap);
		sc.close();
	}
}
