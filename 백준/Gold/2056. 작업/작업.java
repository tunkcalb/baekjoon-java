import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] time;
    static int[] cnt;
    static List<List<Integer>> board;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        time = new int[N + 1];
        cnt = new int[N + 1];
        board = new ArrayList<>();
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                int dependency = Integer.parseInt(st.nextToken());
                board.get(dependency).add(i);
                cnt[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
                result[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : board.get(current)) {
                cnt[next]--;
                result[next] = Math.max(result[next], result[current] + time[next]);

                if (cnt[next] == 0) {
                    q.offer(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}
