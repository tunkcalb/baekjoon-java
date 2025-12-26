import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        String[] grade = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            grade[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;
            int answerIdx = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (now <= score[mid]) {
                    answerIdx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(grade[answerIdx]).append('\n');
        }

        System.out.println(sb);
    }
}
