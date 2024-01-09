import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		boolean[] broken = new boolean[N + 1];
		int ans = N;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j = start; j < end; j++) {
				if(!broken[j]) {
					broken[j] = true;
					ans--;
				}
			}
		}
		System.out.println(ans);
	}
}
