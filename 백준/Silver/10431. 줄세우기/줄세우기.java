import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 20;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			int cnt = 0;
			int[] nums = new int[N];
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < i; j++) {
					if(nums[j] > nums[i]) cnt++;
				}
			}
			
			sb.append(t).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
