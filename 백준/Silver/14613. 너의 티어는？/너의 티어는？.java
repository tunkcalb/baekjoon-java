import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        double W = Double.parseDouble(st.nextToken());
        double L = Double.parseDouble(st.nextToken());
        double D = Double.parseDouble(st.nextToken());

        int N = 20;
        int M = 60;

        double[][] board = new double[N + 1][M + 20];

        board[0][40] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 20; j <= M; j++) {
                board[i][j - 1] += board[i - 1][j] * L;
                board[i][j + 1] += board[i - 1][j] * W;
                board[i][j] += board[i - 1][j] * D;
            }
        }

        StringBuilder sb = new StringBuilder();
        int term = 10;
        for(int i = 0; i < 5; i++) {
            double sum = 0;
            for(int j = 0; j < term; j++) {
                sum += board[N][20 + (i * term) + j];
            }
            sb.append(String.format("%.8f",sum)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
