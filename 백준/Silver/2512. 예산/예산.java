import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
			max = Math.max(arr[i], max);
		}
		int limit = Integer.parseInt(br.readLine());
		if(sum<=limit) {
			System.out.println(max);
			return;
		}
		int left = 0;
		int right = max;
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if(check(arr,mid,N,limit)) {
				left = mid+1;
			}
			else right = mid-1;
		}
		System.out.println(right);
	}
	public static boolean check(int [] arr, int mid, int N, int limit) {
		int sum =0;
		for(int i=0; i<N;i++) {
			sum += (arr[i]<mid?arr[i]:mid);
//			if(arr[i]<mid) sum+= arr[i];
//			else sum+=mid;
		}
		if(sum<=limit) return true;
		else return false;
		
	}
	
}
