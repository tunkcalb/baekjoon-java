import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		long X;
		long A;
		
		public Point(long x, long a) {
			super();
			X = x;
			A = a;
		}

		@Override
		public int compareTo(Point o) {
			if(this.X == o.X) {
				return (int) (this.A - o.A); 
			}
			return (int) (this.X - o.X);
		}
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		Point[] line = new Point[N];
		
		long population = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long X = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
		
			line[i] = new Point(X, A);
			
			population += A;
		}
		population = (population + 1) / 2;
		
		Arrays.sort(line);

		long cnt = 0;
		for(Point p : line) {
			cnt += p.A;
			
			if(cnt >= population) {
				System.out.println(p.X);
				break;
			}
		}
	}
}
