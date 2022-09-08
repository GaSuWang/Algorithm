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
		int M = Integer.parseInt(br.readLine());
		int arr[] = new int[M];
		int num[] = new int[10-M];
		int res = Math.abs(100-N);
		if(M!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
		}
		int index=0;
		int index2=0;
		for(int i=0;i<10;i++) {
			if(index<M&&i==arr[index]) {
				index++;
				continue;
			}
			num[index2] = i;
			index2++;
		}
		int howLong = 1;
		int temp = N;
		while(temp>=10) {
			temp=temp/10;
			howLong++;
		}
		
		//0번에서 계산 한번 하기
		//res = Math.min(res,1+N);
		Queue<int[]> queue =new LinkedList<int[]>();
		for(int i=0;i<10-M;i++) {
			queue.offer(new int[] {num[i], 1});
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				res = Math.min(res, cur[1]+Math.abs(N-cur[0]));
				if(cur[1]==howLong+1) continue;
				for(int j=0; j<10-M;j++) {
					queue.offer(new int[] {cur[0]*10+num[j],cur[1]+1});
				}
			}
		}
		System.out.println(res);
	}
}
