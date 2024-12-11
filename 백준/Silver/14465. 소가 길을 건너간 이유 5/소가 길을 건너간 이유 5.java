import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] nums = new boolean[N + 1];

		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(in.readLine());
			nums[num] = true;
		}

		int start = 1;
		int end = K + 1;
		
		int cnt = 0;
		for(int i = start; i < end; i++) {
			if(nums[i]) cnt++;
		}
		
		int min = cnt;
		while(end <= N) {
			if(nums[start]) cnt--;
			if(nums[end]) cnt++;
			start++;
			end++;
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
