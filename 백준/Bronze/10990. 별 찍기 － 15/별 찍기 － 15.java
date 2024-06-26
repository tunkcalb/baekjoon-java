import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			if(i == 1) {
				sb.append("*").append("\n");
			}
			else {
				sb.append("*");
				for(int j = 0; j < ((i - 1) * 2) - 1; j++) {
					sb.append(" ");
				}
				sb.append("*").append("\n");
			}
		}
		System.out.println(sb);
	}
}
