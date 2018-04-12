package bfs.boj2234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int n, m, cnt, max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
	public static int[][] mat;
	public static int[][] vis;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int[] wall = { 4, 1, 8, 2 };
	public static ArrayList<Pos> arrayList;
	public static HashMap<Integer, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		mat = new int[m][n];
		vis = new int[m][n];
		arrayList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				mat[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();
		checkSum();
		System.out.println(cnt);
		System.out.println(max);
		System.out.println(max2);
	}

	public static void bfs() {
		Queue<Pos> que = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (vis[i][j] == 0) {
					int size = 1;
					cnt++;
					vis[i][j] = cnt;
					que.add(new Pos(i, j));

					while (!que.isEmpty()) {
						Pos tmp = que.poll();

						for (int t = 0; t < 4; t++) {
							int tx = tmp.x + dx[t];
							int ty = tmp.y + dy[t];
							if (isAvail(tx, ty) && vis[tx][ty]==0) {
								if (isAvail2(tmp.x, tmp.y, wall[t])) {
									vis[tx][ty] = cnt;
									que.add(new Pos(tx, ty));
									size++;
								}
							}
						}
						hashMap.put(cnt, size);
						max = max > size ? max : size;
					}
				}
			}
		}
	}

	public static void checkSum() {
		
		for(Pos p : arrayList) {
			for(int i=0;i<4;i++) {
				if(p.w == wall[i]) {
					int tx = p.x + dx[i];
					int ty = p.y + dy[i];
					if(vis[p.x][p.y] != vis[tx][ty]) {
						int sum = hashMap.get(vis[p.x][p.y]) + hashMap.get(vis[tx][ty]);
						max2 = max2 > sum ? max2 : sum;
					}
				}
			}
		}
	}

	public static boolean isAvail(int x, int y) {
		if (x >= 0 && x < m && y >= 0 && y < n)
			return true;
		return false;
	}

	public static boolean isAvail2(int x, int y, int w) {
		if ((mat[x][y] | w) == mat[x][y]) {
			arrayList.add(new Pos(x, y, w));
			return false;
		}
		return true;
	}
}

class Pos {
	int x;
	int y;
	int w;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}
