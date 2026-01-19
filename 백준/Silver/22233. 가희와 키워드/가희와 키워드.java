import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			
			while(st.hasMoreTokens()) {
				String keyword = st.nextToken();
				set.remove(keyword);
			}
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
}
