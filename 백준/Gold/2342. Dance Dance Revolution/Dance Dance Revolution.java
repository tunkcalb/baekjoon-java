import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M = 5;
	static int[] num;
	static int[][][] DP;	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = in.readLine().split(" ");
		N = line.length;
		num = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(line[i - 1]);
		}
		
		DP = new int[N + 1][M][M];
		
		int ans = ddr(0, 0, 0);
		
		System.out.println(ans);
	}

	private static int ddr(int step, int left, int right) {
		if(step == N - 1) {
			return 0;
		}
		
		if(DP[step][left][right] != 0) return DP[step][left][right];
		
		int leftScore = move(left, num[step + 1]) + ddr(step + 1, num[step + 1], right);
		int rightScore = move(right, num[step + 1]) + ddr(step + 1, left, num[step + 1]);
		
		DP[step][left][right] = Math.min(leftScore, rightScore);

		return DP[step][left][right];
	}

	private static int move(int now, int next) {
		int num = Math.abs(now - next) % 2;
		
		if(now == 0) return 2;
		if(now == next) return 1;
		else if(num == 1) return 3;
		else return 4;
	}
}