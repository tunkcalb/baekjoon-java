import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int A, B, N, M;
	static int[][] board;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Point[] location;
	
	static class Point{
		int x;
		int y;
		int dir;
		
		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[A + 1][B + 1];
		location = new Point[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			int d = 0;
			if(dir == 'E') d = 0;
			else if(dir == 'N') d = 1;
			else if (dir == 'W') d = 2;
			else if (dir == 'S') d = 3;
			
			location[i] = new Point(x,y,d);
			
			board[x][y] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int robotNum = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			
			int repNum = Integer.parseInt(st.nextToken());
			
			Point robot = location[robotNum];
			
			if(order == 'F') {
				int nx = robot.x;
				int ny = robot.y;
				int dir = robot.dir;
				for(int r = 0; r < repNum; r++) {
					nx += dx[dir];
					ny += dy[dir];
					
					if(nx <= 0 || ny <= 0 || nx > A || ny > B) {
						System.out.println("Robot "+ robotNum +" crashes into the wall");
						return;
					}
					
					if(board[nx][ny] != 0) {
						System.out.println("Robot "+ robotNum +" crashes into robot "+ board[nx][ny]);
						return;
					}
				}
				
				board[robot.x][robot.y]= 0;
				location[robotNum] = new Point(nx, ny, dir);
				board[nx][ny] = robotNum;
				
			}else if(order == 'L' || order == 'R') {
				int newDir = robot.dir;
				for(int r= 0; r < repNum; r++) {
					if(order == 'L') {
						newDir += 1;
						newDir %= 4;
					}
					if(order == 'R') {
						newDir -= 1;
						if(newDir < 0) newDir += 4;
					}
				}
				
				location[robotNum] = new Point(robot.x, robot.y, newDir);
			}
			
		}
		System.out.println("OK");
		
	}
}