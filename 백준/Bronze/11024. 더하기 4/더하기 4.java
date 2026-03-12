import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int size = st.countTokens();
			
			int sum = 0;
			for(int j = 0; j < size; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
