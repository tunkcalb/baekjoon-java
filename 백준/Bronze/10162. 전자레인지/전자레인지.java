import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int a = 300;
		int b = 60;
		int c = 10;
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(T / a).append(" ");
		T %= a;
		sb.append(T / b).append(" ");
		T %= b;
		sb.append(T / c);
		if(T % c == 0) System.out.println(sb);
		else System.out.println(-1);
    }
}
