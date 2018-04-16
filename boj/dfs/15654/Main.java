package dfs.boj15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	public static Stack<Integer> stack = new Stack<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0, n, m, new boolean[n + 1]);
		System.out.println(sb);
	}

	public static void dfs(int depth, int n, int m, boolean[] k) {

		if (depth == m) {
			for (int num : stack)
				sb.append(num + " ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!k[i]) {
				stack.push(arr[i]);
				k[i] = true;
				dfs(depth + 1, n, m, k);
				stack.pop();
				k[i] = false;
			}
		}
	}
}
