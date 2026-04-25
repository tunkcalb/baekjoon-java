import java.io.*;
import java.util.*;

public class Main {
	
	static Integer[] nums;
	static boolean[] visited;
	static int N;
	static int B;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		N = A.length();
		nums = new Integer[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = A.charAt(i) - '0';
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		ans = -1;
		permutation("", 0);
		
		System.out.println(ans);
	}

	private static void permutation(String num, int idx) {
		
		if(ans != -1) return;
		
		if(num.length() > 0 && num.charAt(0) == '0') return;
		
		if(!num.equals("") && idx ==  N && Integer.parseInt(num) < B) {
			ans = Integer.parseInt(num);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			permutation(num + nums[i], idx + 1);
			visited[i] = false;
		}
		
	}
}
