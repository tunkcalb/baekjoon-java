import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
    private static BigInteger[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println(0);
        }else if(N == 1){
            System.out.println(1);
        }
        if (N >= 2) {
            nums = new BigInteger[N + 1];
            nums[0] = BigInteger.valueOf(0);
            nums[1] = BigInteger.valueOf(1);
            for (int i = 2; i <= N; i++) {
                nums[i] = nums[i - 1].add(nums[i - 2]);
            }
            System.out.println(nums[N]);
        }


    }
}