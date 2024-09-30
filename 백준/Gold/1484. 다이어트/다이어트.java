import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = 100000;

        long start = 1;
        long end = 2;

        StringBuilder sb = null;
        while(end < M) {
            long diff = end * end - start * start;
            if(diff == N) {
                if(sb == null) {
                    sb = new StringBuilder().append(end).append("\n");
                }
                else sb.append(end).append("\n");
            }
            if(diff > N) start++;
            else end++;
        }
        if(sb == null) {
            sb = new StringBuilder("-1");
        }
        System.out.println(sb);
    }
}
