import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean check [] = new boolean[n];
        
        for(int i=0; i<n;i++){
            if(check[i]) continue;
            queue.offer(i);
            check[i] = true;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int j=0; j<n;j++){
                    if(check[j]) continue;
                    if(computers[cur][j]==1){
                        queue.offer(j);
                        check[j] = true;
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
}