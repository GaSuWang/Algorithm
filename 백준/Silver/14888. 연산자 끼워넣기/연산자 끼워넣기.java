////
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int sym[] = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			sym[i] = Integer.parseInt(st.nextToken());
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		//+-*/
		for(int i=0;i<4;i++) {
			if(sym[i]==0) continue;
			if(i==0) queue.offer(new int[] {sym[0]-1,sym[1],sym[2],sym[3],2,arr[0]+arr[1]});
			if(i==1) queue.offer(new int[] {sym[0],sym[1]-1,sym[2],sym[3],2,arr[0]-arr[1]});
			if(i==2) queue.offer(new int[] {sym[0],sym[1],sym[2]-1,sym[3],2,arr[0]*arr[1]});
			if(i==3) queue.offer(new int[] {sym[0],sym[1],sym[2],sym[3]-1,2,arr[0]/arr[1]});
		}
		int min = 1000000000;
		int max = -1000000000;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(cur[4]==N) {
				min = Math.min(min,cur[5]);
				max = Math.max(max,cur[5]);
				continue;
			}
			for(int i=0;i<4;i++) {
				if(cur[i]==0) continue;
				if(i==0) queue.offer(new int[] {cur[0]-1,cur[1],cur[2],cur[3],cur[4]+1,cur[5]+arr[cur[4]]});
				if(i==1) queue.offer(new int[] {cur[0],cur[1]-1,cur[2],cur[3],cur[4]+1,cur[5]-arr[cur[4]]});
				if(i==2) queue.offer(new int[] {cur[0],cur[1],cur[2]-1,cur[3],cur[4]+1,cur[5]*arr[cur[4]]});
				if(i==3) queue.offer(new int[] {cur[0],cur[1],cur[2],cur[3]-1,cur[4]+1,cur[5]/arr[cur[4]]});
			}
			
		}
		System.out.println(max);
		System.out.println(min);
	}
}