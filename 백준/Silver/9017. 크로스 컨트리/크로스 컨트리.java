import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int[] nums = new int[N];
			
			HashMap<Integer, Integer> cnt = new HashMap<>();
			for(int i = 0; i < N; i++) {
				int key = Integer.parseInt(st.nextToken());
				nums[i] = key;
				cnt.put(key, cnt.getOrDefault(key, 0) + 1);
			}
		
			HashMap<Integer, Integer> sum = new HashMap<>();
			HashMap<Integer, Integer> count = new HashMap<>();
			HashMap<Integer, Integer> five = new HashMap<>();
			
			int idx = 1;
			
			for(int num : nums) {
				int cntNum = cnt.get(num);
				if(cntNum < 6) continue;
				count.put(num, count.getOrDefault(num, 0) + 1);
				if(count.get(num) <= 4) sum.put(num, sum.getOrDefault(num, 0) + idx);
				if(count.get(num).equals(5)) five.put(num, idx);
				idx++;
			}
			
			int result = Integer.MAX_VALUE;
			int winner = Integer.MAX_VALUE;
			
			for(int key : sum.keySet()) {
				int score = sum.get(key);
				if(score < result) {
					result = score;
					winner = key;
				}
				else if(score == result) {
					if(Integer.compare(five.get(key), five.get(winner)) < 0) winner = key;
				}
			}
			if(t == T - 1) sb.append(winner);
			else sb.append(winner).append("\n");
		}
		System.out.println(sb);
	}
}
