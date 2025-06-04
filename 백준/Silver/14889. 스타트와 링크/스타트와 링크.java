import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int min;
	static int[][] board;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		
		board = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);
	}

	private static void comb(int cnt, int idx) {
		if(cnt == N / 2) {
			cal();
			return;
		}
		if(idx >= N) return; 
		
		
		visited[idx] = true;
		comb(cnt + 1, idx + 1);
		visited[idx] = false;
		comb(cnt, idx + 1);
	}

	private static void cal() {
		
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(visited[i] && visited[j]) {
					start += board[i][j];
				}
				else if(!visited[i] && !visited[j]) {
					link += board[i][j];
				}
			}
		}
		
		min = Math.min(min, Math.abs(start - link));
		
		if(min == 0) {
			System.out.println(0);
			System.exit(0);
		}
	}
}
