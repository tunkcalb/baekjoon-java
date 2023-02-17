import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int houselength;
	private static int temp;
	private static int totallength;
	
	private static boolean[] isSelected;
	private static ArrayList<Integer[]> house = new ArrayList<Integer[]>();
	private static ArrayList<Integer[]> chicken = new ArrayList<Integer[]>();
	
	public static void main(String[] args) throws Exception {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					house.add(new Integer[] {i,j});					
				}
				else if(num == 2) {
					chicken.add(new Integer[] {i,j});
				}
			}
		}
		totallength = Integer.MAX_VALUE;
		isSelected = new boolean[chicken.size()];
		permutation(0,0);
		
		System.out.println(totallength);
	}

	private static void permutation(int cnt, int start) {
		if (cnt == M) {
			chickenlen();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			isSelected[i] = true;
			permutation(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	private static void chickenlen() {
		
		temp = 0;
		for(int i = 0; i < house.size(); i++) {
			houselength = Integer.MAX_VALUE;
			int row = house.get(i)[0];
			int col = house.get(i)[1];
			
			for(int j = 0; j < chicken.size(); j++) {
				if(isSelected[j] == true) {
					if (houselength == 1) break;
					houselength = Math.min(houselength,Math.abs(row - chicken.get(j)[0]) + Math.abs(col - chicken.get(j)[1]));
				}
			}
			temp += houselength;
		}
		if(temp < totallength) totallength = temp;
	}
}