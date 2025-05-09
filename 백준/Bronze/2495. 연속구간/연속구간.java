import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 8;
		int M = 3;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			int cnt = 1;
			int max = 1;
			for(int j = 1; j < N; j++) {
				if(line.charAt(j) == line.charAt(j - 1)) cnt++;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
