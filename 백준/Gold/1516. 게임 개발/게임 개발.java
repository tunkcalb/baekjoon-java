import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] time;
	static int[] foundation;
	static List<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		list = new List[N + 1];
		time = new int[N + 1];
		foundation = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			time[i] = Integer.parseInt(st.nextToken());

			int num = Integer.parseInt(st.nextToken());

			while (num != -1) {
				list[num].add(i);
				num = Integer.parseInt(st.nextToken());
				foundation[i]++;
			}
		}
		build();
		System.out.println(sb);
	}

	private static void build() {
		int[] answer = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (foundation[i] == 0) {
				q.offer(i);
				answer[i] += time[i];				
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				foundation[next]--;

				answer[next] = Math.max(answer[next], answer[now] + time[next]);
				if (foundation[next] == 0)
					q.offer(next);
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
	}
}
