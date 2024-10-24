import java.io.*;
import java.util.*;

class RMQ {
    int n;
    int[] rangeMin;

    public RMQ(int[] array) {
        n = array.length;
        rangeMin = new int[n * 4];
        init(array, 0, n - 1, 1);
    }

    private int init(int[] array, int left, int right, int node) {
        if (left == right) return rangeMin[node] = array[left];
        int mid = (left + right) / 2;
        int leftMin = init(array, left, mid, node * 2);
        int rightMin = init(array, mid + 1, right, node * 2 + 1);
        return rangeMin[node] = Math.min(leftMin, rightMin);
    }

    public int query(int left, int right) {
        return query(left, right, 1, 0, n - 1);
    }

    private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || nodeRight < left) return 1000001;
        if (left <= nodeLeft && nodeRight <= right) return rangeMin[node];
        int mid = (nodeLeft + nodeRight) / 2;
        return Math.min(query(left, right, node * 2, nodeLeft, mid),
                query(left, right, node * 2 + 1, mid + 1, nodeRight));
    }

    public void update(int index, int newValue) {
        update(index, newValue, 1, 0, n - 1);
    }

    private int update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || nodeRight < index) return rangeMin[node];
        if (nodeLeft == nodeRight) return rangeMin[node] = newValue;
        int mid = (nodeLeft + nodeRight) / 2;
        return rangeMin[node] = Math.min(update(index, newValue, node * 2, nodeLeft, mid),
                update(index, newValue, node * 2 + 1, mid + 1, nodeRight));
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        RMQ rmq = new RMQ(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (t == 1) {
                int index = rmq.query(cost - 1, n - 1) - 1;
                if (index == 1000000) {
                	sb.append(-1).append("\n");
                } else {
                    answer[index] = i;
                    sb.append(index + 1).append("\n");
                    rmq.update(index, 1000001);
                }
            } else {
                if (answer[cost - 1] == 0) {
                	sb.append(-1).append("\n");
                } else {
                	 sb.append(answer[cost - 1]).append("\n");
                    answer[cost - 1] = 0;
                    rmq.update(cost - 1, cost);
                }
            }
        }
        System.out.println(sb);
    }
}
