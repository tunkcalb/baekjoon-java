import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] pipe = new int[N];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pipe);
	
		int ans = 1;
		
		int start = pipe[0];
		
		for(int i = 1; i < N; i++) {
			if(pipe[i] - start < L) continue;
			start = pipe[i];
			ans++;
		}
		System.out.println(ans);
	}
}
