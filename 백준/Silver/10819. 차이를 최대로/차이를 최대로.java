////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int arr[];
	static boolean check[];
	static int res;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	res = 0;
    	arr = new int[N];
    	check = new boolean[N];
    	for(int i=0; i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i=0;i<N;i++) {
    		check[i] = true;
    		dfs(0,0,arr[i]);
    		check[i] = false;
    	}
    	System.out.println(res);
    }
    public static void dfs(int num, int max, int cur) {
    	if(N-1==num) {
    		res = Math.max(max, res);
    		return;
    	}
    	for(int i=0; i<N;i++) {
    		if(check[i]) continue;
    		check[i] = true;
    		dfs(num+1,max+Math.abs(cur-arr[i]),arr[i]);
    		check[i] = false;
    	}
    }
}