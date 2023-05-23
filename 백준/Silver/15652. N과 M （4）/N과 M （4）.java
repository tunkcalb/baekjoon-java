import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		permutation(0, 1);
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			num[cnt] = i;
			permutation(cnt + 1, i);
		}
	}
}
