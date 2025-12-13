import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Character> used = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < N; t++) {
            String line = br.readLine();

            int pickIdx = -1;

            boolean start = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == ' ') {
                    start = true;
                    continue;
                }

                if (start) {
                    char key = Character.toUpperCase(c);
                    if (!used.contains(key)) {
                        used.add(key);
                        pickIdx = i;
                        break;
                    }
                    start = false;
                }
            }

            if (pickIdx == -1) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == ' ') continue;

                    char key = Character.toUpperCase(c);
                    if (!used.contains(key)) {
                        used.add(key);
                        pickIdx = i;
                        break;
                    }
                }
            }

            if (pickIdx == -1) {
                sb.append(line).append('\n');
            } else {
                for (int i = 0; i < line.length(); i++) {
                    if (i == pickIdx) sb.append('[');
                    sb.append(line.charAt(i));
                    if (i == pickIdx) sb.append(']');
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
