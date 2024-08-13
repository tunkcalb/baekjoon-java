import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N * 2; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < N; j++) {
					if(j % 2 == 0) sb.append("*");
					else sb.append(" ");
				}
			} else {
				for(int j = 0; j < N; j++) {
					if(j % 2 == 0) sb.append(" ");
					else sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
