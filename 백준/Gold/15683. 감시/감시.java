import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	static int dx[]= {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int [][] map;
	static int [][] cctv;
	static int [] cctvDirection;
	static int cctvIndex;
	static int N;
	static int M;
	static int res;
    public static void main(String[] args) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	cctv = new int[8][3];
    	cctvDirection = new int[8];
    	cctvIndex = 0;
    	res = N*M;
    	for(int i=0; i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j]!=0&&map[i][j]!=6) {
    				cctv[cctvIndex][0] = map[i][j];
    				cctv[cctvIndex][1] = i;
    				cctv[cctvIndex][2] = j;
    				
    				cctvIndex++;
    			}
    		}
    	}
    	dfs(0);
    	System.out.println(res);
    }
    static void dfs(int num) {
    	if(num == cctvIndex) {
    		checkArea();
    		return;
    	}
    	for(int i=0; i<4;i++) {
    		cctvDirection[num] = i;
    		dfs(num+1);
    	}
    }

    static void checkArea() {
    	int [][] tempMap = new int[N][M];
    	for(int i=0; i<N;i++) {
    		for(int j=0; j<M;j++) {
    			tempMap[i][j] = map[i][j];
    		}
    	}

    	for(int i=0; i<cctvIndex;i++) {
    		int cur = cctv[i][0];
    		int nextX = cctv[i][2];
    		int nextY = cctv[i][1];
    		int dIndex = cctvDirection[i];
    		if(cur ==1) {
    			while(true) {
    				nextX = nextX + dx[dIndex];
    				nextY = nextY + dy[dIndex];
    				if(nextX<0||nextX>=M||nextY<0||nextY>=N) break;
    				if(map[nextY][nextX]==6)break;
    				else if(map[nextY][nextX]==0) tempMap[nextY][nextX] = 7;
    			}
    		}
    		else if(cur==2) {
    			for(int j=0; j<2;j++) {
    				nextX = cctv[i][2];
    	    		nextY = cctv[i][1];
    				while(true) {
        				nextX = nextX + dx[(dIndex+2*j)%4];
        				nextY = nextY + dy[(dIndex+2*j)%4];
        				if(nextX<0||nextX>=M||nextY<0||nextY>=N) break;
        				if(map[nextY][nextX]==6)break;
        				else if(map[nextY][nextX]==0) tempMap[nextY][nextX] = 7;
        			}
    			}
    		}
    		else if(cur==3) {
    			for(int j=0; j<2;j++) {
    				nextX = cctv[i][2];
    	    		nextY = cctv[i][1];
    				while(true) {
        				nextX = nextX + dx[(dIndex+j)%4];
        				nextY = nextY + dy[(dIndex+j)%4];
        				if(nextX<0||nextX>=M||nextY<0||nextY>=N) break;
        				if(map[nextY][nextX]==6)break;
        				else if(map[nextY][nextX]==0) tempMap[nextY][nextX] = 7;
        			}
    			}
    		}
    		else if(cur==4) {
    			for(int j=0; j<3;j++) {
    				nextX = cctv[i][2];
    	    		nextY = cctv[i][1];
    				while(true) {
        				nextX = nextX + dx[(dIndex+j)%4];
        				nextY = nextY + dy[(dIndex+j)%4];
        				if(nextX<0||nextX>=M||nextY<0||nextY>=N) break;
        				if(map[nextY][nextX]==6)break;
        				else if(map[nextY][nextX]==0) tempMap[nextY][nextX] = 7;
        			}
    			}
    		}
    		else if(cur==5) {
    			for(int j=0;j<4;j++) {
    				nextX = cctv[i][2];
    	    		nextY = cctv[i][1];
    				while(true) {
        				nextX = nextX + dx[j];
        				nextY = nextY + dy[j];
        				if(nextX<0||nextX>=M||nextY<0||nextY>=N) break;
        				if(map[nextY][nextX]==6)break;
        				else if(map[nextY][nextX]==0) tempMap[nextY][nextX] = 7;
        			}
    			}
    		}
    		
    	}
    	int tempRes = 0;
    	for(int i=0; i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(tempMap[i][j]==0) tempRes++;
    		}
    	}
    	res = Math.min(res, tempRes);
    }
}