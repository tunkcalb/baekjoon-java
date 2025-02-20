import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] cnt =  new int[2][6 + 1];
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			cnt[s][g]++;
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j <= 6; j++) {
				ans += cnt[i][j] / K;
				if(cnt[i][j] % K != 0) ans++;
			}
		}
		System.out.println(ans);
	}
}
