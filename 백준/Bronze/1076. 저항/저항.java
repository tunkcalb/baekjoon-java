import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> value = new HashMap<>();
		value.put("black", 0);
		value.put("brown", 1);
		value.put("red", 2);
		value.put("orange", 3);
		value.put("yellow", 4);
		value.put("green", 5);
		value.put("blue", 6);
		value.put("violet", 7);
		value.put("grey", 8);
		value.put("white", 9);
		
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		long v1 = value.get(a);
		long v2 = value.get(b);
		long n = value.get(c);

		StringBuilder sb = new StringBuilder();
		sb.append((v1 * 10 + v2) * (long) Math.pow(10, n));
		
		System.out.println(sb);
	}
}
