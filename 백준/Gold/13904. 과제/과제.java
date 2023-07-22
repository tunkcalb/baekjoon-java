import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Homework{
		int end;
		int score;

		public Homework(int end, int score) {
			super();
			this.end = end;
			this.score = score;
		}
	}

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		List<Homework> list = new ArrayList<>();
		
		int maxDay = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int end = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			if(end > maxDay) maxDay = end;
			list.add(new Homework(end, score));
		}
		
		int sum = 0;
		for(int day = maxDay; day >= 1; day--) {
			Homework ans = new Homework(0, 0);
			
			for(Homework now : list) {
				if(now.end >= day) {
					if(now.score > ans.score) {
						ans = now;
					}
				}
			}
			
			sum += ans.score;
			list.remove(ans);
		}
		System.out.println(sum);
	}
}
