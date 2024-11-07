import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String L = st.nextToken();
		String R = st.nextToken();
		
		int answer = 0;
		if(L.length() == R.length()) {
			int i = 0;
			
			while(i < L.length() && L.charAt(i) == R.charAt(i)) {
				if(L.charAt(i) == '8') {
					answer++;
				}
				i++;
			}
		}
		System.out.println(answer);
	}
}
