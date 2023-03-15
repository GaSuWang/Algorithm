

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;




public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		int [] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map.put(arr[i], 1);
		}
		Arrays.sort(arr);
		for(int i=N-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				int right = j;
				int left = 0;
				while(right>=left) {
					int sum = arr[j]+arr[left]+arr[right];
					if(sum==arr[i]) {
						System.out.println(arr[i]);
						return;
					}
					else if(sum>arr[i]) right--;
					else left++;
				}
			}
		}
	}
}


