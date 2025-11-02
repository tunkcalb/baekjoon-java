import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            int sum = 0;
            double GPA = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                double G = Double.parseDouble(st.nextToken());
                
                sum += C;
                GPA += G * C;
            }
            sb.append(sum).append(" ");
            sb.append(String.format("%.1f", GPA / sum)).append("\n");
        }
        
        System.out.print(sb);
    }
}
