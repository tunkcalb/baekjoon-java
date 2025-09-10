import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append((n * (n - 1) * (n - 2) / 6 )).append("\n").append(3);
        
        System.out.println(sb);
	}
}
