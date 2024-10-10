import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int ans = 2;
		
		for(int i = 1; i <= N; i++) {
			ans += ans - 1;
		}
		System.out.println(ans * ans);
	}
}
