import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int start;
	private static int end;
	private static int numsum;

	private static StringTokenizer st;
	private static int[] nums;
	public static void main(String[] args) throws Exception {

		/**
		 * 1. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		
		/**
		 * 2. 입력파일 객체화
		 */
		nums[0] = 0;
		for (int i = 1; i <= N; i++) {
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			int numsum = 0;
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			numsum = nums[end] - nums[start-1];
			sb.append(numsum).append("\n");
		}
		/**
		 * 3. 알고리즘 풀기
		 */

		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}