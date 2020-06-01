/*Question : 	
		
		A non-empty array A consisting of N integers is given.

		The leader of this array is the value that occurs in more than half of the elements of A.

		An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 			2], ..., A[N − 1] have leaders of the same value.

		For example, given array A such that:
		    A[0] = 4
		    A[1] = 3
		    A[2] = 4
		    A[3] = 4
		    A[4] = 4
		    A[5] = 2

		we can find two equi leaders:

			   0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
			   2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

		The goal is to count the number of equi leaders.

		Write a function:

		    class Solution { public int solution(int[] A); }

		that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

		For example, given:
		    A[0] = 4
		    A[1] = 3
		    A[2] = 4
		    A[3] = 4
		    A[4] = 4
		    A[5] = 2

		the function should return 2, as explained above.

		Write an efficient algorithm for the following assumptions:

			   N is an integer within the range [1..100,000];
			   each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
*/

package equiLeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static int[] createArray(int[] array, int start, int end) {
		//To store the dynamic array
		List<Integer> arrayList = new ArrayList<Integer>();
		for(int i=start; i<=end; i++) {
			arrayList.add(array[i]);
		}
		
		//To convert array list into int type array
		//This uses Java 8 features - stream and lambda functions 
		int[] arrayTemp = arrayList.stream().mapToInt(i->i).toArray();
		return arrayTemp;
	}
	
	public static boolean hasSameLeader(int[] array1, int[] array2) {
		//Calculates the leader for first array
		int leader1 = leader(array1);
		//Calculates the leader for second array
		int leader2 = leader(array2);
		//Count no. of same leaders
		if(leader1 != -1 && leader1 == leader2) {
			return true;
		}
		return false;
	}
	
	//Algorithm to calculate the leader of an array
	public static int leader(int[] array) {
		int size = 0, value = 0, candidate = -1, count = 0, leader = -1;
		for(int k=0; k<array.length; k++) {
			if(size == 0) {
				size += 1;
				value = array[k];
			}
			else {
				if(value != array[k]) {
					size -= 1;
				}
				else {
					size += 1;
				}
			}
		}
		if(size > 0) {
			candidate = value;
		}
		for(int k=0; k<array.length; k++) {
			if(array[k] == candidate) {
				count++;
			}
		}
		if(count > (array.length/2)) {
			leader = candidate;
		}
		return leader;
	}
	
	public static int solution(int[] array) {
		//Initializing counter to 0
		int count = 0, s = 0;		
		
		//For loop to iterate every possible combination of array
		for(int i=s; i<array.length-1; i++) {
			//Creating array from 0 to s from given array
			int[] arrayTemp1 = createArray(array, 0, i);
			//Creating array from s+1 to length-1 from given array
			int[] arrayTemp2 = createArray(array, i+1, array.length-1);
			//Counting no. of equileaders
			if(hasSameLeader(arrayTemp1, arrayTemp2)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Creating array
		System.out.println("Enter no. of elements :- ");
		int n = sc.nextInt();
		int array[] = new int[n];
		System.out.println("Enter elements :- ");
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		//Display no. of EquiLeaders
		int equiLeaders = solution(array);
		System.out.println("No. of EquiLeader in given array are :- "+equiLeaders);
		sc.close();
	}
}