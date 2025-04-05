import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line.matches("(pi|ka|chu)*")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
