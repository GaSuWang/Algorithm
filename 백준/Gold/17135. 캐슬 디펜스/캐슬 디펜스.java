import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int D;
	
	static int position[];
	static int dy[] = {0,-1,0};
	static int dx[] = {-1,0,1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	int [][] map = new int[N+1][M];
    	position = new int[3];
    	int res = 0;
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	int kill = 0;
    	for(int i=0; i<M;i++) {
    		for(int j=i+1;j<M;j++) {
    			for(int k=j+1;k<M;k++) {
    				position[0] = i;
    				position[1] = j;
    				position[2] = k;
    				kill = 0;
    				int [][] tempMap = copy(map);
    				for(int l=0;l<N;l++) {
    					kill+=attack(tempMap);
    					move(tempMap);
    				}
    				
    				res = Math.max(res,kill);
    			}
    		}
    	}
    		
    	System.out.println(res);
    }
    
    public static int[][] copy(int [][] map){
    	int[][] tempMap = new int[N+1][M];
    	for(int i=0; i<N;i++) {
    		for(int j=0; j<M;j++) {
    			tempMap[i][j] = map[i][j];
    		}
    	}
    	
    	return tempMap;
    }
    
    public static int attack(int [][] tempMap) {
    	//공격
    	int kill = 0;
    	Queue<int []> queue = new LinkedList<>();
    	for(int i=0; i<3;i++) {
    		queue.offer(new int[] {N,position[i],1});
    		outer: while(!queue.isEmpty()) {
        		int cur[] = queue.poll();	
        		for(int j=0; j<3;j++) {
        			int nextY = cur[0] +dy[j];
        			int nextX = cur[1] +dx[j];
        			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
        			if(tempMap[nextY][nextX]==1) {
        				kill++;
        				tempMap[nextY][nextX] = 2;
        				break outer;
        			}
        			else if(tempMap[nextY][nextX]==2) {
        				break outer;
        			}
        			if(cur[2]==D) continue;
        			queue.offer(new int [] {nextY,nextX,cur[2]+1});
        		}
        	}
    		queue.clear();
    	}
    	for(int i=0; i<N;i++) {
    		for(int j=0; j<M;j++) {
    			if(tempMap[i][j]==2) {
    				tempMap[i][j] = 0;
    			}
    		}
    	}
    	return kill;
    }
    
    public static void move(int[][]tempMap) {
    	for(int i = N-1;i>0;i--) {
    		tempMap[i] = tempMap[i-1];
    	}
    	tempMap[0] = new int[M];
    }
}