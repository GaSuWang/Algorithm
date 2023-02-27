

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = (int) (Math.pow(2, N+1)-2);
		int [] arr = new int [num+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i=1;
		int max = 0;
		int sum =0;
		for(;i<=2;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i],max);
			sum += arr[i];
		}
		for(;i<=num;i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = arr[(i-1)/2]+input;
			max = Math.max(arr[i],max);
			sum += input;
		}
		int [] sumArr = new int [num+1];
		int index = num;
		int size = (int)Math.pow(2,N);
		while(size>0) {
			int diff1 = (max-arr[index]);
			int diff2 = (max-arr[index-1]);
			int min = Math.min(diff1, diff2);
			int add1 = diff1-min;
			int add2 = diff2-min;
			sum+=add1;
			sum+= add2;
			sumArr[(index-1)/2] = min;
			size-=2;
			index-=2;
		}
		while(index>2) {
			int min = Math.min(sumArr[index],sumArr[index-1]);
			sum+=(sumArr[index]-min);
			sum+=(sumArr[index-1]-min);
			sumArr[(index-1)/2] = min;
			index-=2;
		}
		sum+=sumArr[1];
		sum+=sumArr[2];
		System.out.println(sum);
	}
}


