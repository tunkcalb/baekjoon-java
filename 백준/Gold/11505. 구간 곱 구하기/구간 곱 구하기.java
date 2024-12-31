import java.io.*;
import java.util.*;

public class Main {
	
	static int mod = 1000000007;
	static long[] tree, nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		nums = new long[N + 1];
		for(int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(in.readLine());
		}
		
		tree= new long[N * 4];
		
		init(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				nums[b] = c;
				update(1, N, 1, b, c);
			}
			else {
				sb.append(cal(1, N, 1, b, (int) c)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static long cal(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return 1;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		
		return (cal(start, mid, node * 2, left, right) * cal(mid + 1, end, node * 2 + 1, left, right)) % mod;
	}

	private static long update(int start, int end, int node, int idx, long val) {
		if(idx < start || idx > end) {
			return tree[node];
		}
		
		if(start == end) {
			return tree[node] = val;
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % mod;
	}

	private static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = nums[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % mod;
	}
}
