import java.io.*;
import java.util.*;

public class Main { // 백준 제출 시 클래스명은 Main으로!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        List<Integer> occupiedPositions = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int preferred = Integer.parseInt(st.nextToken());
            
            int currentPos = preferred;
            

            for (int pos : occupiedPositions) {

                if (currentPos < pos + d && currentPos > pos - d) {

                    if (currentPos >= pos - d + 1) {
                        currentPos = pos + d;
                    }
                }
            }
            
            sb.append(currentPos).append(" ");
            occupiedPositions.add(currentPos);
            Collections.sort(occupiedPositions);
        }
        
        System.out.println(sb.toString().trim());
    }
}
