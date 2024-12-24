import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		List<Brick> list = new ArrayList<>();
		list.add(new Brick(0, 0, 0, 0));
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			list.add(new Brick(i, w, h, g));
		}
		
		Collections.sort(list);
		
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) {
				if(list.get(i).g > list.get(j).g) {
					dp[i] = Math.max(dp[i], dp[j] + list.get(i).h);
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		List<Integer> result = new ArrayList<>();
		
		for(int idx = N; idx > 0; idx--) {
			if(max == dp[idx]) {
				result.add(list.get(idx).idx);
				max -= list.get(idx).h;
			}
		}
		StringBuilder sb = new StringBuilder();
		int size = result.size();
		sb.append(size).append("\n");
		for(int i = size - 1; i >= 0; i--) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	
	static class Brick implements Comparable<Brick> {
		int idx;
		int w;
		int h;
		int g;

		Brick(int idx, int w, int h, int g) {
			this.idx = idx;
			this.w = w;
			this.h = h;
			this.g = g;
		}

		@Override
		public int compareTo(Brick o) {
			return w - o.w;
		}
	}
}
