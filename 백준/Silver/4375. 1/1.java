import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			int num = 1;
			int cnt = 1;
			
			while(num % n != 0) {
				num = (num * 10 + 1) % n;
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
