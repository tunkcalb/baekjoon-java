import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] adj;
    static boolean[] isLine1; // 1호선 경로 여부
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        isLine1 = new boolean[N + 1];
        findLine1(1, 0, N);

        long line1Count = 0;
        for (int i = 1; i <= N; i++) {
            if (isLine1[i]) line1Count++;
        }
        long M = N - line1Count;

        long totalCases = M * (M - 1) / 2;

        visited = new boolean[N + 1];
        long invalidCases = 0;
        for (int i = 1; i <= N; i++) {
            if (!isLine1[i] && !visited[i]) {
                long subtreeSize = getSubtreeSize(i);
                invalidCases += subtreeSize * (subtreeSize - 1) / 2;
            }
        }

        System.out.println(totalCases - invalidCases);
    }

    static void findLine1(int curr, int prev, int target) {
        path.add(curr);
        if (curr == target) {
            for (int node : path) isLine1[node] = true;
            found = true;
            return;
        }

        for (int next : adj[curr]) {
            if (next != prev && !found) {
                findLine1(next, curr, target);
            }
        }
        path.remove(path.size() - 1);
    }

    static long getSubtreeSize(int curr) {
        visited[curr] = true;
        long size = 1;
        for (int next : adj[curr]) {
            if (!isLine1[next] && !visited[next]) {
                size += getSubtreeSize(next);
            }
        }
        return size;
    }
}
