import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		
		int a = 0;
		int b = 0;
		for(int i = 0; i < N; i++) {
			char vote = line.charAt(i);
			if(vote == 'A') a++;
			else b++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(a < b) sb.append("B");
		else if (a > b) sb.append("A");
		else sb.append("Tie");
		
		System.out.println(sb);
	}
}
