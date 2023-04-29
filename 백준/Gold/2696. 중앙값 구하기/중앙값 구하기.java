import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Integer> left;
	static PriorityQueue<Integer> right;
	static StringBuilder sb = new StringBuilder();
	static int M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			M = Integer.parseInt(in.readLine());
			int cnt = 0;

			sb.append((M + 1) / 2).append("\n");
			left = new PriorityQueue<>();
			right = new PriorityQueue<>();

			for (int i = 0; i < M; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(in.readLine());
				}
				int n = Integer.parseInt(st.nextToken());
				if (left.size() == right.size())
					left.offer(n);
				else
					right.offer(-n);

				if (!right.isEmpty()) {
					if (left.peek() < -right.peek()) {
						int lnum = -right.poll();
						int rnum = -left.poll();

						left.offer(lnum);
						right.offer(rnum);
					}
				}

				if (i % 2 == 0) {
					if (cnt % 10 == 9 || i == M - 1) {
						sb.append(left.peek()).append("\n");
					} else {
						sb.append(left.peek()).append(" ");
					}
					cnt++;
				}
			}
		}
		System.out.println(sb);
	}
}
