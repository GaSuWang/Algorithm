import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		int cur = 0;
		boolean flag = true;
		while(S>0&&cur<N) {
			flag = false;
			int max = 0;
			int maxIndex = -1;
			for(int i=cur+1; i<(cur+S>=N?N:cur+S+1);i++) {
				if(arr[cur]<arr[i]&&max<arr[i]) {
					max = arr[i];
					maxIndex = i;
					flag = true;
				}
			}
			if(flag) {
				int temp = arr[maxIndex];
				for(int i=maxIndex;i>cur;i--) {
					arr[i] = arr[i-1];
				}
				arr[cur]  = temp;
				S = S-(maxIndex-cur);
			}
//			System.out.println(Arrays.toString(arr)+"/"+cur+"/"+S);
			cur++;
			
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<N;i++) {
			sb.append(arr[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}
}