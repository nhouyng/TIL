package sort.boj5598;
// tc = O(n)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i)-3;
			if(tmp < 'A')
				System.out.printf("%c",'Z'-('A'-tmp)+1);
			else
				System.out.printf("%c",tmp);
		}
	}
}
