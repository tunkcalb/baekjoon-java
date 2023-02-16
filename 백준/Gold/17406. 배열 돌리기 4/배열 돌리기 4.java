import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	private static int K;
	private static int answer = Integer.MAX_VALUE;
	
	private static int[][] board;
	private static int[][] rotation;
	
	private static boolean[] visited;
	private static int[] result;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				}
		}
		
		
		rotation = new int[K][3];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());		
			rotation[i][1] = Integer.parseInt(st.nextToken());		
			rotation[i][2] = Integer.parseInt(st.nextToken());		
		}
		
		visited = new boolean[K];
		result = new int[K];
		permutation(0);
		System.out.println(answer);
	}

	private static void permutation(int idx) {
		if (idx == K) {
			int[][] copy = new int[N][M];
			for(int i = 0; i <  N; i++) {
				for(int j = 0; j < M; j++) {
					copy[i][j] = board[i][j];
				}
			}
			findmin(copy);
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				result[idx] = i;
				permutation(idx + 1);
				visited[i] = false;
			}
		}		
	}

	private static void findmin(int[][] copy) {
		for(int i :result) {
			int sx = rotation[i][0] - rotation[i][2] - 1;
			int sy = rotation[i][1] - rotation[i][2] - 1;
			int ex = rotation[i][0] + rotation[i][2] - 1;
			int ey = rotation[i][1] + rotation[i][2] - 1;
			rotate(sx, sy, ex, ey, copy);
		}
		calrow(copy);
	}
	public static void calrow(int[][] copy) {
		for(int i = 0; i < copy.length; i++) {
			int sum = 0;
			for(int j = 0; j < copy[i].length; j++) {
				sum += copy[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}

	private static void rotate(int sx, int sy, int ex, int ey, int[][] copy) {
		if(sx == ex && sy == ey) return;
		
		int[] temp = new int[3];
		temp[0] = copy[sx][ey];
		temp[1] = copy[ex][ey];
		temp[2] = copy[ex][sy];
		
		//오른쪽
		for(int i = ey; i > sy; i--) {
			copy[sx][i] = copy[sx][i-1];
		}
		//아래
		for(int i = ex; i > sx; i--) {
			if(i == sx + 1) copy[i][ey] = temp[0];
			else copy[i][ey] = copy[i - 1][ey];
		}
		//왼쪽
		for(int i = sy; i < ey; i++) {
			if(i == ey - 1) copy[ex][i] = temp[1];
			else copy[ex][i] = copy[ex][i + 1];
		}
		//위
		for(int i = sx; i < ex; i++) {
			if(i == ex - 1) copy[i][sy] = temp[2];
			else copy[i][sy] = copy[i + 1][sy];
		}
		rotate(sx + 1, sy + 1, ex - 1, ey - 1, copy);
	}
}