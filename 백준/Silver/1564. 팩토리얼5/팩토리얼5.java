import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(in.readLine());
        long ans = 1;
        long m = Long.parseLong("1000000000000");

        for(long i = 1; i <= n; i++) {
        	ans *= i;
            while(ans % 10 == 0) ans /= 10;
            ans %= m;
        }
        StringBuilder sb = new StringBuilder();
        
        ans %= 100000;
        if(ans / 10000 == 0) sb.append(0);
        if(ans / 1000 == 0) sb.append(0);
        if(ans / 100 == 0) sb.append(0);
        if(ans / 10 == 0) sb.append(0);
        sb.append(ans);
		System.out.println(sb);
	}
}
