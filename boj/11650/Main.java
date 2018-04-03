package boj11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		ArrayList<Pos> arraylist = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			arraylist.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arraylist);

		for (Pos pos : arraylist)
			System.out.println(pos.x + " " + pos.y);
	}
}

class Pos implements Comparable<Pos> {

	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos pos) {
		if (this.x < pos.x) {
			return -1;
		} else if (this.x == pos.x) {
			if (this.y < pos.y) {
				return -2;
			} else
				return 3;
		}
		return 5;
	}

}