import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int p = 0;
		int ans = 0;
		
		while(cnt != 24) {
			if(p + a <= m) {
				ans += b;
				p += a;
			}
			else {
				p = p - c < 0 ? 0 : p - c;
			}
			cnt++;
		}
		System.out.println(ans);
	}
}
