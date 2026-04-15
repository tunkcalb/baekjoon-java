import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
	
		if(N % 4 == 0 || N % 4 == 1) {
			sb.append("goose");
		}
		else {
			sb.append("duck");
		}
		
		System.out.println(sb);
	}
}
