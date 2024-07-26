import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 1;
		int range = 2;
		
		while(range <= N) {
			range += 6 * cnt;
			cnt++;
		}
		System.out.println(cnt);
	}
}
