import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int start = 0;
	static int INF = Integer.MAX_VALUE / 100;
	static int[][] board;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		board = new int[N][N];
		DP = new int[1 << N][N];
		
		for(int i = 0;i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 1 << N; i++) {
			Arrays.fill(DP[i], -1);
		}
		
		int min = tsp(1, start);
		
		System.out.println(min);
	}

	private static int tsp(int visited, int city) {
		if(visited == (1 << N) - 1) {
			if(board[city][start] == 0) return INF;
			return board[city][start];
		}
		
		if(DP[visited][city] != -1) {
			return DP[visited][city];
		}
		
		DP[visited][city] = INF;
		for(int i = 1; i < N; i++) {
			if((visited & (1 << i)) != 0) continue;
			if(board[city][i] == 0) continue;
		
			int res = tsp(visited | (1 << i), i) + board[city][i];
			
			DP[visited][city] = Math.min(res, DP[visited][city]);
		}
		return DP[visited][city];
		
		
		
		
	}
}