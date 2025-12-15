import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int start = 0;
		int end = 0;
		int[] cnt = new int[100000 + 1];
		while(end < nums.length) {
			while(end < nums.length && cnt[nums[end]] + 1 <= K) {
				cnt[nums[end]]++;
				end++;
			}
			int len = end - start;
			ans = Math.max(ans,  len);
			cnt[nums[start]]--;
			start++;
		}
		System.out.println(ans);
	}
}
