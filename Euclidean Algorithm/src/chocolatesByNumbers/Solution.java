package chocolatesByNumbers;

import java.util.Scanner;

public class Solution {
	
	//Solution function that returns the no. of chocolates ate.
	public static int solution(int n, int m) {
		return n/gcdByDivision(n, m);  // 10/2 = 5
	}
	
	//Function to calculate greatest common divisor
	public static int gcdByDivision(int n, int m) { //4 2
		if(n%m == 0) {
			return m;
		}
		else {
			return gcdByDivision(m, n%m); //4 2
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Takes input of N and M
		System.out.println("Enter value of N and M :- ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//Stores the solution and display
		int noOfChocolatesAte = solution(n, m);
		System.out.println("No. of Chocolates ate :- "+noOfChocolatesAte);
		
		sc.close();
	}

}
