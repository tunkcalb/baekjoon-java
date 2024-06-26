import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N; i++) {
			if(i % 2 == 1) {
				sb.append("1 ");
			}
			else sb.append("2 ");
		}
		
		if(N % 2 == 1) sb.append("3");
		else sb.append("2");
		
		System.out.println(sb);
	}
}
