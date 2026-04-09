import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		List<Gift> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Gift(n, d));
		}
		
		Collections.sort(list, (o1, o2) -> o1.n - o2.n);
		
		int start = 0;
		int end = 0;
		
		long max = 0;
		long sum = list.get(0).d;
		while(start <= end && end < N) {
			if(list.get(end).n - list.get(start).n >= D) {
				sum -= list.get(start).d;
				start++;
			}
			else {
				max = Math.max(max, sum);
				end++;
				if(end < N) sum += list.get(end).d;
			}
		}
		
		System.out.println(max);
	}
	
	static class Gift {
		int n;
		int d;
		
		Gift(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
}
