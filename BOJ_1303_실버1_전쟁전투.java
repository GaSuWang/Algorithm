import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][]map;
	static boolean [][] check;
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		check = new boolean[M][N];
		for(int i=0; i<M;i++) {
			char [] arr = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				if(arr[j]=='W') {
					map[i][j] =0;
				}
				else {
					map[i][j] = 1;
				}
			}
		}
		int resW =0;
		int resB =0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]) continue;
				check[i][j] = true;
				int temp = dfs(i,j,1);
				if(map[i][j]==0) {
					resW += temp*temp;
				}
				else {
					resB += temp*temp;
				}
			}
		}
		System.out.println(resW+" "+resB);
	}

	private static int dfs(int y, int x,int count) {
		for(int i=0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0||nextX>=N||nextY<0||nextY>=M) continue;
			if(check[nextY][nextX]) continue;
			if(map[y][x] != map[nextY][nextX]) continue;
			check[nextY][nextX] = true;
			count = dfs(nextY,nextX,count+1);
		}
		
		return count;
	}
}
