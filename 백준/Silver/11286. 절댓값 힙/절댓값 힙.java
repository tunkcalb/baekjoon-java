import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x) {
					return  o1.y - o2.y;
				}
				else {
					return o1.x - o2.x;
				}
			}
			
		});
		
		N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if (num != 0) {
				queue.offer(new Point(Math.abs(num), num));
			}
			else {
				if(!queue.isEmpty()) {
					System.out.println(queue.poll().y);
				}
				else {
					System.out.println(0);
				}
			}
		}
	}
}