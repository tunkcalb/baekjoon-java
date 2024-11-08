import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		String ans = "";
		while((line = in.readLine()) != null) {
			ans += line;
		}
		
		StringTokenizer st = new StringTokenizer(ans, ",");
		
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sum);
	}
}
