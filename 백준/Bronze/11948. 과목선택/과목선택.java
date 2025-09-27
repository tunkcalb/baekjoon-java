import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 4;
		Integer[] nums = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums, Collections.reverseOrder());

		int sum = 0;
		
		for(int i = 0; i < n - 1; i++) {
			int score = nums[i];
			
			sum += score;
		}
		int E = Integer.parseInt(br.readLine());
		int F  = Integer.parseInt(br.readLine());
		
		sum += E > F ? E : F;
		
		System.out.println(sum);
		
	}
}
