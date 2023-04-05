import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static HashSet<String> set;
	static int N;
	static char[] num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		N = line.length();
		num = new char[N];
		set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			num[i] = line.charAt(i);
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, i, "" + num[i]);
		}
		
		System.out.println(set.size());
	}

	private static void dfs(int L, int R, String number) {
		if(L == 0 && R == N - 1) {
			set.add(number);
			return;
		}
		
		if(L - 1 >= 0) {
			dfs(L - 1, R, number + num[L - 1] + number);
		}
		if(R + 1 < N) {
			dfs(L, R + 1, number + number + num[R + 1]);
		}
	}
}