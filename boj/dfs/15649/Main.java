package dfs.boj15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static Stack<Integer> stack = new Stack<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

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
				stack.push(i);
				k[i] = true;
				dfs(depth + 1, n, m, k);
				stack.pop();
				k[i] = false;
			}
		}
	}
}
