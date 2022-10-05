import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	char map[][] = new char[N][M];
    	for(int i=0;i<N;i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	Queue<int[]> queue = new LinkedList<>();
    	int resV = 0;
    	int resK = 0;
    	int dx[]= {1,0,-1,0};
    	int dy[] = {0,1,0,-1};
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(map[i][j]=='x'||map[i][j]=='#') continue;
    			int v=0,k =0;
    			queue.offer(new int[] {i,j});
    			if(map[i][j]=='v') v++;
    			else if(map[i][j]=='k') k++;
    			map[i][j] = 'x';
    			while(!queue.isEmpty()) {
    				int [] cur = queue.poll();
    				for(int t=0; t<4;t++) {
    					int nextX = cur[1] + dx[t];
    					int nextY = cur[0] + dy[t];
    					if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
    					if(map[nextY][nextX]=='#'||map[nextY][nextX]=='x') continue;
    					else if(map[nextY][nextX]=='v') v++;
    					else if(map[nextY][nextX]=='k') k++;
    					queue.offer(new int[] {nextY,nextX});
    					map[nextY][nextX] = 'x';
    				}
    			}
    			if(v>=k) resV += v;
    			else resK += k;
    		}
    	}
    	System.out.println(resK+" "+resV);
    	
    }
}