import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static long max;
	static long ans;
	static int[] time;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		time = new int[N];
		
		max = 0;
		for(int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(in.readLine());
			if(max < time[i]) max = time[i];
		}
		
		howManyTimes();
		System.out.println(ans);
	}

	private static void howManyTimes() {
		long low = 0;
		long high = max * M;
		ans = 0;
		while(low <= high) {
			long mid = (low + high) / 2;
			
			long cnt = 0;
			
			for(int i = 0; i < N; i++) {
				// mid시간동안 i번째 심사대에서 처리 가능한 사람 수
				cnt += (mid / time[i]);
				if(cnt > M) break;
			}
			
			if (cnt >= M) {
				ans = mid;
				high = mid - 1;
			}else if (cnt < M) {
				low = mid + 1;
			}
		}
		
	}
}
