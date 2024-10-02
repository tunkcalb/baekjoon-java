import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N * M];

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String line = in.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                p[i * M + j] = i * M + j;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int ni = i;
                int nj = j;
                if(board[i][j] == 'D') ni++;
                else if(board[i][j] == 'U') ni--;
                else if(board[i][j] == 'L') nj--;
                else nj++;

                union(i * M + j, ni * M + nj);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                set.add(find(i * M + j));
            }
        }
        System.out.println(set.size());
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        p[A] = B;
    }

    static int find(int a) {
        if(p[a] == a) return a;
        else return p[a] = find(p[a]);
    }
}
