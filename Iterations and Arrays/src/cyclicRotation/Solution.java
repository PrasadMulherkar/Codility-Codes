package cyclicRotation;
import java.util.Scanner;

public class Solution {
	
	//Function to print array
	public static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}
	}
	
	//Function to apply the rotation
	public static int[] solution(int[] array, int k) {
		int lastElement;
		if(array.length > 1) {
			//For loop to rotate the array by given no. of rotations
			for(int i=0; i<k; i++) {
				//Array rotation algorithm
				lastElement = array[array.length-1];
				for(int j=array.length-1; j>0; j--) {
					array[j] = array[j-1];
				}
				array[0] = lastElement;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Input no. of elements in array 
		System.out.println("Enter no. of elements in array :- ");
		int noOfElements = sc.nextInt();
		
		//Creation of array with input no. of elements and inputing elements of array
		int[] array = new int[noOfElements];
		System.out.println("Enter array elements :- ");
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}

		//Printing array before Rotation
		System.out.println("Initial Array :- ");
		printArray(array);
		
		//Enter no. of Rotation
		System.out.println("\nEnter no. of Rotations :- ");
		int noOfRotations = sc.nextInt();
		//Stores the rotated array by given no. of rotations
		array = solution(array, noOfRotations);
		
		//Printing array after Rotation
		System.out.println("Rotated Array :- ");
		printArray(array);
		
		sc.close();
	}
}