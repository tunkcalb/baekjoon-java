import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        HashMap<Long, Long> map = new HashMap<>();

        long ans = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(in.readLine());

            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                map.put(num, (long) 1);
            }
            if(map.get(num) > max){
                max = map.get(num);
                ans = num;
            }
            if(map.get(num) == max) {
                if(ans > num) ans = num;
            }
        }
        System.out.println(ans);
    }
}
