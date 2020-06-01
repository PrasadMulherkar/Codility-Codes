package tapeEquilibrium;

import java.util.Scanner;

public class Solution {
	public int solution(int[] A) {
		int sumleft = A[0], sumright = 0;
		for(int i=1; i<A.length; i++) {
			sumright += A[i];
		}
		int minDiff = Math.abs(sumleft-sumright);
		for(int p=1; p<A.length; p++) {
			if(minDiff > Math.abs(sumleft-sumright)) {
				minDiff = Math.abs(sumleft-sumright);
			}
			sumleft += A[p];
			sumright -= A[p];
		}
		return minDiff;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of elements :- ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements :-");
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		int minDiff = new Solution().solution(a);
		System.out.println("Minimum difference :- "+minDiff);
		sc.close();
	}

}
