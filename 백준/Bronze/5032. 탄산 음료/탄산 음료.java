import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		e += Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(e >= c) {
			cnt += e / c;
			e = e / c + e % c;
		}
		
		System.out.println(cnt);
	}
}
