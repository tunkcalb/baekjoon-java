import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int K;
	private static long[] A;
	
	private static long[] tree;
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new long[N + 1];
		tree = new long[N + 1];
		
		// 배열에 있는 원소들을 tree에 담기
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A[i] = Long.parseLong(st.nextToken());
			update(i, A[i] - 0);
		}
		
		// tree를 이용하여 값 갱신 및 구간 합 구하기
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			// 업데이트 연산일 경우
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(b, c - A[b]); 
				A[b] = c;
			}
			// 구간 합(interval sum) 연산의 경우
			else if (a == 2) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = intervalSum(b, c);
				sb.append(sum).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static void update(int i, long diff) {
		while(i <= N) {
			tree[i] += diff;
			
			i += (i & -i);
		}
	}
	private static long prefixSum(int i) {
		long result = 0;
		while (i > 0) {
			result += tree[i];
			
			i -= (i & -i);
		}
		
		return result;
	}
	
	private static long intervalSum(int start, int end) {
		return prefixSum(end) - prefixSum(start - 1);
	}
}