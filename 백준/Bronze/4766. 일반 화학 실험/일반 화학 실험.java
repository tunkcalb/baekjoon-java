import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double now = Double.parseDouble(br.readLine());
		double next = 0;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			next = Double.parseDouble(br.readLine());
			if(next == (double) 999) break;
			sb.append(String.format("%.2f", next - now)).append("\n");
			
			now = next;
		}
		
		System.out.println(sb);
	}
}
