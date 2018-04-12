package sort.boj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String bomb = br.readLine();
		while(true) {
			String tmp = str.replaceAll(bomb, "");
			if(tmp.equals(str)) break;
			str = tmp;
		}
		if(str.equals(""))
			System.out.println("FRULA");
		else
			System.out.println(str);
	}
}
