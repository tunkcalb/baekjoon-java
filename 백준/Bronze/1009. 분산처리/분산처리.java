import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = 1;
			for(int i = 0; i < b; i++) {
				ans *= a;
				ans %= 10;
			}
			if(ans == 0) ans = 10;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
