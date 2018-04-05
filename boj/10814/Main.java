package boj10814;

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
		ArrayList<Person> arrayList = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			arrayList.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}

		Collections.sort(arrayList);
		for (Person p : arrayList) {
			System.out.println(p.age + " " + p.name);
		}

	}
}

class Person implements Comparable<Person> {

	int age;
	String name;
	int r;

	Person(int age, String name, int r) {
		this.age = age;
		this.name = name;
		this.r = r;
	}

	@Override
	public int compareTo(Person p) {

		if (this.age < p.age)
			return -3;
		else if (this.age == p.age) {
			if (this.r > p.r) {
				return 3;
			}
			return -1;
		}
		return 1;
	}

}