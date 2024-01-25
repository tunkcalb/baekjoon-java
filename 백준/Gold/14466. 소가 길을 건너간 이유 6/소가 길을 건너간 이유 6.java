import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, R;
	static boolean[][] visited;
	static Point[] cows;
	static ArrayList<Point>[][] bridges;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		cows = new Point[K];
		bridges = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bridges[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			
			bridges[r][c].add(new Point(r1, c1));
			bridges[r1][c1].add(new Point(r,c));
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			cows[i] = new Point(r, c);
		}
		System.out.println(start());
	}

	private static int start() {
		int cnt = 0;
		
		for(int i = 0; i < K; i++) {
			visited = new boolean[N][N];
			move(cows[i].x, cows[i].y);
			
			for(int ni = i; ni < K; ni++) {
				Point cow = cows[ni];
				
				if(!visited[cow.x][cow.y]) cnt++; 
			}
		}
		return cnt;
	}

	private static void move(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(visited[nx][ny]) continue;
			
			if(bridges[x][y].contains(new Point(nx, ny))) continue;
			
			move(nx, ny);
		}
	}
}
