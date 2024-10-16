import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int start;
	static int end;
	static int[] nums;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		nums = new int[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];

		Arrays.fill(visited, -1);

		Queue<Integer> q = new LinkedList<>();

		q.add(start);

		visited[start] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = now - nums[now]; i > 0; i -= nums[now]) {
				if (visited[i] == -1) {
					visited[i] = visited[now] + 1;
					q.add(i);
				}
			}

			for (int i = now + nums[now]; i <= N; i += nums[now]) {
				if (visited[i] == -1) {
					visited[i] = visited[now] + 1;
					q.add(i);
				}
			}
			if (visited[end] != -1) {
				System.out.println(visited[end]);
				return;
			}
		}
		System.out.println(-1);
	}
}
