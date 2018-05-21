package tmp.boj9324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		while (t-- > 0) {
			String str = br.readLine();

			int[] arr = new int[26];
			boolean flag = true;

			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 65;
				arr[idx]++;

				if (arr[idx] % 3 == 0) {
					if (i + 1 == str.length() || str.charAt(i) != str.charAt(i + 1)) {
						flag = false;
						break;
					}
					i += 1;
				}
			}

			if (flag)
				System.out.println("OK");
			else
				System.out.println("FAKE");
		}
	}
}
