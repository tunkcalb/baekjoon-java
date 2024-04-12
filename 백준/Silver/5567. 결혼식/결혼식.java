import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(i, new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		int cnt = 0;
		
		for(int friend : list.get(1)) {
			if(!visited[friend]) {
				visited[friend] =  true;
				cnt++;
				for(int ffriend : list.get(friend)) {
					if(!visited[ffriend]) {
						visited[ffriend] = true;
						cnt++;
					}
				}
			}
			else {
				for(int ffriend : list.get(friend)) {
					if(!visited[ffriend]) {
						visited[ffriend] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
