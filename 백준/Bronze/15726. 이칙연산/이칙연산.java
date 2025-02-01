import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		int ans = Math.max(cal(a, b, c), cal(a, c, b));
		System.out.println(ans);
	}

	private static int cal(long a, long b, long c) {
		long ans = a * b / c;
		return (int) ans;
	}
}
