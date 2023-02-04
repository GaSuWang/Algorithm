import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean check [] = new boolean[N+1];
		dfs(N,check,"",0);
	}
	public static void dfs(int N,boolean[] check, String res, int num) {
		if(num==N) {
			System.out.println(res);
			return;
		}
		for(int i=1;i<=N;i++) {
			if(check[i]) continue;
			check[i] = true;
			dfs(N,check,res+i+" ",num+1);
			check[i] = false;
		}
	}

}
