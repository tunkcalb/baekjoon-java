import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = 5;
		int winner = 0;
		int max = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int sum = 0;
			for(int j = 0; j < N - 1; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			if(max < sum) {
				winner = i;
				max = sum;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(winner).append(" ").append(max);
		System.out.println(sb);
	}
}
