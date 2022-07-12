import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int L;
	static int R;
	static int X;
	static int arr[];
	static boolean check[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		check = new boolean[N];
		res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sub(0,1000000001,0,0);
		System.out.println(res);
	}

	private static void sub(int sum, int min, int max, int count) {
		if(count==N) {
			if(sum<L || sum>R) return;
			if(max-min<X) return;
			res++;
			return;
		}
		
		//선택
		sub(sum+arr[count],Math.min(min,arr[count]),Math.max(max, arr[count]),count+1);
		//선택안함
		sub(sum,min,max,count+1);
	}
}



