////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];
		for(int i=0;i<12;i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean flag = true;
		int res = 0;
		while(flag) {
			flag = bfs(map);
			move(map);
			res++;
//			for(int i=0;i<12;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("--------------");
		}
		System.out.println(res-1);
	} 
	
	public static void move(char[][]map) {
		for(int i=11;i>=1;i--) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') continue;
				for(int k=i-1;k>=0;k--) {
					if(map[k][j]!='.') {
						map[i][j] = map[k][j];
						map[k][j] = '.';
						break;
					}
				}
				
			}
		}
	}
	
	public static boolean bfs(char[][] map) {
		boolean flag=false;
		boolean [][] check = new boolean[12][6];
		Queue<int[]> queue = new LinkedList<int[]>();
		Stack<int[]> list = new Stack<int[]>();
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j]=='.'||check[i][j]) continue;
				check[i][j] = true;
				list.add(new int[] {i,j});
				queue.add(new int[] {i,j});
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					for(int k=0; k<4;k++) {
						int nextX = cur[1] + dx[k];
						int nextY = cur[0] + dy[k];
						if(nextX<0||nextX>=6||nextY<0||nextY>=12) continue;
						if(map[nextY][nextX]!=map[cur[0]][cur[1]])continue;
						if(check[nextY][nextX]) continue;
						check[nextY][nextX] = true;
						list.add(new int[] {nextY,nextX});
						queue.add(new int[] {nextY,nextX});
					}
				}
				if(list.size()>=4) {
					flag = true;
					while(!list.isEmpty()) {
						int [] del = list.pop();
						map[del[0]][del[1]] = '.';
					}
				}
				else {
					list.clear();
				}
			}
		}
		return flag;
	}
	
}