import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0 ;
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			cnt += nums[i];
		}
		
		int K = Integer.parseInt(br.readLine());
		
		double total = 1;
		
		for(int i = 0; i < K; i++) {
			total *= (cnt - i);
		}
		
		double sum = 0;
		for(int i = 0; i < M; i++) {
			if(nums[i] < K) continue;
			
			double tmp = 1;
			for(int j = 0; j < K; j++) {
				tmp *= nums[i] - j;
			}
			sum += tmp;
		}
		
		System.out.println(sum / total);
	}
}
