import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Problem> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list.add(new Problem(day, cnt));
		}
		Collections.sort(list, (o1, o2) -> o1.day - o2.day);

		PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.cnt - o2.cnt;
		});
		
		int sum = 0;
		for(Problem today : list) {
			int day = today.day;
			int cnt = today.cnt;
			
			if(day > pq.size()) {
				pq.offer(today);
			} else {
				if(cnt > pq.peek().cnt) {
					pq.poll();
					pq.offer(today);
				}
			}
		}
		
		for(Problem selected : pq) {
			sum += selected.cnt;
		}
		
		System.out.println(sum);
	}
	
	static class Problem {
		int day;
		int cnt;
		
		Problem (int day, int cnt) {
			this.day = day;
			this.cnt = cnt;
		}
	}
}
