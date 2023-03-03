import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int R, C, T;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int[][] board;
	static List<Integer> airCleaner = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == -1) {
					airCleaner.add(i);
				}
			}
		}	
		
		solution();
		System.out.println(calsum());
	}

	private static void solution() {
		for(int i = 0; i < T; i++) {
			board = spreadDust();
			
			runAirCleaner();
		}
	}

	

	private static int[][] spreadDust() {
		int[][] temp = new int[50][50];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(board[r][c] == -1) {
					temp[r][c] = -1;
					continue;
				}
				temp[r][c] += board[r][c];
				
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
				
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(board[nr][nc] == -1) continue;
					temp[nr][nc] += (board[r][c] / 5);
					temp[r][c] -= (board[r][c] / 5);
					
				}
			}
		}
		return temp;
	}
	private static void runAirCleaner() {
		int top = airCleaner.get(0);
		
		for(int i = top - 1; 0 < i; i--) {
			board[i][0] = board[i - 1][0];
		}
		
		for(int i = 0; i < C - 1; i++) {
			board[0][i] = board[0][i + 1];
		}
		
		for(int i = 0; i < top; i++) {
			board[i][C - 1] = board[i + 1][C - 1];
		}
		
		for(int i = C - 1; i > 1; i--) {
			board[top][i] = board[top][i - 1];
		}
		board[top][1] = 0;
		
		int bottom = airCleaner.get(1);
		
		for(int i = bottom + 1; i < R - 1; i++) {
			board[i][0] = board[i + 1][0];
		}
		
		for(int i = 0; i < C - 1; i++) {
			board[R - 1][i] = board[R - 1][i + 1];
		}
		
		for(int i = R - 1; i > bottom; i--) {
			board[i][C - 1] = board[i - 1][C - 1];
		}
		
		for(int i = C - 1; i > 1; i--) {
			board[bottom][i] = board[bottom][i - 1];
		}
		
		board[bottom][1] = 0;
	}
	private static int calsum() {
		int sum = 2;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += board[i][j];
			}
		}
		
		return sum;
	}
}