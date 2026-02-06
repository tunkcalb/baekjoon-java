import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sum = 1;
		int pre = 1;
		
		for(int i = N - 2; i >= 0; i--) {
			if(pre < nums[i]) {
				pre++;
			}
			else pre = nums[i];
			
			sum += pre;
		}
		
		System.out.println(sum);
	}
}
