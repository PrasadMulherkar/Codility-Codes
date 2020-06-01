package frogJmp;

import java.util.Scanner;

public class Solution {

	public static int solution(int x, int y, int d) {
		int count = 0;
		while(x < y) {
			x += d;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of X :- ");
		int x = sc.nextInt();
		System.out.println("Enter value of Y :- ");
		int y = sc.nextInt();
		System.out.println("Enter value of D :- ");
		int d = sc.nextInt();
		int jmps = solution(x, y, d);
		System.out.println("Jumps :- "+jmps);
		sc.close();
	}

}
