import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[D + 1];
		
		for(int i = 1; i <= D; i++) {
			nums[i] = i;
		}

		Cost[] costs = new Cost[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			costs[i] = new Cost(start, end, cost);
		}
		
		for(int i = 1; i <= D; i++) {
			
			nums[i] = Math.min(nums[i], nums[i - 1] + 1);
			

			for(Cost now : costs) {
				int start = now.start;
				int end = now.end;
				int cost = now.cost;
				
				if(end != i) continue;
				nums[end] = Math.min(nums[end], nums[start] + cost);
			}
			
		}
		
		System.out.println(nums[D]);
		
	}
	
	static class Cost {
		int start;
		int end;
		int cost;
		
		Cost(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}
