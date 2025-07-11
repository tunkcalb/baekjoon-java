import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int count = 0;
        int pattern = 0;
        int i = 1;

        while (i < M - 1) {
            if (line.charAt(i - 1) == 'I' && line.charAt(i) == 'O' && line.charAt(i + 1) == 'I') {
                pattern++;
                if (pattern == N) {
                    count++;
                    pattern--;
                }
                i += 2;
            } else {
                pattern = 0;
                i++;
            }
        }

        System.out.println(count);
    }
}
