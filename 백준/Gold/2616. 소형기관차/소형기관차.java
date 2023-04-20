import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int size;
	static int max;
	static int[] sum;
	static int[][] DP;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		sum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		sum[1] = Integer.parseInt(st.nextToken());
		
		// 누적합 저장
		for (int i = 2; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		size = Integer.parseInt(in.readLine());

		DP = new int[3 + 1][N + 1];
		
		// i대의 소형 기관차 운행
		for (int i = 1; i <= 3; i++) {
			for (int j = 1 * size; j <= N; j++) {
				DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j - size] + (sum[j] - sum[j - size]));
			}
		}
		System.out.println(DP[3][N]);
	}

}
