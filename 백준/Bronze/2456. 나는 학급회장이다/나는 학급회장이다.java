import java.io.*;
import java.util.*;

public class Main {

    static class Candidate {
        int id;
        int total;
        int[] cnt = new int[4];

        Candidate(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Candidate[] candidates = new Candidate[3];
        for (int i = 0; i < 3; i++) {
            candidates[i] = new Candidate(i + 1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());
                candidates[j].total += score;
                candidates[j].cnt[score]++;
            }
        }

        Arrays.sort(candidates, (a, b) -> {
            if (a.total != b.total)
                return b.total - a.total;
            if (a.cnt[3] != b.cnt[3])
                return b.cnt[3] - a.cnt[3];
            if (a.cnt[2] != b.cnt[2])
                return b.cnt[2] - a.cnt[2];
            return 0;
        });

        Candidate first = candidates[0];
        Candidate second = candidates[1];

        if (first.total == second.total &&
            first.cnt[3] == second.cnt[3] &&
            first.cnt[2] == second.cnt[2]) {
            System.out.println("0 " + first.total);
        } else {
            System.out.println(first.id + " " + first.total);
        }
    }
}
