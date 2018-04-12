package boj1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		ArrayList<Voca> arraylist = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			arraylist.add(new Voca(br.readLine()));
		}
		
		Collections.sort(arraylist);

		String tmp = "";
		for (Voca voca : arraylist) {
			if(tmp.equals(voca.str))
				continue;
			System.out.println(voca.str);
			tmp = voca.str;
		}
	}
}

class Voca implements Comparable<Voca> {
	String str;

	Voca(String str) {
		this.str = str;
	}

	@Override
	public int compareTo(Voca voca) {

		if (this.str.length() < voca.str.length())
			return -1;
		else if (this.str.length() == voca.str.length()) {
			if (this.str.compareTo(voca.str) < 0)
				return -2;
			return 4;
		}
		return 5;
	}
}