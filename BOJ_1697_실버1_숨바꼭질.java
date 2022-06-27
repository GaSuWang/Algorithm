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

	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList<>();
		boolean [] check = new boolean[100001];
		int res = 1000000;
		if(N>K) {
			System.out.println(N-K);
		}
		else {
			check[N] = true;
			queue.offer(new int[] {N,0});
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(cur[0]==K) {
					res = Math.min(res, cur[1]);
				}
				if(cur[1]>=res) continue;
				
				if(cur[0]*2<=100000&&!check[cur[0]*2]) {
					queue.offer(new int [] {cur[0]*2,cur[1]+1});
					check[cur[0]*2] = true;
				}
				if(cur[0]+1<=100000 && !check[cur[0]+1]) {
					queue.offer(new int [] {cur[0]+1,cur[1]+1});
					check[cur[0]+1] = true;
				}
				if(cur[0]-1>=0 && !check[cur[0]-1]) {
					queue.offer(new int [] {cur[0]-1,cur[1]+1});
					check[cur[0]-1] = true;
				}
			}
			System.out.println(res); 	
		}
		
	}
}
                                        