import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [][] map = new char [N][M];
		for(int i=0; i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int res = N*M;
		for(int i=0; i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				res = Math.min(res,check(map,i,j));
			}
		}
		System.out.println(res);
	}
	public static int check(char [][] map, int y, int x) {
		int count = 0;
		char check = map[y][x];
		for(int i=y;i<y+8;i++) {
			for(int j=x;j<x+8;j++) {
				if(map[i][j]!=check) {
					count++;
				}
				check = check=='W'?'B':'W';
			}
			check = check=='W'?'B':'W';
		}
		return Math.min(count, 64-count);
	}
	
}