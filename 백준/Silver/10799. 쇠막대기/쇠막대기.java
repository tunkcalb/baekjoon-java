import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int len = line.length();
		
		int size = 0;
		int cnt = 0;
		for(int i = 0; i < len; i++) {
			if(line.charAt(i) == '(') size++;
			else {
				size--;
				if(line.charAt(i - 1) == '(') {
					cnt += size;
				}
				else cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
