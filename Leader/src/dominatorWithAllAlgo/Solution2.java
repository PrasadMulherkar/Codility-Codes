/*Question : 	
		
		An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of 			the elements of A.

		For example, consider array A such that
			A[0] = 3    A[1] = 4    A[2] =  3
			A[3] = 2    A[4] = 3    A[5] = -1
			A[6] = 3    A[7] = 3

		The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) 			and 5 is more than a half of 8.

		Write a function

		    class Solution { public int solution(int[] A); }

		that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A 			occurs. The function should return −1 if array A does not have a dominator.

		For example, given array A such that
			A[0] = 3    A[1] = 4    A[2] =  3
			A[3] = 2    A[4] = 3    A[5] = -1
			A[6] = 3    A[7] = 3

		the function may return 0, 2, 4, 6 or 7, as explained above.

		Write an efficient algorithm for the following assumptions:

		        N is an integer within the range [0..100,000];
		        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
		        

		Using 2nd algorithm to find Leader with Time Complexity O(n * log n)
*/

package dominatorWithAllAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
	public static int solution(int[] a) {
		int dominator = -1, index = -1, candidate = -1, count = 0;
		Arrays.sort(a);
		candidate = a[a.length/2];
		for(int j=0; j<a.length; j++) {
			if(a[j] == candidate) {
				count++;
			}
		}
		if(count > a.length/2) {
			dominator = candidate;
		}
		for(int k=0; k<a.length; k++) {
			if(a[k] == dominator) {
				index = k;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Creating array
		System.out.println("Enter no. of elements in Array :- ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements :- ");
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		//Display indices where dominator is present
		int dominatorIndex = solution(a);
		System.out.println("Index where Dominator is present :- "+dominatorIndex);
		sc.close();

	}
}
