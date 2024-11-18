import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(in.readLine());
			
			if(num == 0 || num == 1) {
				sb.append(2).append("\n");
				continue;
			}
			while(true) {
				boolean isValid = true;
				for(long j = 2; j <= Math.sqrt(num); j++) {
					if(num % j == 0) {
						isValid = false;
						break;
					}
				}
				
				if(isValid) {
					sb.append(num).append("\n");
					break;
				}
				num++;
			}
		}
		System.out.println(sb);
	}
}
