import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int N = 'z' - 'a' + 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			nums = new int[N];
			String line = br.readLine();
			
			for(int i = 0; i < N; i++) {
				nums[i] = 'A' + i;
			}
			
			for(int i = 0; i < line.length(); i++) {
				int now = line.charAt(i) - 'A';
				nums[now] = 0;
			}
			
			int sum = 0;
			
			for(int num : nums) {
				sum += num;
			}
			System.out.println(sum);
		}
	}
}
