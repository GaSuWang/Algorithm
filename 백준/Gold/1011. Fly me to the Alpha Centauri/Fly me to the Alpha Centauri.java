import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		long x,y;
		long [] arr;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			long res = 0;
			long num = y-x;
//			arr = new long[(int) ((num/2)+1)];
//			int cur = 2;
//			arr[1] = num;
//			while(true) {
//				if(arr[1]==1) break;
//				if(arr[1]-1<cur) {
//					cur--;
//					continue;
//				}
//				arr[cur] = arr[cur]+1;
//				arr[1] = arr[1] - cur;
//				cur++;
//			}
//		
//			for(int i=1;i<(int)((num/2)-1);i++) {
//				if(arr[i]==0) break;
//				res+=arr[i];
//			}
			long sum = 0;
			int temp = 1;
			while(sum<num) {
				sum +=temp;
				res++;
				if(res%2==0) {
					temp++;
				}
				
			}
			

			System.out.println(res);
		}
	}
}
