import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<int[]>[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new List[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[x][y].add(new int[] {a, b});
		}
		
		int cnt = bfs();
		
		System.out.println(cnt);
	}

	private static int bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 1});
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[1][1] = true;
		boolean[][] lightOn = new boolean[N + 1][N + 1];
		lightOn[1][1] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			
			for(int[] light : board[r][c]) {
				int row = light[0];
				int col = light[1];
				if(lightOn[row][col]) continue;
				lightOn[row][col] = true;
				for(int i = 0 ;i < 4; i++) {
					int nRow = row + dr[i];
					int nCol = col + dc[i];
					if(nRow <= 0 || nRow > N || nCol <= 0 || nCol > N) continue;
					if(visited[nRow][nCol]) {
						visited[row][col] = true;
						q.offer(new int[] {row, col});
					}
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr <= 0 || nr > N || nc <= 0 || nc > N) continue;
				if(visited[nr][nc]) continue;
				if(!lightOn[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[]{nr, nc});
			}
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(lightOn[i][j]) cnt++;
			}
		}
		
		
		
		return cnt;
	}
}
