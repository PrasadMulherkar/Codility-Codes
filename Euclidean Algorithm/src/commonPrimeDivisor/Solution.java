package commonPrimeDivisor;

import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	//Function to take input in array
	public static int[] inputArray(int[] a) {
		System.out.println("Enter elements :- ");
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}
	
	//Solution function that counts the no. of common prime divisor
	public static int solution(int[] a, int[] b) {
        int count = 0;
        for(int i=0; i<a.length; i++) {
            if(hasSamePrimeDivisors(a[i], b[i])){
                count++;    
            } 
        }
        return count;
    }
	
	//Function to check the equality of prime divisors
	public static boolean hasSamePrimeDivisors(int a, int b) {
		//First find gcd of given no.s
	    int gcdValue = gcd(a,b); // a = 15 b = 75, gcdValue = 15
	    
	    //Second find gcd of given no.s with gcdValue
        int gcdA;
        int gcdB;
        
        while(a!=1) {
            gcdA = gcd(a,gcdValue);   // a = 15  gcdValue = 15 gcdA = 15
            if(gcdA==1)
                break;
            a = a/gcdA;  //a=1
        }
        
        while(b!=1) {
            gcdB = gcd(b,gcdValue);  // b = 75 gcdValue = 15 gcdB = 15
            //b = 3 gcdValue = 15 gcdB = 3
            if(gcdB==1)
                break;
            b = b/gcdB;    // b = 3
            //b = 3/3 = 1
        }
        
        if(a != 1 || b != 1) {
        	return false;
        }
        else {
        	return true;
        }        
	}
	
	public static int gcd(int a, int b) {
	    if(a % b == 0) {
	    	return b;
	    }
	    else {
	    	return gcd(b, a%b);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println("Enter no. of elements in array :- ");
		int z = sc.nextInt();
		int a[] = new int[z];
		int b[] = new int[z];
		
		a = inputArray(a);
		b = inputArray(b);
		
		int K = solution(a, b);
		System.out.println("No. of common prime divisors :- "+K);
		sc.close();
	}
}
