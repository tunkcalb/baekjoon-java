import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));
		String reversed = new StringBuilder(binary).reverse().toString();
		
		int ans = Integer.parseInt(reversed, 2);
		
		System.out.println(ans);
	}
}
