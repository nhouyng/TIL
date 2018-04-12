package tmp.boj12791;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String tmp = "1967 DavidBowie\r\n" + 
				"1969 SpaceOddity\r\n" + 
				"1970 TheManWhoSoldTheWorld\r\n" + 
				"1971 HunkyDory\r\n" + 
				"1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars\r\n" + 
				"1973 AladdinSane\r\n" + 
				"1973 PinUps\r\n" + 
				"1974 DiamondDogs\r\n" + 
				"1975 YoungAmericans\r\n" + 
				"1976 StationToStation\r\n" + 
				"1977 Low\r\n" + 
				"1977 Heroes\r\n" + 
				"1979 Lodger\r\n" + 
				"1980 ScaryMonstersAndSuperCreeps\r\n" + 
				"1983 LetsDance\r\n" + 
				"1984 Tonight\r\n" + 
				"1987 NeverLetMeDown\r\n" + 
				"1993 BlackTieWhiteNoise\r\n" + 
				"1995 1.Outside\r\n" + 
				"1997 Earthling\r\n" + 
				"1999 Hours\r\n" + 
				"2002 Heathen\r\n" + 
				"2003 Reality\r\n" + 
				"2013 TheNextDay\r\n" + 
				"2016 BlackStar";
		String[] spl = new String[25]; 
		spl = tmp.split("\r\n");
		
		int n = Integer.parseInt(st.nextToken());
		while(n > 0) {
			n--;
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ArrayList<String> arrayList = new ArrayList<>();
			for(int i=0;i<spl.length;i++) {
				if(Integer.parseInt(spl[i].substring(0, 4)) >= s) {
					int j = i;
					while(j<25 && Integer.parseInt(spl[j].substring(0, 4)) <= e) {
						arrayList.add(spl[j]);
						j++;
					}
					break;
				}
			}
			System.out.println(arrayList.size());
			for(String str : arrayList)
				System.out.println(str);
		}
	}
}