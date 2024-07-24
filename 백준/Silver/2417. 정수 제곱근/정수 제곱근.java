import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(in.readLine());
		
		long ans = (long) Math.sqrt(n);
		
		if((ans * ans) < n) ans++;
		System.out.println(ans);
	}
}
