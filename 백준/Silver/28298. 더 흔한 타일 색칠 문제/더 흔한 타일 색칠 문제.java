import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int gap = (N * M) / (K * K);
		
		char[][] board = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		int sum = 0;
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < K; j++) {
				int[] cnt = new int[26];
				
				int max = 0;
				char alpha = 'A';
				for(int r = i; r < N; r += K) {
					for(int c = j; c < M; c += K) {
						int idx = board[r][c] - 'A';
						cnt[idx]++;
						
						if(cnt[idx] > max) {
							max = cnt[idx];
							alpha = (char) (idx + 'A');
						}
					}
				}
				
				for(int r = i; r < N; r += K) {
					for(int c = j; c < M; c += K) {
						board[r][c] = alpha;
					}
				}
				sum += gap - max;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
