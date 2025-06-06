import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		if(N % 400 == 0 || (N % 4 == 0 && N % 100 != 0)) ans = 1;
		
		System.out.println(ans);
	}
}
