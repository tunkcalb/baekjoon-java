import java.io.*;
import java.util.*;

public class Main {
	
	static int N = 25;
	static int M = 5;
	static int ans;
	static boolean[] visited;
	static int[] princess = new int[7];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[M][M];
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		ans = 0;
		comb(0, 0, 0);
		System.out.println(ans);
		
	}

	private static void comb(int cnt, int idx, int dasom) {
		if(cnt - dasom > 3) return;
		
		if(cnt == 7) {
			visited = new boolean[7];
			bfs(princess[0] / 5, princess[0] % 5);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			int row = i / 5;
			int col = i % 5;
			princess[cnt] = i;
			comb(cnt + 1, i + 1, (board[row][col] == 'S') ? dasom + 1 : dasom);
		}
	}

	private static void bfs(int row, int col) {
		int cnt = 1;
		visited[0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= M) continue;
				int next = M * nr + nc;
				for(int k = 0; k < 7; k++) {
					if(!visited[k] && princess[k] == next) {
						visited[k] = true;
						cnt++;
						q.offer(new int[] {nr, nc});
					}
				}
			}
		}
		
		if(cnt == 7) ans++;
	}
}
