import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<String> results;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			results = new ArrayList<>();
			N = Integer.parseInt(in.readLine());
			dfs(1, 1, 0, 1, "1"); // 초기값을 두 번째 코드와 맞춤
			
			Collections.sort(results);
			
			for(String str : results) {
				sb.append(str).append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int num, int sum, int op, String express) {
		if(idx == N) {
			sum += (num * op);
			if(sum == 0) results.add(express);
			return;
		}
		
		dfs(idx + 1, num * 10 + (idx + 1), sum, op, express + " " + (idx + 1)); // 숫자를 결합
		dfs(idx + 1, idx + 1, sum + (num * op), 1, express + "+" + (idx + 1)); // 덧셈
		dfs(idx + 1, idx + 1, sum + (num * op), -1, express + "-" + (idx + 1)); // 뺄셈
	}
}
