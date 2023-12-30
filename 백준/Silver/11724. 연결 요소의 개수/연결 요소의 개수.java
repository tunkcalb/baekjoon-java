import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] check;
	static boolean[] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new int[1001][1001];
		visited = new boolean[1001];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			check[u][v] = check[v][u] = 1;
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		for(int i = 1; i <= N; i++) {
			if(check[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
