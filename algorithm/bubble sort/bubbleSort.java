package bubble_sort;

import java.util.Scanner;

public class bubbleSort {

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

		arr = bubbleSort(arr);

		for (int n : arr)
			System.out.print("[" + n + "]");
		System.out.println();
	}

	public static int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}

		return arr;
	}
}
