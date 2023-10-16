import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(st.nextToken());
            double sum = 0;
            double[] nums = new double[N];
            for (int j = 0; j < N; j++) {
            	nums[j] = Double.parseDouble(st.nextToken());
                sum += nums[j];
            }

            double average = sum / N;
            double cnt = 0;
            
            for(int j = 0; j < N; j++) {
            	if(nums[j] > average) {
            		cnt++;
            	}
            }
            cnt *= 100;
            cnt /= N;
            sb.append(String.format("%.3f", cnt)).append("%\n");
        }
        System.out.println(sb);
    }
}
