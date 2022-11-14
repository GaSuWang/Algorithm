import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.11.14
 * 고층 건물
 * 어디서 잘못된거야
 */
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       int [][] map;
       int[] dx = {1,-1,1,-1,2,2,-2,-2};
       int[] dy = {2,2,-2,-2,1,-1,1,-1};
       StringTokenizer st;
       Queue<int[]> queue;
       for(int t=0; t<T;t++) {
    	   int N = Integer.parseInt(br.readLine());
    	   map = new int[N][N];
    	   for(int i=0; i<N;i++) {
    		   Arrays.fill(map[i],Integer.MAX_VALUE);
    	   }
    	   st = new StringTokenizer(br.readLine());
    	   int kY = Integer.parseInt(st.nextToken());
    	   int kX = Integer.parseInt(st.nextToken());
    	   st = new StringTokenizer(br.readLine());
    	   int targetY = Integer.parseInt(st.nextToken());
    	   int targetX = Integer.parseInt(st.nextToken());
    	   map[kY][kX] = 0;
    	   queue = new LinkedList<int[]>();
    	   queue.offer(new int[] {kY,kX,0});
    	   while(!queue.isEmpty()) {
    		   int [] cur = queue.poll();
    		   if(cur[0]==targetY&&cur[1]==targetX) {
    			   System.out.println(cur[2]);
    			   break;
    		   }
    		   for(int i=0; i<8;i++) {
    			   int nextX = cur[1] +dx[i];
    			   int nextY = cur[0] +dy[i];
    			   if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
    			   if(map[nextY][nextX]!=Integer.MAX_VALUE) continue;
    			   queue.offer(new int[] {nextY,nextX,cur[2]+1});
    			   map[nextY][nextX] = cur[2]+1;
    		   }
    	   }
       }
    }
}