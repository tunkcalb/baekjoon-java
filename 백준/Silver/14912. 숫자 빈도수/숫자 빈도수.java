import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			String number = String.valueOf(i);
			for(int j = 0; j < number.length(); j++) {
				int num = number.charAt(j) - '0';
				if(num == d) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
