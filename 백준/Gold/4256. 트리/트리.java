import java.io.*;
import java.util.*;

public class Main {
	
	static int[] pre;
	static int[] in;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			pre = new int[n + 1];
			in = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			postOrder(0, 0, n);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void postOrder(int root, int start, int end) {
		
		int val = pre[root];
		for(int i = start; i < end; i++) {
			if(in[i] == val) {
				postOrder(root + 1, start, i);
				postOrder(root + (i - start) + 1, i + 1, end);
				sb.append(val).append(" ");
				return;
			}
		}
	}
}
