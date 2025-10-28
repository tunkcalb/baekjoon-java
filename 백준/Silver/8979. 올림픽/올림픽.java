import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N + 1][4];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			board[idx][0] = Integer.parseInt(st.nextToken());
			board[idx][1] = Integer.parseInt(st.nextToken());
			board[idx][2] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 1;
		for(int i = 1; i <= N; i++) {
			if(i == K) continue;
			
			if(board[i][0] > board[K][0]) {
				cnt++;
			}
			else if(board[i][0] == board[K][0] && board[i][1] > board[K][1]) {
				cnt++;
			}
			else if(board[i][0] == board[K][0] && board[i][1] == board[K][1] && board[i][2] > board[K][2]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
