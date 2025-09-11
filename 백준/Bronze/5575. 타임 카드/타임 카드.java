import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int sh = Integer.parseInt(st.nextToken()); 
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            int h = eh - sh;
            int m = em - sm;
            int s = es - ss;

            if (s < 0) {
                s += 60;
                m -= 1;
            }

            if (m < 0) {
                m += 60;
                h -= 1;
            }

            sb.append(h).append(" ").append(m).append(" ").append(s).append("\n");
        }

        System.out.print(sb);
    }
}
