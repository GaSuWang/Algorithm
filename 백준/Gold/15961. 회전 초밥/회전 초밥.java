
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int belt[] = new int[N];
		int dish [] = new int[d+1];
		
		int tempRes=1;
		for(int i=0; i<N;i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		dish[c]++;
		for(int i=0;i<k;i++) {
			if(dish[belt[i]]==0) {
				tempRes++;
			}
			dish[belt[i]]++;
		}
		int res = tempRes;
		int start = 0;
		int end = k-1;
		
		for(int i=0;i<N;i++) {
			//앞에꺼 빼고
			dish[belt[start]]--;
			if(dish[belt[start]]==0) tempRes--;
			//뒤에꺼 넣고
			start++;
			end = (end+1)%N;
			if(dish[belt[end]]==0) tempRes++;
			dish[belt[end]]++;
			res = Math.max(res, tempRes);
		}
		System.out.println(res);
	}

}