import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Truck> queue = new LinkedList<>();
        for(int truck_weight : truck_weights) {
            while(true) {
                if(!queue.isEmpty() && queue.peek().time == time) {
                    Truck truck = queue.poll();
                    sum -= truck.weight;
                }
                if(queue.size() >= bridge_length) {
                    time++;
                    continue;
                }
                if(sum + truck_weight <= weight) {
                    queue.offer(new Truck(time + bridge_length, truck_weight)); 
                    sum += truck_weight;
                    time++;
                    break;
                }
                time++;
            }
        }
        time += bridge_length;
        return time;
    }
}

class Truck {
    int time;
    int weight;
    
    Truck(int time, int weight) {
        this.time = time;
        this.weight = weight;
    }
}
