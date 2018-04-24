package era.boj9020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = 10001;
		int[] arr = new int[size];
		for (int i = 2; i < size; i++)
			arr[i] = i;
		for (int i = 2; i < size; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j < size; j += i)
				arr[j] = 0;
		}

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int a = 0, b = 0;
			for(int i=2;i<=(n/2);i++) {
				if(arr[i] == 0) continue; 
				for(int j=n;j>=(n/2);j--) {
					if(arr[i] + arr[j] == n) {
						a = i;
						b = j;
						break;
					}
				}
			}
			
			System.out.println(a+" "+b);
		}
	}
}
