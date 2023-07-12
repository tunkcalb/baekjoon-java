import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] num;
	static int[] ans;
	static HashSet<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		Permutation(0, "");
		
		System.out.println(sb);
	}


	private static void Permutation(int cnt, String check) {
		
		if(cnt == M) {
			if(set.contains(check)) return;
			for(int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			set.add(check);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			ans[cnt] = num[i];
			Permutation(cnt + 1, check + " " + num[i]);
		}
		
	}
}
