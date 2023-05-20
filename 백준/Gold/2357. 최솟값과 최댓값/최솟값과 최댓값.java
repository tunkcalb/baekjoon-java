import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] num;
	static int[] maxTree;
	static int[] minTree;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N + 1];
		maxTree = new int[N * 4];
		minTree = new int[N * 4];
		
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		minInit(1, N ,1);
		maxInit(1, N, 1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			sb.append(minFind(1, N, 1, left, right) + " " + maxFind(1, N, 1, left, right) + "\n");
		}
		
		System.out.println(sb);
	}

	private static int maxFind(int start, int end, int leaf, int left, int right) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return maxTree[leaf];
		}
		
		int mid = (start + end) / 2;
		
		return Math.max(maxFind(start, mid, leaf * 2, left, right), maxFind(mid + 1, end, leaf * 2 + 1, left, right));
	}

	private static int minFind(int start, int end, int leaf, int left, int right) {
		
		if(right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && end <= right) {
			return minTree[leaf];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(minFind(start, mid, leaf * 2, left, right), minFind(mid + 1, end, leaf * 2 + 1, left, right));
		
	}

	private static int maxInit(int start, int end, int leaf) {
		
		if (start == end) {
			return maxTree[leaf] = num[start];
		}
		
		int mid = (start + end) / 2;
		
		return maxTree[leaf] = Math.max(maxInit(start, mid, leaf * 2), maxInit(mid + 1, end, leaf * 2 + 1));
	}

	private static int minInit(int start, int end, int leaf) {
		
		if(start == end) {
			return minTree[leaf] = num[start];
		}
		
		int mid = (start + end) / 2;
		
		return minTree[leaf] = Math.min(minInit(start, mid, leaf * 2), minInit(mid + 1, end, leaf * 2 + 1));
	}
}
