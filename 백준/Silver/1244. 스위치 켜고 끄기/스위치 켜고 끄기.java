import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        int[] switches = new int[num];
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        for(int i = 0; i < num; i++) {
            switches[i] = Integer.parseInt(st.nextToken());    
        }
        
        int studentcnt = Integer.parseInt(in.readLine());
        for (int i = 0; i < studentcnt; i++) {
            st = new StringTokenizer(in.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            
            if(gender == 1) {
                for(int j = 0; j < num; j++) {
                    if((j+1) % number == 0) {
                        if(switches[j] == 0) {
                            switches[j] = 1;
                        }
                        else {
                            switches[j] = 0;
                        }
                    }
                    
                }
            }
            else {
                if(switches[number - 1] == 0) {
                    switches[number - 1] = 1;
                }
                else {
                    switches[number - 1] = 0;
                }
                for (int j = 1; j < num/2; j++) {
                    if(number - 1 + j >= num || number - 1 - j < 0) {
                        break;
                    }
                    if(switches[number - 1 - j] == switches[number - 1 + j]) {
                        if(switches[number - 1 - j] == 0) {
                            switches[number - 1 - j] = 1;
                        }
                        else {
                            switches[number - 1 - j] = 0;
                        }
                        if(switches[number - 1 + j] == 0) {
                            switches[number - 1 + j] = 1;
                        }
                        else {
                            switches[number - 1 + j] = 0;
                        }
                    
                    }
                    else break;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.print(switches[i] + " ");
            if((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}