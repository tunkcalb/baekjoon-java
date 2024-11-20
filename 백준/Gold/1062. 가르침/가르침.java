import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int max;
	static String[] words;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			words[i] = str;
		}
		
		if(K < 5) {
			System.out.println(0);
			return;
		} else if (K == 26) {
			System.out.println(N);
			return;
		}
		
		visited = new boolean[26];
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		
		max = 0;
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int alpha, int cnt) {
		if(cnt == K - 5) {
			int count = 0;
			for(String word : words) {
				boolean canRead = true;
				for(int j = 0; j < word.length(); j++) {
					if(!visited[word.charAt(j) - 'a']) {
						canRead = false;
						break;
					}
				}
				if(canRead) count++;
			}
			max = Math.max(max, count);
			return;
		}
		for(int i = alpha; i < 26; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
