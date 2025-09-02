import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		double cut = 0.15;
		int m = (int) Math.round(n * cut);
		
		int sum = 0;
		for(int i = m; i < n - m; i++) {
			sum += nums[i];
		}
		
		System.out.println((int) Math.round((double) sum / (n - (2 * m))));
	}
}
