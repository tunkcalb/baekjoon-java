import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int ans = 0;
		
		for(int i = 1; i <= B; i++) {
			for(int j = 1; j <= i; j++) {
				cnt++;
				
				if(A <= cnt && cnt <= B) {
					ans += i;
				}
			}
		}
		System.out.println(ans);
	}
}
