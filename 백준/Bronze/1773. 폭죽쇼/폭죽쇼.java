import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[]  nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= C; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(i % nums[j] == 0) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
