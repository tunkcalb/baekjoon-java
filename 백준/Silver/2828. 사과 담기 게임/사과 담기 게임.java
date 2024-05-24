import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());
		int ans = 0;
		int start = 1;
		int end = M;
		
		for(int i = 0; i < t; i++) {
			int apple = Integer.parseInt(in.readLine());
			if(start > apple) {
				ans += start - apple;
				end -= start - apple;
				start = apple;
			} else if (end < apple) {
				ans += apple - end;
				start += apple - end;
				end = apple;
			}
		}
		System.out.println(ans);
	}
}
