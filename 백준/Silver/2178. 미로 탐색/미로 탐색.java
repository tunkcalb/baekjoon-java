import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	public int row, col, cnt;
	
	public Point(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}
	
}

public class Main {
	
	private static int[][] board;
	private static int N;
	private static int M;
	
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][M+1];
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i + 1][j + 1] = line.charAt(j) - '0';
			}
		}
	
		bfs(1,1,1);
		
	}

	
	private static void bfs(int row, int col,int cnt) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(row,col,cnt));
		board[row][col] = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0; i < dr.length; i++) {
				int nrow = p.row + dr[i];
				int ncol = p.col + dc[i];
				
				if(nrow > 0 && nrow <= N && ncol > 0 && ncol <= M && board[nrow][ncol] == 1) {
					if(nrow == N && ncol == M) {
						System.out.println(p.cnt + 1);
					}
					board[nrow][ncol] = 0;
					queue.offer(new Point(nrow,ncol,p.cnt+1));
				}
			}
		}
	}

}