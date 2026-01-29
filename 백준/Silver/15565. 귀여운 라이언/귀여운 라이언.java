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
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int start = 0;
		int end = 0;
		int min = N + 1;
		while (end < N) {
		    if (nums[end] == 1) cnt++;

		    while (cnt >= K) {
		        min = Math.min(min, end - start + 1);
		        if (nums[start] == 1) cnt--;
		        start++;
		    }
		    end++;
		}

		if(min == N + 1) min = -1;
		System.out.println(min);
	}
}
