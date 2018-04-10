package sort.boj11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		ArrayList<Pos> arrayList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arrayList.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arrayList);
		for (Pos pos : arrayList) {
			System.out.println(pos.x + " " + pos.y);
		}
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
		if (this.y < pos.y)
			return -3;
		else if (this.y == pos.y) {
			if (this.x < pos.x) {
				return -1;
			}
			return 1;
		}
		return 3;
	}
}