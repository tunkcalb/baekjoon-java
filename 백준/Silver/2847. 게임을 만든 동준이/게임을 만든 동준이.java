import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		int cnt = 0;
		for(int i = N - 2; i >= 0; i--) {
			while(num[i] >= num[i + 1]){
				num[i]--;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
