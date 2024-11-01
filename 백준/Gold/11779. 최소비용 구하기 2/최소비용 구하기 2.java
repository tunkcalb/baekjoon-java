import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		ArrayList<int[]>[] board = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			board[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			board[start].add(new int[] { end, cost });
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		int[] prev = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		queue.add(new int[] { start, 0 });
		dist[start] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (dist[cur[0]] < cur[1])
				continue;
			if (end == cur[0])
				break;

			for (int[] a : board[cur[0]]) {
				if (dist[a[0]] <= cur[1] + a[1])
					continue;

				queue.add(new int[] { a[0], cur[1] + a[1] });
				prev[a[0]] = cur[0];
				dist[a[0]] = cur[1] + a[1];
			}
		}

		Deque<Integer> stack = new ArrayDeque<>();
		int city = end;

		while (city != 0) {
			stack.push(city);
			city = prev[city];
		}

		System.out.println(dist[end]);
		System.out.println(stack.size());
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();

	}
}
