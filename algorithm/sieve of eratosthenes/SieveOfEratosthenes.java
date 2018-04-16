package sieve_of_eratosthenes;
/*
 * 1부터 n까지 소수를 구하는 코드
 */
import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] prime = new int[n + 1];

		for (int i = 2; i <= n; i++)
			prime[i] = i;
		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0)
				continue;
			for (int j = i * 2; j <= n; j += i) {
				prime[j] = 0;
			}
		}
	}
}
