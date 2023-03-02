
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
		
	private static final int[] dr = { 0, -1, 1, 0, 0 };
	private static final int[] dc = { 0, 0, 0, 1, -1 };

	private static class Shark implements Comparable<Shark> {
		public int r; 
		public int c; 
		public int s; 
		public int d; 
		public int z; 

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			return this.r - o.r;
		}

	}

	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());

		PriorityQueue<Shark> pQueue = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			pQueue.offer(new Shark(r, c, s, d, z));
		}

		int kingC = 0; 

		int sum = 0;

		while (kingC < C) {

			kingC++;

			boolean isCatch = false;
			List<Shark> tempSharks = new ArrayList<>();
			while (!pQueue.isEmpty()) {

				Shark curShark = pQueue.poll();

				if (curShark.c == kingC && isCatch == false) {


					isCatch = true;
					sum += curShark.z;
				}

				else {
					tempSharks.add(curShark);
				}

			}

			
			Shark[][] isVisited = new Shark[R + 1][C + 1]; 

			for (Shark curShark : tempSharks) {
				
				int seconds = 0;
				
				if (curShark.d == 1 || curShark.d == 2) {
					seconds = curShark.s % ((R - 1) * 2);
				}
				
				else if (curShark.d == 3 || curShark.d == 4) {
					seconds = curShark.s % ((C - 1) * 2);
				}

				
				for (int i = 0; i < seconds; i++) {
					int testR = curShark.r + dr[curShark.d];
					int testC = curShark.c + dc[curShark.d];

					
					if ((0 < testR && testR <= R) && (0 < testC && testC <= C)) {
						curShark.r = testR;
						curShark.c = testC;
					}

					else {

						if (curShark.d == 1 || curShark.d == 2) {
							curShark.d = curShark.d == 1 ? 2 : 1;  // 위 아래 방향 전환 
						}

						else if (curShark.d == 3 || curShark.d == 4) {
							curShark.d = curShark.d == 3 ? 4 : 3;  // 오른쪽 왼쪽 방향 전환
						}


						curShark.r += dr[curShark.d];
						curShark.c += dc[curShark.d];
					}
				}


				if (isVisited[curShark.r][curShark.c] == null) {
					isVisited[curShark.r][curShark.c] = curShark;
				}
				else if (isVisited[curShark.r][curShark.c] != null) { 
					if (isVisited[curShark.r][curShark.c].z < curShark.z) {
						isVisited[curShark.r][curShark.c] = curShark;
					}
				}
			}

			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (isVisited[i][j] != null) {
						pQueue.offer(isVisited[i][j]);
					}
				}
			}
		}

		sb.append(sum);
		System.out.println(sb);
	}

}