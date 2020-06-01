/*Question :- 

		An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which 			means that exactly one element is missing.

		Your goal is to find that missing element.

		Write a function:

		    class Solution { public int solution(int[] A); }

		that, given an array A, returns the value of the missing element.

		For example, given array A such that:
		  A[0] = 2
		  A[1] = 3
		  A[2] = 1
		  A[3] = 5

		the function should return 4, as it is the missing element.

		Write an efficient algorithm for the following assumptions:
	
		        N is an integer within the range [0..100,000];
		        the elements of A are all distinct;
		        each element of array A is an integer within the range [1..(N + 1)].
*/

package permMissingElem;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public int solution(int[] A) {
		int missingElement = 1;
		if(A.length>0) {
			Arrays.sort(A);
			for(int i=0; i<A.length-1; i++) {
				if(A[i] != A[i+1]-1) {
					missingElement = A[i]+1;
				}
			}
			if(missingElement == 1 && A[0] == 1) {
				missingElement = A.length+1;
			}
		}
		return missingElement;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("No. of elements :- ");
		int n = sc.nextInt();
		int[] A = new int[n];
		System.out.println("Elements :- ");
		for(int i=0; i<A.length; i++) {
			A[i] = sc.nextInt();
		}
		int missingElement = new Solution().solution(A);
		System.out.println("Missing Element :- "+missingElement);
		sc.close();
	}

}
