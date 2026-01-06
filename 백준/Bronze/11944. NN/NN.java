import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int N = Integer.parseInt(num);
		int M = Integer.parseInt(st.nextToken());
		
		String ans = "";
		for(int i = 0; i < N; i++) {
			ans += num;
			
			if(ans.length() >= M) break;
		}
		
		System.out.println(ans.length() >= M ? ans.substring(0, M) : ans);
		
	}
}
