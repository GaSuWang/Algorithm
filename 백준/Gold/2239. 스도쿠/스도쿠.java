

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] map = new int[9][9];
		for(int i=0; i<9;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=0; j<9;j++) {
				map[i][j]=temp[j]-'0';
			}
		}
		outer: for(int i=0; i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					dfs(i,j,map);
					break outer;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9;i++) {
			for(int j=0; j<9;j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static boolean dfs(int y,int x,int[][] map) {
		if(y==-1) return true;
		List<Integer> list = getNumber(y,x,map);
		if(list.size()==0) return false;
		int nextY=-1;
		int nextX=-1;
		outer: for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(!(i==y&&x==j)&&map[i][j]==0) {
					nextY = i;
					nextX = j;
					break outer;
				}
			}
		}
		//if(nextY==-1) return true;
		
		for(Integer cur : list) {
			map[y][x] = cur;
			if(dfs(nextY,nextX,map)) return true;
		}
		map[y][x] = 0;
		return false;
	}
	
	public static List<Integer> getNumber(int y, int x, int[][]map){
		List<Integer> res = new ArrayList<Integer>();
		boolean [] numlist = new boolean[10];
		//x check
		//y check
		for(int i=0;i<9;i++) {
			numlist[map[y][i]] = true;
			numlist[map[i][x]] = true;
		}
		//3x3 check
		int divY = y/3;
		int divX = x/3;
		for(int i=3*divY;i<3*divY+3;i++) {
			for(int j=3*divX;j<3*divX+3;j++) {
				numlist[map[i][j]] = true;
			}
		}
		
		for(int i=0;i<10;i++) {
			if(numlist[i]) continue;
			res.add(i);
		}

		return res;
	}
}


