

////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int map[][] = new int[N][N];
    	int baby[] = new int[3]; //0 = y, 1= x, 2=size
    	int dx[] = {0,-1,1,0};
    	int dy[] = {-1,0,0,1};
    	for(int i=0; i<N;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j]==9) {
    				baby[0] = i;
    				baby[1] = j;
    				map[i][j]=0;
    			}
    		}
    	}
    	baby[2] = 2;
    	int res = 0;
    	int eatCount =0;
    	Queue<int []> queue = new LinkedList<int[]>();
    	while(true) {
    		boolean isEat = false;
    		boolean check[][] = new boolean[N][N];
    		//먹을수 있는거 탐색
    		queue.offer(new int[] {baby[0],baby[1],0});
    		check[baby[0]][baby[1]] = true;
    		int min = 5000;
    		int target[] = new int[3];
    		
    		while(!queue.isEmpty()) {
    			int [] cur = queue.poll();
    			if(map[cur[0]][cur[1]]!=0&&map[cur[0]][cur[1]]<baby[2]) {
    				if(cur[2]<min) {
    					isEat = true;
    					target[0] = cur[0];
    					target[1] = cur[1];
    					min = cur[2];
    				}
    				else if(cur[2]==min)
    				{
    					if(target[0]>cur[0]) {
    						isEat = true;
        					target[0] = cur[0];
        					target[1] = cur[1];
        					min = cur[2];
    					}
    					else if(target[0]==cur[0]) {
    						if(target[1]>cur[1]) {
    							isEat = true;
            					target[0] = cur[0];
            					target[1] = cur[1];
            					min = cur[2];
    						}
    					}
    				}
    			}
    			
    			for(int i=0; i<4;i++) {
    				int nextX = cur[1] +dx[i];
    				int nextY = cur[0] +dy[i];
    				if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
    				if(check[nextY][nextX]) continue;
    				if(map[nextY][nextX]>baby[2]) continue;
    				queue.offer(new int[] {nextY,nextX,cur[2]+1});
    				check[nextY][nextX] = true;
    			}
    		}
    		queue.clear();
    		if(isEat) {
				map[target[0]][target[1]] = 0;
				baby[0] = target[0];
				baby[1] = target[1];
				//baby[2]++;
				res += min;
				eatCount++;
	    		if(eatCount==baby[2]) {
	    			baby[2]++;
	    			eatCount=0;
	    		}
				//System.out.println(target[0]+" "+target[1]+" /"+baby[2]+" /"+min+" /"+eatCount);
    		}
    		//먹을수 있는게 없으면
    		else break;

    	}
    	System.out.println(res);
    }
}