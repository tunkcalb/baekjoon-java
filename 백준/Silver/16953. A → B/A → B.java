import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long A, B;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE;
		dfs(A, 1);
		if(ans != Integer.MAX_VALUE) System.out.println(ans);
		else System.out.println(-1);
	}

	private static void dfs(long num, int cnt) {
		if(num > B) return;
		
		if(num == B) {
			if(ans > cnt) ans = cnt;
			return;
		}
		
		dfs(num * 10 + 1, cnt + 1);
		dfs(num * 2, cnt + 1);
		
	}
}
