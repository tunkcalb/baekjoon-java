import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] ans = {"D", "C", "B", "A", "E"};
		
		int n = 3;
		int m = 4;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx = 0;
			for(int j = 0; j < m; j++) {
				idx += Integer.parseInt(st.nextToken());
			}
			sb.append(ans[idx]).append("\n");
		}
		System.out.println(sb);
	}
}
