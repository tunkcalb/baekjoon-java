import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			int high = nums[i];
			
			for(int j = i + 1; j < N; j++) {
				if(high < nums[j]) break;
				else cnt++;
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
