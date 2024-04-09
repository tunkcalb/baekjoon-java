import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 2; i <= n; i++) {
                int cnt = 0;
                while (n%i==0) {
                    n/=i;
                    cnt++;
                }
                if (cnt != 0)
                    sb.append(i).append(' ').append(cnt).append('\n');
                if (n == 0)
                    break;
            }
        }
        System.out.print(sb);
	}
}
