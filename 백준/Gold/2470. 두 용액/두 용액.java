import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N-1;
		int middle = 0;
		for(int i=0;i<N;i++) {
			if(arr[start+i]>=0) {
				middle = i;
				break;
			}
			else if(arr[end-i]<=0) {
				middle = i;
				break;
			}
		}
		if(middle==0) {
			if(arr[0]>=0) {
				System.out.println(arr[0]+" "+arr[1]);
				return;
			}
			else {
				System.out.println(arr[N-2]+" "+arr[N-1]);
				return;
			}
		}
		int min = 2_000_000_000;
		int res1 = 0;
		int res2 = 0;
		start = 0;
		end = N-1;
		for(int i=0; i<N;i++) {
			int temp = arr[start]+arr[end];
			if(Math.abs(temp)<min) {
				res1 = arr[start];
				res2 = arr[end];
				min = Math.abs(temp);
			}
			if(temp<0) {
				start++;
			}
			else if(temp>0) {
				end--;
			}
			else {
				System.out.println(res1+" "+res2);
				return;
			}
			if(start>=end) break;
		}
		System.out.println(res1+" "+res2);
	}
}