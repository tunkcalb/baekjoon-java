import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));


    }
    public static String solution(String sentance){
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for (int i = 0; i < sentance.length(); i++){
            if(sentance.charAt(i) == ucpc[index]){
                index++;
            }

        if (index == 4){
            return "I love UCPC";
        }
        }
        return "I hate UCPC";
    }
}