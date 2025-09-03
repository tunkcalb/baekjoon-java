import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			sb.append(String.valueOf(line.charAt(0)).toUpperCase()).append(line.substring(1)).append("\n");
		}
		
		System.out.println(sb);
	}
}
