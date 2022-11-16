import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 0,5 1,3 2,4
		int[][] dice = new int[N][6];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
			int temp = dice[i][5];
			for (int j = 5; j > 3; j--) {
				dice[i][j] = dice[i][j - 1];
			}
			dice[i][3] = temp;
		}
		int top;
		int bottom;
		int res = 0;
		int sum;
		for (int i = 0; i < 6; i++) {
			sum = 0;
			bottom = dice[0][i];
			top = dice[0][(i + 3) % 6];
			sum += findMax(bottom,top,dice[0]);		
			for (int j = 1; j < N; j++) {
				bottom = top;
				top = dice[j][findIndex(bottom,dice[j])];
				sum += findMax(bottom,top,dice[j]);
				
			}
			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
	
	public static int findMax(int bottom, int top, int[]dice) {
		int res = 0;
		for(int i=0; i<6;i++) {
			if(dice[i]==bottom||dice[i]==top) continue;
			res = Math.max(res,dice[i]);
		}
		return res;
	}
	
	public static int findIndex(int bottom,int[]dice) {
		for(int i=0; i<6;i++) {
			if(dice[i]==bottom) {
				return (i+3)%6;
			}
		}
		return -1;
	}

}