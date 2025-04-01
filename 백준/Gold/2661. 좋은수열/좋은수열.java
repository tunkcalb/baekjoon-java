import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dfs("");
	}

	private static void dfs(String string) {
		if(string.length() == N) {
			System.out.println(string);
			System.exit(0);
		}
		
		for(int i = 1; i <= 3; i++) {
			if(canMake(string + i)) dfs(string + i);
		}
	}

	private static boolean canMake(String string) {
		for(int i = 1; i <= string.length() / 2; i++) {
			String left = string.substring(string.length() - i * 2, string.length() - i);
			String right = string.substring(string.length() - i, string.length());
			if(left.equals(right)) return false;
		}
		
		return true;
	}
}
