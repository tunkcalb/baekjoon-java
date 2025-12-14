import java.io.*;
import java.util.*;

public class Main {
	
	static double[] cost= {350.34, 230.90, 190.55, 125.30, 180.90};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 5;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			double sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int cnt = Integer.parseInt(st.nextToken());
				sum += cnt * cost[i];
			}
			sb.append("$").append(String.format("%.2f", sum)).append("\n");
		}
		
		System.out.println(sb);
	}
}
