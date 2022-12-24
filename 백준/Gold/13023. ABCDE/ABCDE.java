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
		int M = Integer.parseInt(st.nextToken());
		List<Integer> [] arr = new ArrayList[N];
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(arr[a]==null) {
				arr[a] = new ArrayList<Integer>();
			}
			if(arr[b]==null) {
				arr[b] = new ArrayList<Integer>();
			}
			arr[a].add(b);
			arr[b].add(a);
		}
		boolean check[];
		for(int i=0; i<N;i++) {
			check = new boolean[N];
			check[i] =true;
			if(dfs(arr, check, 0, i)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	public static boolean dfs(List<Integer> [] arr, boolean[] check, int num, int cur) {
		if(num==4) {
			return true;
		}
		if(arr[cur]==null) return false;
		for(int i=0; i< arr[cur].size();i++) {
			int next = arr[cur].get(i);
			if(check[next]) continue;
			check[next] = true;
			if(dfs(arr,check,num+1,next)) return true;
			check[next] = false;
		}
		return false;
	}
}