import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(String line : record) {
            StringTokenizer st = new StringTokenizer(line);
            
            String command = st.nextToken();
            if(command.equals("Enter")) {
                String uid = st.nextToken();
                String nickname = st.nextToken();
                map.put(uid, nickname);
                list.add(uid);
            }
            else if (command.equals("Leave")) {
                String uid = st.nextToken();
                list.add(uid);
            }
            else {
                String uid = st.nextToken();
                String nickname = st.nextToken();
                map.put(uid,nickname);
            }
        }
        
        String[] answer = new String[list.size()];
        HashSet<String> records = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            String uid = list.get(i);
            String nickname = map.get(uid);
            if(!records.contains(uid)) {
                records.add(uid);
                answer[i] = nickname + "님이 들어왔습니다.";
            }
            else {
                records.remove(uid);
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}