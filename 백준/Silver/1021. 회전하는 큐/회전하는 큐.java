import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] nums = new int[M];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < M; i++) {
			int targetIdx = deque.indexOf(nums[i]);
			int halfIdx = 0;
			
			if(deque.size() % 2 == 0) {
				halfIdx = deque.size() / 2 - 1;
			}
			else halfIdx = deque.size() / 2;
			
			
			if(targetIdx <= halfIdx) {
				for(int j = 0; j < targetIdx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					cnt++;
				}
			}
			else {
				for(int j = 0; j < deque.size() - targetIdx; j++) {
					int  temp = deque.pollLast();
					deque.offerFirst(temp);
					cnt++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(cnt);
	}
}
