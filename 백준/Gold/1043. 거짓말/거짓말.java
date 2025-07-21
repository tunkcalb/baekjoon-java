import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parents;
    static List<Integer>[] parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> knows = new HashSet<>();
        for (int k = 0; k < K; k++) {
            knows.add(Integer.parseInt(st.nextToken()));
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());

            parties[i] = new ArrayList<>();
            if (J == 0) continue;

            int first = Integer.parseInt(st.nextToken());
            parties[i].add(first);

            for (int j = 1; j < J; j++) {
                int next = Integer.parseInt(st.nextToken());
                parties[i].add(next);
                union(first, next);
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (int know : knows) {
            roots.add(find(know));
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (roots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parents[x] < 0) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[y] = x;
        }
    }
}
