import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int min = 0;
		
		for(int i = 1; i <= K; i++) {
			min += i;
		}
		
		if(min > N) {
			System.out.println(-1);
		}
		else {
			int ans = K - 1;
			N -= min;
			if(N % K != 0) ans++;
			System.out.println(ans);
		}
	}
}
