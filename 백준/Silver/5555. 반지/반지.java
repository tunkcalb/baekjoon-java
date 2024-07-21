import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String word = in.readLine();
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			line = line + line + line;
			if(line.contains(word)) cnt++;
		}
		System.out.println(cnt);
	}
}
