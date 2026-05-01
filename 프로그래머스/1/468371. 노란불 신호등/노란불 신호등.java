class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] periods = new int[n];
        long lcm = 1;

        for (int i = 0; i < n; i++) {
            periods[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = getLCM(lcm, periods[i]);
        }

        // 1초부터 최소공배수 시간까지 탐색
        // 주기가 반복되므로 lcm까지만 확인하면 됩니다.
        for (int t = 1; t <= lcm; t++) {
            boolean allYellow = true;

            for (int i = 0; i < n; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int T = periods[i];

                // 현재 시간 t에서 해당 신호등의 위치 (0-indexed로 계산하기 위해 t-1)
                int currentTimeInCycle = (t - 1) % T;

                // 노란불 구간: G <= 현재위치 < G + Y
                if (!(currentTimeInCycle >= G && currentTimeInCycle < G + Y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) return t;
        }

        return -1;
    }

    // 최소공배수 구하기 위한 GCD 함수
    private long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수 함수
    private long getLCM(long a, long b) {
        return (a * b) / getGCD(a, b);
    }
}