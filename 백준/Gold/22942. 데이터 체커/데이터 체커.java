import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point> {
		int no;
		int x;

		public Point(int no, int x) {
			super();
			this.no = no;
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {

			return this.x - o.x;
		}
	}

	static int N;

	public static void main(String[] args) throws IOException {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pq.offer(new Point(i, x - r));
			pq.offer(new Point(i, x + r));
		}

		while (!pq.isEmpty()) {
			if (stack.isEmpty()) {
				stack.push(pq.poll().no);
			} else {
				int num = pq.poll().no;

				if (stack.peek() == num)
					stack.pop();
				else
					stack.push(num);
			}
		}
		
		if(stack.isEmpty()) System.out.println("YES");
		else System.out.println("NO");
	}
}