import java.io.*;
import java.util.*;

public class Main {
	
	static int[] coins = {500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 1000 - Integer.parseInt(in.readLine());
		int cnt = 0;
		for(int coin : coins) {
			cnt += N / coin;
			N %= coin;
		}
		System.out.println(cnt);
	}
}
