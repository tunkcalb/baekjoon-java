import java.io.*;
import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 0) continue;
                union(i, j);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            find(i);
            set.add(parents[i]);
        }
        int answer = set.size();
        return answer;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        parents[a] = b;
    }
    
    public int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}