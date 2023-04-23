import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(in.readLine());
		
		long sum = 0;
		long cnt = 0;
		
		for(long i = 1; i <= n; i++) {
			sum += i;
			cnt++;
			if(sum >= n) break;
		}
		if(sum > n) cnt--;
		System.out.println(cnt);
	}
}
