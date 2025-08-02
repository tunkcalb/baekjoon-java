import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int N;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - 'A';
			}
		}
		
		max = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				swap(i, j, i, j + 1);
				swap(i, j, i + 1, j);
			}
		}
		
		System.out.println(max);
	}

	private static void swap(int r1, int c1, int r2, int c2) {
		if(r2 >= N || c2 >= N) return;
		int[][] arr = copy();
		
		int tmp = arr[r1][c1];
		
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = tmp;
		
		check(arr);
	}

	private static int[][] copy() {
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = board[i][j];
			}
		}
		return arr;
	}

	private static void check(int[][] arr) {
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 1; j < N; j++) {
				if(arr[i][j] == arr[i][j - 1]) {
					cnt += 1;
					max = Math.max(max, cnt);
				}
				else cnt = 1;
			}
		}
		for(int j = 0; j < N; j++) {
			int cnt = 1;
			for(int i = 1; i < N; i++) {
				if(arr[i][j] == arr[i - 1][j]) {
					cnt += 1;
					max = Math.max(max, cnt);
				} 
				else cnt = 1; 
			}
		}
	}
}
