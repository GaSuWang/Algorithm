import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,res;
	static char[][] map;
	static boolean[][] check;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		res = 0;
		map = new char[N][M];
		check = new boolean[N][M];
		check[N-1][0] = true;
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(N-1,0,0);
		System.out.println(res);
	}
	public static void dfs(int y, int x, int num) {
		if(num==K-1) {
			if(y==0&&x==M-1) {
				res++;
			}
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
			if(map[nextY][nextX]=='T') continue;
			if(check[nextY][nextX]) continue;
			check[nextY][nextX] = true;
			dfs(nextY,nextX,num+1);
			check[nextY][nextX] = false;
		}
	}
}