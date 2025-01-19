import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		List<Snowman> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				int start = j;
				int end = i;
				int sum = nums[i] - nums[j];
				
				list.add(new Snowman(start, end, sum));
			}
		}
		
		Collections.sort(list, (o1, o2) -> o1.sum - o2.sum);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < list.size() - 1; i ++) {
			Snowman first = list.get(i);
			Snowman second = list.get(i + 1);
			if(min > second.sum - first.sum) {
				if(first.start == second.start || first.start == second.end || first.end == second.start || first.end == second.end) continue;
				min = second.sum - first.sum;
				if(min == 0) break;
			}
		}
		System.out.println(min);
	}
	
	static class Snowman {
		int start;
		int end;
		int sum;
		
		Snowman(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}
}
