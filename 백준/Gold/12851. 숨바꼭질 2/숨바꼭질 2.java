import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N>=K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}
		int check[][] = new int[100001][2]; //[N][0] == 방문횟수, [N][1] == 도달 최소 시간
		Queue<int[]> queue = new LinkedList<int[]>();
		check[N][0] = 1;
		check[N][1] = 0;
		queue.offer(new int[] {N,0,0});
		int min = 100000;
		int count = 0;
		for(int i=0;i<=100000;i++) {
			check[i][1] = 100000;
		}
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			if(cur[0]==K) {
				if(min==cur[1]) {
					count++;
					continue;
				}
				else if(min>cur[1]) {
					count=1;
					min = cur[1];
					continue;
				}
			}
			if(cur[1]>=min) {
				continue;
			}
			
			if(cur[0]*2<=100000&&cur[0]!=0&&check[cur[0]*2][1]>=cur[1]+1) {
				queue.offer(new int[] {cur[0]*2,cur[1]+1,0});
				if(check[cur[0]*2][1]>cur[1]+1) {
					check[cur[0]*2][1] = cur[1]+1;
					check[cur[0]*2][0] = 1;
				}
				else if(check[cur[0]*2][1]==cur[1]+1) {
					check[cur[0]*2][0]++;
				}
			}
			if(cur[0]+1<=100000&&cur[2]!=2&&check[cur[0]+1][1]>=cur[1]+1) {
				queue.offer(new int[] {cur[0]+1,cur[1]+1,1});
				if(check[cur[0]+1][1]>cur[1]+1) {
					check[cur[0]+1][1] = cur[1]+1;
					check[cur[0]+1][0] = 1;
				}
				else if(check[cur[0]+1][1]==cur[1]+1) {
					check[cur[0]+1][0]++;
				}
			}
			if(cur[0]-1>=0&&cur[2]!=1&&check[cur[0]-1][1]>=cur[1]+1) {
				queue.offer(new int[] {cur[0]-1,cur[1]+1,2});
				if(check[cur[0]-1][1]>cur[1]+1) {
					check[cur[0]-1][1] = cur[1]+1;
					check[cur[0]-1][0] = 1;
				}
				else if(check[cur[0]-1][1]==cur[1]+1) {
					check[cur[0]-1][0]++;
				}
			}
		}
		System.out.println(min);
		System.out.println(count);
	}
}