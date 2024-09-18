import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int ans = n + 1;
		for(int i = 1; i <= n; i++) {
			if(nums[i] != i) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
