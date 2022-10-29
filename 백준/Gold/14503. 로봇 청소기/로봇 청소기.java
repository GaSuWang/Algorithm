import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		
		//북 동 남 서
		int dx [] = {0,1,0,-1};
		int dy [] = {-1,0,1,0};
		int map[][] = new int[N][M];
		int res = 0;
		for(int i=0; i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[y][x] = 2;
		res++;
		int nextX = x;
		int nextY = y;
		int index = 0;
		outer: while(true) {
			for(int i=1;i<=4;i++) {
				index = d-i<0?d-i+4:d-i;
				nextX = x + dx[index];
				nextY = y + dy[index];
				if(map[nextY][nextX]!=0) continue;
				y = nextY;
				x = nextX;
				map[y][x] = 2;
				res++;
				d = index;
				continue outer;
			}
			//한칸 후진
			nextX = x + (dx[d] * -1);
			nextY = y + (dy[d] * -1);
			if(map[nextY][nextX]==1) break;
			y = nextY;
			x = nextX;
			//
		}
		System.out.println(res);
		
	}
}
