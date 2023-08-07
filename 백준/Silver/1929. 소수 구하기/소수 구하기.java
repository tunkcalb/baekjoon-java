import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	public static boolean[] sosu;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		sosu = new boolean[N + 1];
		
		cal();
		
		for(int i = M; i <= N; i++) {
			if(!sosu[i]) System.out.println(i);
		}
		
	}

	private static void cal() {
		
		sosu[0] = true;
		sosu[1] = true;
		
		for(int i = 2; i <= Math.sqrt(sosu.length); i++) {
			if(sosu[i]) continue;
			for(int j = i * 2; j <= N; j += i) {
				sosu[j] = true;
			}
		}
	}
}
