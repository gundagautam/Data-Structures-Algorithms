/**
 * 
 */
package com.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Gautam
 *
 */
public class PairWithGivenSum {

	/**
	 * 
	 * Given an unsorted array of integers, find a pair with given sum in it.
	 * Ex: 
	 * Input:
	 * arr = [8, 7, 2, 5, 3, 1], sum = 10
	 * 
	 * Output:
	 * Pair found at index 0 and 2 (8 + 2)
	 * or
	 * Pair found at index 1 and 4 (7 + 3)
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,7,2,5,3,1};
		int sum = 10;
		boolean found = false;
		
		/*
		 * Approach 1: Naive Approach
		 * Big O = O(n^2)
		 */
		System.out.println("Approach 1:");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum) {
					System.out.println("Pair found at index "+i+" and "+j+" ("+arr[i]+","+arr[j]+")");
					found = true;
				}
			}
		}
		
		if(!found) {
			System.out.println("No possible solution");
		}
		
		/*
		 * Approach 2: Better Solution
		 * Big O = O(nlogn)
		 */
		System.out.println("Approach 2:");
		found = false;
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length-1;
		while(low<high) {
			int subSum = arr[low]+arr[high];
			if(subSum==sum) {
				System.out.println("Pair found at index "+low+" and "+high+" ("+arr[low]+","+arr[high]+")");
				found = true;
				low++;
				high--;
			}else if(subSum>sum) {
				high--;
			}else if(subSum<sum) {
				low++;
			}
		}
		if(!found) {
			System.out.println("No possible solution");
		}
		
		/*
		 * Approach 3: Best Solution as this is Integers
		 * Big O = O(n)
		 */
		System.out.println("Approach 3:");
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hmap.containsKey(sum-arr[i])) {
				System.out.println("Pair found at index "+hmap.get(sum-arr[i])+" and "+i+" ("+(sum-arr[i])+","+arr[i]+")");
				found=true;
			}
			hmap.put(arr[i], i);
		}
		if(!found) {
			System.out.println("No possible solution");
		}
		
	}
	

}
