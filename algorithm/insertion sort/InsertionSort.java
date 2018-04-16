package insertion_sort;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		for (int n : arr)
			System.out.print("[" + n + "]");
		System.out.println();

		arr = insertionSort(arr);

		for (int n : arr)
			System.out.print("[" + n + "]");
		System.out.println();
	}

	public static int[] insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int index = i;
			
			while(index > 0 && value < arr[index-1]) {
				arr[index] = arr[index-1];
				index--;
			}
			arr[index] = value;
		}

		return arr;
	}
}
