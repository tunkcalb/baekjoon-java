import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		int sum = 0;
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < X; i++) {
			sum += nums[i];
		}
		int max = sum;
		int maxCnt = 1;
		for(int i = X; i < N; i++) {
			sum -= nums[i - X];
			sum += nums[i];
			if(max < sum) {
				max = sum;
				maxCnt = 1;
			}
			else if(max == sum) {
				maxCnt++;
			}
		}
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(maxCnt);
		}
	}
}
