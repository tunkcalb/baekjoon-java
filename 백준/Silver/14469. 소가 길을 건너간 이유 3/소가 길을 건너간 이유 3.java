import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] cows = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cows, (o1, o2) -> o1[0] - o2[0]);
		
		int time = 0;
		
		for(int[] cow : cows) {
			if(time < cow[0]) {
				time = cow[0];
			}
			time += cow[1];
		}
		System.out.println(time);
	}
}
