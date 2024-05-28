import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int cnt = 0;
		
		for(int i = 1; i * i <= N; i++) {
			cnt++;
		}
		System.out.println(cnt);
	}
}
