package oddOccuranceInArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	//Function to find odd occurance of element in array
	public static int solution(int[] array) {
		//Creating a hashmap to store element as key and its count as value
		Map<Integer, Integer> elementCount = new HashMap<Integer, Integer>();
		
		//Putting elements of array in hashmap as well counting no. of elements
		for(int i=0; i<array.length; i++) {
			if(elementCount.containsKey(array[i])) {
				int count = elementCount.get(array[i]);
				elementCount.put(array[i], count+1);
			}
			else {
				elementCount.put(array[i], 1);
			}
		}
		
		//Calculating odd occuring element
		for(Integer integer : elementCount.keySet()) {
			if(elementCount.get(integer)%2 == 1) {
				return integer;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Input no. of elements in array
		System.out.println("No. of elements in Array :- ");
		int noOfElements = sc.nextInt();
		
		//Creating array and inputting elements
		int[] array = new int[noOfElements];
		System.out.println("Enter elements of Array :- ");
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		//Solution function call
		System.out.println("Odd occuring element in array is :- "+solution(array));
		sc.close();
	}
}