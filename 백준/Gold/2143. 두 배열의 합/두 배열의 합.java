import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(in.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += A[j];
                aList.add(sum);
            }
        }
        for(int i = 0 ; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += B[j];
                bList.add(sum);
            }
        }
        Collections.sort(aList);
        Collections.sort(bList);

        int aLen = aList.size();
        int bLen = bList.size();
        long cnt = 0;
        int left = 0;
        int right = bLen - 1;
        while(left < aLen && right >= 0) {
            long sum = aList.get(left) + bList.get(right);

            if(sum == T) {
                int a = aList.get(left);
                int b = bList.get(right);

                long aCnt = 0;
                long bCnt = 0;
                for(int i = left; i < aLen; i++) {
                    if(aList.get(i) == a) {
                        aCnt++;
                        left++;
                    }
                    else break;
                }

                for(int i = right; i >= 0; i--) {
                    if(bList.get(i) == b) {
                        bCnt++;
                        right--;
                    }
                    else break;
                }

                cnt += aCnt * bCnt;
            }

            else if(sum < T) left++;
            else if(sum > T) right--;
        }
        System.out.println(cnt);
    }
}
