import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			int n = st.countTokens();
			if(n == 1) break;
			int[] nums = new int[n - 1];
			
			for(int i = 0; i < n - 1; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			int cnt = 0;
			for(int i = 0; i < n - 2; i++) {
				int num = nums[i] * 2;
				for(int j = i + 1; j < n - 1; j++) {
					if(num == nums[j]) {
						cnt++;
						break;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
