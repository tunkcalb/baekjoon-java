import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        System.out.print(num_count(N));
    }

    public static int num_count(int num){
        int cnt = 0;
        if(num < 100){
            return num;
        }
        else{
            cnt = 99;

            for (int i = 100; i <= num; i++){
                int first = i / 100;
                int second = ( i / 10) % 10;
                int third = i % 10;
                if ((first - second) == (second - third)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}