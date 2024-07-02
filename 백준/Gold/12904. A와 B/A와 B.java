import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder S = new StringBuilder(in.readLine());
		StringBuilder T = new StringBuilder(in.readLine());
		
		while(S.length() < T.length()) {
			if(T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			}
			else {
				T.deleteCharAt(T.length() - 1);
				T.reverse();
			}
		}
		
		System.out.println(T.toString().equals(S.toString()) ? 1 : 0);
	}
}
