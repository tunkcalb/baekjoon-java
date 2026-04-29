import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        long[][] board = new long[m][n];
        long INF = 250000000001L;
        
        for (int i = 0; i < m; i++) Arrays.fill(board[i], INF);
        for (int i = 0; i < drops.length; i++) {
            board[drops[i][0]][drops[i][1]] = i + 1;
        }

        long[][] rowMin = new long[m][n - w + 1];
        for (int i = 0; i < m; i++) {
            rowMin[i] = getSlidingWindowMin(board[i], w);
        }

        long maxVal = -1;
        int resR = 0, resC = 0;

        for (int j = 0; j <= n - w; j++) {
            long[] colData = new long[m];
            for (int i = 0; i < m; i++) colData[i] = rowMin[i][j];
            
            long[] finalMin = getSlidingWindowMin(colData, h);
            
            for (int i = 0; i < finalMin.length; i++) {

                if (finalMin[i] == INF) {
                    
                    if (maxVal < INF || i < resR || (i == resR && j < resC)) {
                        maxVal = INF;
                        resR = i;
                        resC = j;
                    }
                } 

                else if (maxVal < INF) {
                    if (finalMin[i] > maxVal) {
                        maxVal = finalMin[i];
                        resR = i;
                        resC = j;
                    } else if (finalMin[i] == maxVal) {

                        if (i < resR || (i == resR && j < resC)) {
                            resR = i;
                            resC = j;
                        }
                    }
                }
            }
        }
        
        answer[0] = resR;
        answer[1] = resC;
        return answer;
    }

    private long[] getSlidingWindowMin(long[] arr, int k) {
        int len = arr.length;
        long[] result = new long[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) deque.pollLast();
            deque.addLast(i);
            if (i >= k - 1) result[i - k + 1] = arr[deque.peekFirst()];
        }
        return result;
    }
}