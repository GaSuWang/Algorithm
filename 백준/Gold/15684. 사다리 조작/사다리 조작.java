
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int countAdd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		int H = Integer.parseInt(st.nextToken());
		
		countAdd=4;
		boolean [][] map = new boolean[H][N];
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = true;
		}
		
		dfs(map,N,H,0,0,0);
		System.out.println(countAdd==4?-1:countAdd);
	}
	public static void dfs(boolean[][] map, int N, int H, int addLine, int num,int beforeJ) {
		if(countAdd==0) {
			return;
		}
		if(num==4) {
			return;
		}
		if(check(map,N,H)) {
			countAdd = Math.min(countAdd, addLine);
			return;
		}
		if(addLine>=countAdd) return;
		for(int i=0;i<H;i++) {
			for(int j=beforeJ;j<N-1;j++) {
				if(map[i][j]) continue;
				if(j!=0&&map[i][j-1]) continue;
				if(map[i][j+1]) continue;
				map[i][j] = true;
				dfs(map,N,H,addLine+1,num+1,j);
				map[i][j] = false;
			}
		}
		return;
	}
	public static boolean check(boolean[][] map, int N, int H) {
		int curX;
		int curY;
		
		for(int i=0; i<N;i++) {
			curX = i;
			curY = 0;
			while(curY<H) {
				if(map[curY][curX]) {
					curX++;
					curY++;
				}
				else if(curX!=0&&map[curY][curX-1]) {
					curX--;
					curY++;
				}
				else if(!map[curY][curX]) curY++;
				
			}
			if(curX!=i) return false;
		}
		
		return true;
	}
}