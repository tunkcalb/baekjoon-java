import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int buy = nums[0];
		for(int i = 1; i < N; i++) {
			int sell = nums[i];
			if(buy > sell) buy = sell;
			else max = Math.max(max, sell - buy);
		}
		
		System.out.println(max);
	}
}
