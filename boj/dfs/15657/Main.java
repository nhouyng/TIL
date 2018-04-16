package dfs.boj15657;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	public static int[] arr;
	public static Stack<Integer> stack = new Stack<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		dfs(0, 0, n, m);
		System.out.println(sb);
	}

	public static void dfs(int depth, int lastSelected, int n, int m) {

		if (depth == m) {
			for (int num : stack)
				sb.append(arr[num] + " ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (i >= lastSelected) {
				stack.push(i);
				dfs(depth + 1, i, n, m);
				stack.pop();
			}
		}
	}
}
