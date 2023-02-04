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
        ArrayList<Integer> line = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            line.add(num);
        }
        Collections.sort(line);
        for (int value: line) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}