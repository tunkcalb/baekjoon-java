import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int a;
		int b;
		public Point(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
	
	static int T;
	static int N, M;
	static int cnt;
	static Point[] people;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			people = new Point[M];
			visited = new boolean[N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				people[i] = new Point(a,b);	
			}
			
			Arrays.sort(people, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o1.b - o2.b;
				}
			});
			cnt = 0;
			for(int i = 0; i < M; i++) {
				int start = people[i].a;
				int end = people[i].b;
				
				for(int j = start; j <= end; j++) {
					if(!visited[j]) {
						visited[j] = true;
						cnt++;
						break;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
