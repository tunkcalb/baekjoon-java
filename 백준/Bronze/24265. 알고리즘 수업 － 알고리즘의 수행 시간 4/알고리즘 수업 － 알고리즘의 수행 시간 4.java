import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(N * (N - 1L) / 2L).append("\n");
		sb.append(2);
		
		System.out.println(sb);
	}
}
