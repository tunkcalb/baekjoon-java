import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(M-N < N) N = M - N;
			
			long num = 1;
			for(int j = 0; j < N; j++) {
				num *= M - j;
			}
			for(int j = 0; j < N; j++) {
				num /= N - j;
			}
	
			sb.append(num + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}