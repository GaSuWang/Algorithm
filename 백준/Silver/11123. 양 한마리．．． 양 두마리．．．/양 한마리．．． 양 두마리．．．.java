import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	int dx[] = {1,0,-1,0};
    	int dy[] = {0,1,0,-1};
    	for(int t=0;t<T;t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		char map[][] = new char[N][M];
    		for(int i=0; i<N;i++) {
    			map[i] = br.readLine().toCharArray();
    		}
    		
    		Queue<int[]> queue = new LinkedList<int[]>();
    		int res = 0;
    		for(int i=0; i<N;i++) {
    			for(int j=0; j<M;j++) {
    				if(map[i][j] != '#') continue;
    				queue.offer(new int[] {i,j});
    				map[i][j] = 'w';
    				while(!queue.isEmpty()) {
    					int [] cur = queue.poll();
    					for(int k=0; k<4; k++) {
    						int nextX = cur[1] + dx[k];
    						int nextY = cur[0] + dy[k];
    						if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
    						if(map[nextY][nextX]!='#') continue;
    						queue.offer(new int[] {nextY,nextX});
    						map[nextY][nextX]  ='w';
    					}
    				}
    				res ++;
    			}
    		}
    		System.out.println(res);
    		
    	}
    	
    }
    
}
