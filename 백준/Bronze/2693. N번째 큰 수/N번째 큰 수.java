import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int N = 10;
		Integer[] nums = new Integer[N];
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < N; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums,Collections.reverseOrder());
			System.out.println(nums[2]);
		}
		
	}
}
