

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] dx = {1,0,-1,0};
		int [] dy = {0,-1,0,1};
		int [] lineCount = {1,2,4,8,16,32,64,128,256,512,1024};
		int fullDir [][] = new int[4][2048];
		boolean [][] map = new boolean[101][101];
		for(int i=0; i<4;i++) {
			fullDir[i][0] = i;
		}
		for(int i=0; i<4;i++) {
			int last = 0;
			for(int j=0;j<11;j++) {
				int count=0;
				for(int k=0;k<lineCount[j];k++) {
					fullDir[i][last+1+k] = (fullDir[i][last-k]+1)%4;
					count++;
				}
				last+=count;
			}
		}
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			map[y][x] = true;
			for(int j=0;j<lineCount[gen];j++) {
				x = x + dx[fullDir[dir][j]];
				y = y + dy[fullDir[dir][j]];
				map[y][x] = true;
			}
		}
		int res  =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1])
					res++;
			}
		}
		System.out.println(res);
		
		
	}
}


