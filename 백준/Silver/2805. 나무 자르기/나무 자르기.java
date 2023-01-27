import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] trees = new int[N];
		long left = 0;
		long right = 0;
		long mid=0;
		long res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(trees[i],right);
		}
		while(left<=right) {
			mid = (left+right)/2;
			
			long checkRes = check(trees,mid,N);
			if(checkRes>=M) {
				left = mid+1;
				res = mid;
			}
			else if(checkRes<M){
				right = mid-1;
			}
			
		}
		System.out.println(res);
		
	}
	public static long check(int[] trees, long mid,int N) {
		long total = 0;
		for(int i=0; i<N;i++) {
			if(trees[i]>mid) total+= trees[i] - mid;
		}
		return total;
	}
}
