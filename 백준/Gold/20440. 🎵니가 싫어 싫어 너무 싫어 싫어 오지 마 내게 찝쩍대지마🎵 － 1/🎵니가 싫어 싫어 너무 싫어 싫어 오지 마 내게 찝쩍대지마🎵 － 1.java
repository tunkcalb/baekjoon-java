import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
		
	}
	
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Time> times = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			times.offer(new Time(start, end));
		}
		
		int max = 0;
		long start = 0;
		long end = 0;
		PriorityQueue<Integer> mogi = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			while(!mogi.isEmpty() && times.peek().start > mogi.peek()) {
				mogi.poll();
			}
			Time time = times.poll();
			if(!mogi.isEmpty() && time.start == mogi.peek()) {
				if(mogi.peek() == end) {
					end = time.end;					
				}
				mogi.poll();
			}
			
			mogi.offer(time.end);
			
			if(mogi.size() > max) {
				max = mogi.size();
				start = time.start;
				end = mogi.peek();
			}
		}
		sb.append(max).append("\n");
		sb.append(start + " " + end);
		System.out.println(sb);		
	}
}
