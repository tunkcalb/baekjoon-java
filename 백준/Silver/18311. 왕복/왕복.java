import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		int[] nums = new int[N + 1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		long length = 0;
		for(int i = 1; i <= N; i++) {
			length += nums[i];
			if(length > K) {
				ans = i;
				break;
			}
		}
		
		if(ans == 0) {
			for(int i = N; i >= 1; i--) {
				length += nums[i];
				if(length > K) {
					ans = i;
					break;
				}
			}			
		}
		System.out.println(ans);
	}
}
