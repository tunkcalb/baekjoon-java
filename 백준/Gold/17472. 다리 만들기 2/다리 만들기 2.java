import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static final int WATER = 0;

	private static int N;
	private static int M;

	private static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public int weight;

		@Override
		public String toString() {
			return "Edge{" +
					"from=" + from +
					", to=" + to +
					", weight=" + weight +
					'}';
		}


		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	private static int[][] map;
	private static boolean[][] visited;
	private static int current; 
	private static int[] dx = { 0, 1, 0, -1 }; 
	private static int[] dy = { 1, 0, -1, 0 };

	private static int[] parents;

	public static void DFS(int curX, int curY) {
		visited[curX][curY] = true;
		if (map[curX][curY] == 1) {
			map[curX][curY] = current;  
		}

		for (int i = 0; i < 4; i++) {
			int testX = curX + dx[i];
			int testY = curY + dy[i];

			if ((0 <= testX && testX < N) && (0 <= testY && testY < M)) {
				if (!visited[testX][testY] && map[testX][testY] == 1) {
					DFS(testX, testY);
				}
			}
		}
	}

	private static void make() {
		parents = new int[current + 1];
		for (int i = 0; i <= current; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]); 
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		current = 1;  
		visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (!visited[x][y] && map[x][y] == 1) {
					current++;
					DFS(x, y);
				}
			}
		}

		
		List<Edge> list = new ArrayList<>();
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] != WATER) {  
					for (int i = 0; i < 4; i++) {
						int testX = x + dx[i];
						int testY = y + dy[i];
						if ((0 <= testX && testX < N) && (0 <= testY && testY < M)) {

							if (map[testX][testY] != WATER) {  
								continue;
							} 
							else {  
								Edge temp = new Edge();
								temp.from = map[x][y];  

								int tX = testX;
								int tY = testY;

								for (int cnt = 1; (0 <= tX && tX < N) && (0 <= tY && tY < M); cnt++) {
									tX = tX + dx[i];
									tY = tY + dy[i];

									if ((0 <= tX && tX < N) && (0 <= tY && tY < M)) {
										if (map[tX][tY] == WATER) {  
											continue;  
										}
										else { 
											if (cnt > 1) {  
												temp.to = map[tX][tY];  
												temp.weight = cnt;  
												list.add(temp);
											}
											break;  
										}
									}
								}
							}
						}
					}
				}
			}
		}


		Collections.sort(list);

	
		make();

		int k = 0, result = 0;
		for (Edge e : list) {
			if (union(e.from, e.to)) { 
				result += e.weight;

				if (++k == current - 2) {
					break;
				}
			}
		}

		if (k == current - 2) {
			System.out.println(result);
		}
		else { 
			System.out.println(-1);
		}
	}

}