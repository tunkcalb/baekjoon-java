import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	static int N;
	static int min;
	
	static boolean[] isSelected;
	static int[] plan;
	
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		plan = new int[N + 1];
		plan[0] = 0;
		plan[N] = 0;
		isSelected = new boolean[N];
		
		min = Integer.MAX_VALUE;
		permutation(1);
		if (min == Integer.MAX_VALUE) min = 0;
		
		System.out.println(min);
		
	}

	

	private static void permutation(int cnt) {
		if(cnt == N) {
			rotation();
			return;
		}
		
		for(int i = 1; i < N; i++) {
			
			if(!isSelected[i]) {
				isSelected[i] = true;
				plan[cnt] = i;
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
		
	}



	private static void rotation() {
		int sum = 0;
		
		int start = 0;
		int stop = 0;
		for(int i = 0; i < N; i++) {
			start = plan[i];
			stop = plan[i + 1];
			if(board[start][stop] != 0) {
				sum += board[start][stop];				
			}
			else {
				return;
			}
		}
		
		if(sum < min) min = sum;
	}
	
	
}