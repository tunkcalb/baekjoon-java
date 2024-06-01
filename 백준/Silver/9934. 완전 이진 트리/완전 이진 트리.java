import java.io.*;
import java.util.*;

public class Main {

	static Queue<Integer> q;
	static int K;
	static int size;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(in.readLine());
		q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());

		size = (int) Math.pow(2, K) - 1;
		
		for (int i = 0; i < size; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
		}
		nums = new int[size + 1];
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		for(int i = 0; i < K; i++) {
			int nodeSize = (int) Math.pow(2, i);
			for(int j = 0; j < nodeSize; j++) {
				sb.append(nums[idx++]);
				if(j != nodeSize - 1) sb.append(" ");
			}
			if(i != K - 1) sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int idx) {
		if(idx > size) return;
		dfs(idx * 2);
		nums[idx] = q.poll();
		dfs(idx * 2 + 1);
	}
}
