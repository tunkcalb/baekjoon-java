import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int size;
	static int[][] board;
	static int[][] flow;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		size = 52;
		board = new int[size][size];
		flow = new int[size][size];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = toIndex(st.nextToken().charAt(0));
			int to = toIndex(st.nextToken().charAt(0));
			int flux = Integer.parseInt(st.nextToken());
			board[from][to] += flux;
			board[to][from] += flux;
		}
		
		int ans = flow(0, 25);
		System.out.println(ans);
	}
	
	private static int flow(int from, int to) {
		
		int sum = 0;
		int[] parent = new int[size];
		Queue<Integer> q;
		while(true) {
			Arrays.fill(parent,-1);
			q = new LinkedList<>();
			
			parent[from] = from;
			q.add(from);
			
			while(!q.isEmpty() && parent[to] == -1) {
				int now = q.poll();
				for(int i = 0; i < size; i++) {
					if(board[now][i] - flow[now][i] > 0 && parent[i] == -1) {
						q.add(i);
						parent[i] = now;
					}
				}
			}
			if(parent[to] == -1) break;
			
			int amount = Integer.MAX_VALUE;
			for(int i = to; i != from; i = parent[i]) {
				amount = Math.min(board[parent[i]][i] - flow[parent[i]][i], amount);
			}
			for(int i = to; i != from; i = parent[i]) {
				flow[parent[i]][i] += amount;
				flow[i][parent[i]] -= amount;
			}
			
			sum += amount;
		}
		return sum;
	}
	
	static int toIndex(char c) {
		if('A' <= c && c <= 'Z') {
			return c - 'A';
		} else if('a' <= c && c <= 'z') {
			return c - 'A' - 6;
		}
		return -1;
	}

}
