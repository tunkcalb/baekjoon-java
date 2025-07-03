import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double R = Double.parseDouble(br.readLine());
		double pi = 3.141593;
		
		StringBuilder sb = new StringBuilder();
		sb.append(R * R * Math.PI).append("\n");
		sb.append(2 * R * R);
		
		System.out.println(sb);
	}
}
