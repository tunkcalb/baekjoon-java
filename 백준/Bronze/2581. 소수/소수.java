import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(in.readLine());
        int N = Integer.parseInt(in.readLine());
        
        boolean[] isNotPrime = new boolean[N + 1];
        
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        int sum = 0;
        int min = 0;
        
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                if (min == 0) {
                    min = i;
                }
            }
        }
        
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
