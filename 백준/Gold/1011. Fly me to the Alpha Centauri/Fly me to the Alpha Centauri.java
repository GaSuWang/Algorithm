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
