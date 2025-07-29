import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[4 + 1];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == 0 || y == 0) {
				cnt[0]++;
			} else if (x > 0) {
				if(y > 0) cnt[1]++;
				else cnt[4]++;
			}
			else {
				if(y > 0) cnt[2]++;
				else cnt[3]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 4; i++) {
			sb.append("Q").append(i).append(": ").append(cnt[i]).append("\n");
		}
		sb.append("AXIS: ").append(cnt[0]);
		
		System.out.println(sb);
	}
}
