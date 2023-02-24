import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int answer;
	private static boolean[] visited;
	private static List<Integer>[] board;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new ArrayList[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			board[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a].add(b);
			board[b].add(a);
		}
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			answer = relation(i, 0);
			visited[i] = false;
			
			if(answer == 1) break;
		}
		
		System.out.println(answer);
	}

	private static int relation(int start, int cnt) {
		if(cnt >= 4) return 1;
		
		for(int i : board[start]) {
			if(!visited[i]) {
				visited[i] = true;
				if(relation(i, cnt + 1) == 1) return 1;
				visited[i] = false;
			}
		}
		return 0;
	}
}