import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int size = 100;
		
		int[][] board = new int[size + 1][size + 1];
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			
			for(int i = startR; i <= endR; i++) {
				for(int j = startC; j <= endC; j++) {
					board[i][j]++;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(board[i][j] > M) cnt++;;
			}
		}
		System.out.println(cnt);
	}
}
