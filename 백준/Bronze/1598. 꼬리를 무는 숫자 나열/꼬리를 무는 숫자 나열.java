import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a =  Integer.parseInt(st.nextToken()) - 1;
		int b = Integer.parseInt(st.nextToken()) - 1;
		
		int ans = 0;
		
		ans += Math.abs(a / 4 - b / 4);
		ans += Math.abs(a % 4 - b % 4);
		
		System.out.println(ans);
	}
}
