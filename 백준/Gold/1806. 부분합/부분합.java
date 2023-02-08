
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int res = 100001;
		int sum = 0;
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		//right >=N and sum이 S보다 작으면
		while(right<N||sum>=S) {
			if(sum>=S) {
				res = Math.min(right-left, res);
				sum-=arr[left];
				left++;
				
			}
			else {
				sum+=arr[right];
				right++;
			}
		}
		System.out.println(res==100001?0:res);
		
	}
}