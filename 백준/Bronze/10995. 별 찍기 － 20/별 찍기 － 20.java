import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String star;
			if(i % 2 == 0) star = "* "; 
			else star = " *";
			
			for(int j = 0; j < N; j++) {
				sb.append(star);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
