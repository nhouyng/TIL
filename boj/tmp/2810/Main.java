package tmp.boj2810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		
		int result = 1;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'S') result++;
			else if(s.charAt(i) == 'L') {
				i++;
				result++;
			}
		}
		
		if(result > n)
			System.out.println(n);
		else
			System.out.println(result);
	}
}
