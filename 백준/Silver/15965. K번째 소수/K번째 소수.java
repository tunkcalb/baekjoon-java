import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 8000000;
		int K = Integer.parseInt(in.readLine());
		
		boolean[] nums = new boolean[N + 1];
		int cnt = 0;
		for(int i = 2; i <= N; i++) {
			if(!nums[i]) cnt++;
			else continue;
			if(cnt == K) {
				System.out.println(i);
				return;
			}
			for(int j = i * 2; j <= N; j += i) {
				if(j > N) break;
				nums[j] = true;
			}
		}
	}
}
