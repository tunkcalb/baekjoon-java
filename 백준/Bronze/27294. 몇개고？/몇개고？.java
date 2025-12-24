import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int cnt = 280;
		
		if(12 <= T && T <= 16 && S == 0) {
			cnt = 320;
		}
		
		System.out.println(cnt);
	}
}
