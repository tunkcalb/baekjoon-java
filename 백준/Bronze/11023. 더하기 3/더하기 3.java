import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		
		int len = st.countTokens();
		
		for(int i = 0; i < len; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sum);
	}
}
