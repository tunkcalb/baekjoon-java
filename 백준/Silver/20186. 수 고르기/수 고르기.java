import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		List<Point> nums = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums.add(new Point(num, i));
		}
		
		Collections.sort(nums, (o1, o2) -> o2.num - o1.num);
		
		List<Point> list = new ArrayList<>(); 
		for(int i = 0; i < K; i++) {
			list.add(nums.get(i));
		}
		
		Collections.sort(list, (o1, o2) -> o1.idx - o2.idx);
		
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			int num = list.get(i).num;
			
			sum += num - i;
		}
		System.out.println(sum);
	}
	
	static class Point {
		int num;
		int idx;
		
		Point(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
}
