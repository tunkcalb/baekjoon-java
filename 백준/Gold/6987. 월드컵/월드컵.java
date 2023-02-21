import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int time;

	private static int[][] board;
	static int[] home = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] away = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	
	public static void main(String[] args) throws Exception {

		N = 6;
		M = 3;
		time = 4;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < time; i++) {
			int total = 0;
			board = new int[N][M];
			StringTokenizer st = new StringTokenizer(in.readLine());

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int num = Integer.parseInt(st.nextToken());
					board[r][c] = num;
					total += num;
				}
			}

			if (total > 30) {
				sb.append(0).append(" ");
				continue;
			}

			if(play(0)) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
		System.out.println(sb);
	}

	private static boolean play(int game) {
		if(game == 15) return true;
		
		// home 승
		if(board[home[game]][0] > 0 && board[away[game]][2] >0) {
			board[home[game]][0]--;
			board[away[game]][2]--;
			if(play(game + 1)) return true;
			board[home[game]][0]++;
			board[away[game]][2]++;
		}
		
		// away 승
		if(board[home[game]][2] > 0 && board[away[game]][0] >0) {
			board[home[game]][2]--;
			board[away[game]][0]--;
			if(play(game + 1)) return true;			
			board[home[game]][2]++;
			board[away[game]][0]++;
		}
		
		// 무승부
		if(board[home[game]][1] > 0 && board[away[game]][1] >0) {
			board[home[game]][1]--;
			board[away[game]][1]--;
			if(play(game + 1)) return true;
			board[home[game]][1]++;
			board[away[game]][1]++;
		}
		return false;
	}
}