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
		
		int max = 0;
		int cnt = 0;
		for(int num : nums) {
			 max = Math.max(max, Integer.toBinaryString(num).length());
			
			 cnt += Integer.bitCount(num);
		}
		
		System.out.println(cnt + max - 1);
		
	}
}
