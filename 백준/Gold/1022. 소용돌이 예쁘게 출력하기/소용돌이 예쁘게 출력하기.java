import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int mapW = Math.abs(c1-c2)+1;
		int mapH = Math.abs(r1-r2)+1;
		int map[][] = new int[mapH][mapW];
		int cnt=0;
		int maxCnt = mapH * mapW;
		int level = 0;
		int num = 1;
		int r = 0;
		int c = 0;
		int mX = 0-c1;
		int mY = 0-r1;
		int maxLen = 1;
		if(0>=r1&&0>=c1&&0<=r2&&0<=c2) {
			map[mY][mX] = 1;
			cnt++;
		}
		while(cnt<maxCnt) {
			for(int i=0; i<4;i++) {
				for(int j=0;j<level*2-(i==0?1:0);j++) {
					num++;
					if(i==0) {
						r--;
					}
					else if(i==1) {
						c--;
					}
					else if(i==2) {
						r++;
					}
					else if(i==3) {
						c++;
					}
					
					if(r>=r1&&c>=c1&&r<=r2&&c<=c2) {
						//그 자리에 채우기
						map[r+mY][c+mX] = num;
						maxLen = Math.max(maxLen, Integer.toString(num).length());
						cnt++;
					}
				}
			}
			level++;
			c++;
			num++;
			if(r>=r1&&c>=c1&&r<=r2&&c<=c2) {
				//그 자리에 채우기
				map[r+mY][c+mX] = num;
				maxLen = Math.max(maxLen, Integer.toString(num).length());
				cnt++;
			}
		}
		StringBuilder sb = null;
		for(int i=0; i<mapH;i++) {
			for(int j=0; j<mapW;j++) {
				sb = new StringBuilder();
				int forNum = maxLen - Integer.toString(map[i][j]).length();
				for(int k =0; k<forNum;k++) {
					sb.append(' ');
				}
				sb.append(map[i][j]);
				sb.append(' ');
				System.out.print(sb.toString());
			}
			System.out.println();
		}
			

	}
}
