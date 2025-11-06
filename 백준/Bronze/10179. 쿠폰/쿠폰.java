import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			double num = Double.parseDouble(br.readLine());
			
			num /= 5;
			num *= 4;
			
			sb.append(String.format("$%.2f",num)).append("\n");
		}
		
		System.out.println(sb);
	}
}
