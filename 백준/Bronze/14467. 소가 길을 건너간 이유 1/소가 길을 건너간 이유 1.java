import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N + 1];
		
		Arrays.fill(nums, -1);
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cow = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(nums[cow] == -1) {
				nums[cow] = idx;
				continue;
			}
			
			if(nums[cow] != idx) {
				nums[cow] = idx;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
