import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int diff;
	private static boolean[] used;
	private static int[][] board;
	
	public static void main(String[] args) throws Exception {

		/**
		 * 1. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		 * 2. 입력파일 객체화
		 */
		N = Integer.parseInt(in.readLine());
		used = new boolean[N];
		diff = 1000000000;
		board = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/**
		 * 3. 알고리즘 풀기
		 */
		cook(0);
		System.out.println(diff);
		/**
		 * 4. 정답 출력
		 */

	}

	private static void cook(int now) {
		if (now == N) {
			int sour = 1;
			int bitter = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (used[i]) {
					cnt++;
					sour *= board[i][0];
					bitter += board[i][1];
				}
			}
			if(cnt == 0) return; //공집합이면 리턴
			if(diff > Math.abs(sour - bitter))
				diff = Math.abs(sour - bitter);
			return;
		}
		used[now] = true;
		cook(now + 1);
		used[now] = false;
		cook(now + 1);
		
	}
}