package selection_sort;

import java.util.Scanner;

public class SelectionSort {

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
		
		arr = selectionSort(arr);
		
		for (int n : arr)
			System.out.print("[" + n + "]");
	}

	public static int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int index = i;
			for (int j = i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}

			if (i != index) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}

		return arr;
	}
}
