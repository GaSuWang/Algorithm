import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		outer: for(int i=0; i<N;i++) {
			if(arr[i]==1) continue;
			for(int j=2; j<arr[i];j++) {
				if(arr[i]%j==0) continue outer;
			}
			count++;
		}
		System.out.println(count);
		
	}
}



