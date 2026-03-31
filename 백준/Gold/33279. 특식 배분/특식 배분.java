import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] K = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }

        double[] E = new double[N + 1];
        double[] S = new double[N + 1];

        E[0] = 0;
        S[0] = 0;

        for (int i = 1; i <= N; i++) {

        	double sumOfE = S[i - 1];
            if (i - K[i] - 1 >= 0) {
                sumOfE -= S[i - K[i] - 1];
            }
            
            E[i] = 1.0 + (sumOfE / K[i]);
            S[i] = S[i - 1] + E[i];
        }

        System.out.printf("%.10f\n", E[N]);
    }
}
