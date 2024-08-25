import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 4;
		int m = 60;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(in.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(sum / m).append("\n");
		sb.append(sum % m);
	
		System.out.println(sb);
		
	}
}
