import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[S1 + S2 + S3 - 2];
		
		for(int i = 1; i <= S1; i++) {
			for(int j = 1; j <= S2; j++) {
				for(int k = 1; k <= S3; k++) {
					nums[i + j + k - 3]++;
				}
			}
		}
		
		int max = 0;
		int num = 0;
		for(int i = 0; i < nums.length; i++) {
			if(max < nums[i]) {
				max = nums[i];
				num = i + 3;
			}
		}
		
		System.out.println(num);
	}
}
