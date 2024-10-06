import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();
        int N = 36;

        boolean isValid = true;
        String start = in.readLine();
        set.add(start);

        int sr = start.charAt(0) - 'A';
        int sc = start.charAt(1) - '1';

        int pr = sr, pc = sc;

        for (int i = 1; i < N; i++) {
            String line = in.readLine();
            if (set.contains(line)) {
                isValid = false;
                break;
            }
            set.add(line);

            int cr = line.charAt(0) - 'A';
            int cc = line.charAt(1) - '1';

            if (!((Math.abs(pr - cr) == 2 && Math.abs(pc - cc) == 1) || (Math.abs(pr - cr) == 1 && Math.abs(pc - cc) == 2))) {
                isValid = false;
                break;
            }

            pr = cr;
            pc = cc;
        }

        int er = start.charAt(0) - 'A';
        int ec = start.charAt(1) - '1';

        if (!((Math.abs(pr - er) == 2 && Math.abs(pc - ec) == 1) || (Math.abs(pr - er) == 1 && Math.abs(pc - ec) == 2))) {
            isValid = false;
        }

        if (isValid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
