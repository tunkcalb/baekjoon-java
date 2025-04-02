import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int minWeight = Integer.MAX_VALUE;
        int maxWeight = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
            maxWeight = Math.max(maxWeight, w);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = 0;
        int left = 0, right = maxWeight;

        while (left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[N + 1];

            if (bfs(start, end, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(int start, int target, int limit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == target) return true;

            for (Node next : graph.get(cur)) {
                if (!visited[next.to] && next.weight >= limit) {
                    visited[next.to] = true;
                    queue.add(next.to);
                }
            }
        }
        return false;
    }
}
