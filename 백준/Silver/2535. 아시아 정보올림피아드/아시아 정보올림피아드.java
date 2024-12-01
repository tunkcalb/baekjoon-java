import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[][] board = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			board[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(board, (o1, o2) -> o2[2] - o1[2]);
		
		int third = 2;
		if(board[0][0] == board[1][0]) {
			for(int i = 2; i < n; i++) {
				if(board[0][0] != board[i][0]) {
					third = i;
					break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(board[0][0]).append(" ").append(board[0][1]).append("\n");
		sb.append(board[1][0]).append(" ").append(board[1][1]).append("\n");
		sb.append(board[third][0]).append(" ").append(board[third][1]).append("\n");
		
		System.out.println(sb);
	}
}
