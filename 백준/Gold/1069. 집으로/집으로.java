import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		double distance = Math.sqrt(X * X + Y * Y);
		double ans = distance;
		
		if(distance >= D) {
			int cnt = (int) distance / D;
			ans = Math.min(ans, cnt * T + (distance - (D * cnt)));
			ans = Math.min(ans, (cnt + 1) * T);
		}
		else {
			ans = Math.min(ans, T + (D - distance));
			ans = Math.min(ans, T * 2);
		}
		System.out.println(ans);
	}
}
