import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger N = new BigInteger(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(N.multiply(N).multiply(N)).append("\n");
		sb.append(3);
		
		System.out.println(sb);
	}
}
