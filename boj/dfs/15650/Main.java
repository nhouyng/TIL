package dfs.boj15650;

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

		dfs(0,1,n,m);
		System.out.println(sb);
	}

	public static void dfs(int depth, int startIndex, int n, int m) {

		if (depth == m) {
			for (int num : stack)
				sb.append(num + " ");
			sb.append("\n");
			return ;
		}
		
		for(int i=startIndex;i<=n;i++) {
			stack.push(i);
			dfs(depth+1, i+1, n, m);
			stack.pop();
		}
	}
}
