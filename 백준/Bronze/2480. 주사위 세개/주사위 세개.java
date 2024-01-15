import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int ans = game(A, B, C);
		
		System.out.println(ans);
	}

	private static int game(int A, int B, int C) {
		if(A == B && B == C && C == A) {
			return 10000 + (A * 1000);
		}
		if(A == B) return 1000 + (A * 100);
		if(B == C) return 1000 + (B * 100);
		if(C == A) return 1000 + (C * 100);
		
		int max = Math.max(A, B);
		max = Math.max(max, C);
		
		return max * 100;
	}
}
