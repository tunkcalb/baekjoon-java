import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		k = Integer.parseInt(in.readLine());
		
		long low = 0;
		long high = k;
		
		while(low < high) {
			long mid = (low + high) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			if(k <= cnt) {
				high = mid;
			}
			else low = mid + 1;
		}
		System.out.println(low);
	}
}
