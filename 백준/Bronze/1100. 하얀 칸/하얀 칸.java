import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 8;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < N; j++) {
				if((i + j) % 2 == 0 && line.charAt(j) == 'F') cnt++;
			}
		}
		System.out.println(cnt);
	}
}
