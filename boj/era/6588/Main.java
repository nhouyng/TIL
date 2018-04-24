package era.boj6588;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] era = new int[1000001];
		for (int i = 2; i <= 1000000; i++)
			era[i] = i;
		for (int i = 2; i <= 1000000; i++) {
			if (era[i] == 0)
				continue;
			for (int j = i * 2; j <= 1000000; j += i) {
				era[j] = 0;
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int a = 0;
			int b = 0;
			loop: for (int i = 3; i <= (n / 2); i += 2) {
				if (era[i] == 0)
					continue;

				int k = n;
				if (k % 2 == 0)
					k -= 1;
				for (int j = k; j >= (n / 2); j -= 2) {
					if (era[i] + era[j] == n) {
						a = i;
						b = j;
						break loop;
					}
				}
			}

			if (a == 0 && b == 0)
				System.out.println("Goldbach's conjecture is wrong.");
			else
				System.out.println(n + " = " + a + " + " + b);
		}
	}
}
