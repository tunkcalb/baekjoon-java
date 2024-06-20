import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		
		int ans = 1;
		for(int i = 0; i < line.length(); i++) {
			int cnt = 0;
			if(line.charAt(i) == 'c') {
				cnt = 26;
			}else cnt = 10;
			
			if(i > 0 && line.charAt(i) == line.charAt(i - 1)) {
				cnt--;
			}
			ans *= cnt;
		}
		System.out.println(ans);
	}
}
