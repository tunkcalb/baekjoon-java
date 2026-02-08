import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		int[] nums = new int[L + 1];
		int a = 0;
		int b = 0;
		int aMax = 0;
		int bMax = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(aMax < k - p + 1) {
				aMax = k - p + 1;
				a = i;
			}
			int cnt = 0;
			for(int j = p; j <= k; j++) {
				if(nums[j] == 0) {
					nums[j] = i;
					cnt++;
				}
			}
			if(bMax < cnt) {
				bMax = cnt;
				b = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a).append("\n").append(b);
		System.out.println(sb);
	}
}
