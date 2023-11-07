import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0; 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        for(int i=0; i<n&&!pq.isEmpty();i++){
            int cur = pq.poll();
            cur--;
            if(cur!=0){
                pq.offer(cur);    
            }
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();

            answer = answer+ cur * cur;
        }
        return answer;
    }
}