////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	static int res;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
      char map[][] = new char[N][M];
       
       res = 0;
       for(int i=0; i<N;i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j=0; j<M;j++) {
    		   map[i][j] = st.nextToken().charAt(0);
    	   }
    	   
       }
       for(int i=0; i<N;i++) {
    	   for(int j=0; j<M;j++) {
    		   if(map[i][j]!='0') continue;
    		   map[i][j] = '1';
    		   for(int k=i;k<N;k++) {
    			   for(int l=i==k?j+1:0;l<M;l++) {
    				   if(map[k][l]!='0') continue;
    				   map[k][l] = '1';
    				   for(int m=k;m<N;m++) {
    					   for(int n = m==k?l+1:0;n<M;n++) {
    						   if(map[m][n]!='0') continue;
    						   map[m][n] = '1';
    						   char[][] tempMap = clone(map);
    						   bfs(tempMap);
    						   map[m][n] = '0';
    					   }
    				   }
    				   map[k][l] = '0';
    			   }
    		   }
    		   map[i][j] = '0';
    	   }
       }
       System.out.println(res);
    }
    private static char[][] clone(char[][] map) {
		char[][] res = new char[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				res[i][j] = map[i][j];
			}
		}
		return res;
	}
	static void bfs(char [][] map) {
    	Queue<int []> queue = new LinkedList<int[]>();
    	for(int i =0; i<N;i++) {
    		for(int j=0; j<M;j++) {
    			if(map[i][j]!='2') continue;
    			queue.offer(new int[] {i,j});
    		}
    	}
    	while(!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		for(int i=0; i<4;i++) {
    			int nextX = cur[1] + dx[i];
    			int nextY = cur[0] + dy[i];
    			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
    			if(map[nextY][nextX]!='0') continue;
    			queue.offer(new int[] {nextY,nextX});
    			map[nextY][nextX] = '2';
    		}
    	}
    	int temp = 0;
    	for(int i=0; i<N;i++) {
    		for(int j=0; j<M;j++) {
    			if(map[i][j]!='0') continue;
    			temp++;
    		}
    	}
    	res = Math.max(res,temp);
    	
    }
}