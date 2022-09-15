////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       boolean knowTruth[] = new boolean[N+1];
       st = new StringTokenizer(br.readLine());
       int K = Integer.parseInt(st.nextToken());
       Queue<Integer> queue = new LinkedList<Integer>();
       for(int i=0;i<K;i++) {
    	   int num = Integer.parseInt(st.nextToken());
    	   knowTruth[num] = true;
    	   queue.offer(num);
       }
       boolean map[][] = new boolean[N+1][N+1];
       int party[][] = new int[M][N+1];
       for(int i=0; i<M;i++) {
    	   st = new StringTokenizer(br.readLine());
    	   party[i][0] = Integer.parseInt(st.nextToken());
    	   for(int j=1; j<=party[i][0];j++) {
    		   party[i][j] = Integer.parseInt(st.nextToken());
    	   }
    	   for(int j=1;j<=party[i][0];j++) {
    		   for(int k=1;k<=party[i][0];k++) {
    			   if(j==k) continue;
    			   map[party[i][j]][party[i][k]] = true;
    			   map[party[i][k]][party[i][j]] = true;
    		   }
    	   }
       }
       int res = M;
       while(!queue.isEmpty()) {
    	   int cur = queue.poll();
    	   for(int i=1; i<=N;i++) {
    		   if(map[cur][i] && !knowTruth[i]) {
    			   queue.offer(i);
    			   knowTruth[i] = true;
    		   }
    	   }
       }
       outer: for(int i=0; i<M;i++) {
    	   for(int j=1; j<=party[i][0];j++) {
    		   if(knowTruth[party[i][j]]) {
    			   res--;
    			   continue outer;
    		   }
    	   }
    	   
       }
       System.out.println(res);
       
    
       
    }
}