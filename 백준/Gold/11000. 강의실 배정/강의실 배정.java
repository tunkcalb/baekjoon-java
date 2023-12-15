import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] nums = new int[N][2];
		
		int maxTime = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
			maxTime = Math.max(maxTime, nums[i][0]);
		}
		
		Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(nums[0][1]);
		
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= nums[i][0]) {
				pq.poll();
			}
			pq.offer(nums[i][1]);
		}
		System.out.println(pq.size());
	}
}
