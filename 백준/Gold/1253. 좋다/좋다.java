import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map <Integer,Integer> map = new HashMap<>();
		int [] arr = new int[N];
		for(int i=0; i<N;i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			map.put(cur, map.getOrDefault(cur, 0)+1);
		}
		Arrays.sort(arr);
		int res = 0;
		int left;
		int right;
		int sum;
		for(int i = 0; i<N;i++) {
			int cur = arr[i];
			if(!map.containsKey(cur)) continue;
			left = 0;
			right = N-1;
			while(left<right) {
				sum = arr[left]+arr[right];
				if(sum<cur) {
					left++;
				}
				else if(sum>cur) {
					right--;
				}
				else {
					if(i == left) {
						left++;
						continue;
					}
                        
                    else if(right == i) {
                    	right--;
                    	continue;
                    }
                        
					res+=map.get(cur);
					map.remove(cur);
					break;
				}
			}
		}
		System.out.println(res);
	}
}
