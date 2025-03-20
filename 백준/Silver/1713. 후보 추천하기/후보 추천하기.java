import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] cnts = new int[N][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		vote : for(int i = 1; i <= M; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			for(int[] cnt : cnts) {
				if(cnt[0] == n) {
					cnt[1]++;
					continue vote;
				}
			}
			Arrays.sort(cnts, (o1, o2) -> {
				if(o1[1] == o2[1]) {
					return o1[2] - o2[2];
				}
				else return o1[1] - o2[1];
			});
			cnts[0][0] = n;
			cnts[0][1] = 1;
			cnts[0][2] = i;
		}
		
		Arrays.sort(cnts, (o1, o2) -> o1[0] - o2[0]);
		
		StringBuilder sb = new StringBuilder();
		
		for(int[] cnt : cnts) {
			if(cnt[0] == 0) continue;
			sb.append(cnt[0]).append(" ");
		}
		System.out.println(sb);
	}
}
