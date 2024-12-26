import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] dist;
	static List<List<Road>> board;
	static final int INF = 999999999;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		test: for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			board = new ArrayList<>();
			dist = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				board.add(new ArrayList<>());
			}
			for (int i = 0; i < M + W; i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				if (i < M) {
					board.get(start).add(new Road(end, weight));
					board.get(end).add(new Road(start, weight));
				} else {
					board.get(start).add(new Road(end, -weight));
				}
			}

			if (bellman(1)) {
				sb.append("YES\n");
			}
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}

	private static boolean bellman(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean update = false;

		for (int i = 1; i <= N; i++) {
			update = false;

			for (int j = 1; j <= N; j++) {
				for (Road road : board.get(j)) {
					if (dist[road.end] > dist[j] + road.weight) {
						dist[road.end] = dist[j] + road.weight;
						update = true;
					}
				}
			}
			if (!update)
				return false;
		}
		if (update) {
			for (int i = 1; i <= N; i++) {
				for (Road road : board.get(i)) {
					if (dist[road.end] > dist[i] + road.weight) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static class Road {
		int end;
		int weight;

		Road(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
