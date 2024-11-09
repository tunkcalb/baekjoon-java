import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int N = S / K;
		int mod = S % K;
		
		long ans = 1;
		for(int i = 0; i < K; i++) {
			if(i < mod) ans *= N + 1;
			else ans *= N;
		}
		System.out.println(ans);
	}
}
