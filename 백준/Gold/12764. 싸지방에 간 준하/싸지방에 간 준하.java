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
	
	static class Computer implements Comparable<Computer>{
		int end;
		int idx;
		public Computer(int end, int idx) {
			super();
			this.end = end;
			this.idx = idx;
		}
		@Override
		public int compareTo(Computer o) {
			if(this.end == o.end) {
				return this.idx - o.idx;
			}
			return this.end - o.end;
		}
		
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException{
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
		
		
		PriorityQueue<Computer> computer = new PriorityQueue<>();
		PriorityQueue<Integer> nextCom = new PriorityQueue<>();
		
		int[] useCnt = new int[N];
		int Count = 0;
		for(int i = 0; i < N; i++) {
			while(!computer.isEmpty() && times.peek().start >= computer.peek().end) {
				nextCom.offer(computer.poll().idx);
			}
			
			if(!nextCom.isEmpty()) {
				useCnt[nextCom.peek()]++;
				computer.offer(new Computer(times.poll().end, nextCom.poll()));				
			}
			else {
				computer.offer(new Computer(times.poll().end, Count));
				useCnt[Count++]++;				
			}
		}
		
		sb.append(Count).append("\n");
		
		for(int i = 0; i < Count; i++) {
			sb.append(useCnt[i]).append(" ");
		}
		System.out.println(sb);
	}
}
