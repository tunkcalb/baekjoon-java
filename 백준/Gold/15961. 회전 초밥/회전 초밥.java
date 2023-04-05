import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, d, k, c;
	static int ans;
	static int[] dish, visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dish = new int[N];
		visited = new int[d + 1];
		
		for(int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(in.readLine());
		}
		
		slide();
		
		System.out.println(ans);
	}

	private static void slide() {
		int total = 0;
		
		for(int i = 0; i < k; i++) {
			if(visited[dish[i]] == 0) total++;
			visited[dish[i]]++;
		}
		ans = total;
		
		for(int i = 1; i < N; i++) {
			if(ans <= total) {
				if(visited[c] == 0) {
					ans = total + 1;
				}else {
					ans = total;
				}
			}
			visited[dish[i - 1]]--;
			if(visited[dish[i - 1]] == 0) total--;
			
			if(visited[dish[(i + k - 1) % N]] == 0) total++;
			visited[dish[(i + k - 1) % N]]++;
		}
	}
}