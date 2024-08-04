import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        N /= 100;
        N *= 100;
        int F = Integer.parseInt(in.readLine());
        int ans = 0;

        while (N % F != 0) {
            N++;
            ans++;
        }
        if (ans < 10) {
            System.out.print("0" + ans);
        } else {
            System.out.print(ans);
        }
	}
}
