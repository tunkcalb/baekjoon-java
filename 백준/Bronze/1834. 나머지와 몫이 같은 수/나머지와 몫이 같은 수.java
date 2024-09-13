import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(in.readLine());
        long sum = 0;

        for(int i = 0; i < N; i++) {
            sum += (N + 1) * i;
        }
        System.out.println(sum);
    }
}
