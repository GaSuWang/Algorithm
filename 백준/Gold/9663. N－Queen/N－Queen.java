
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int res;
	static int N;
	static int map[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		dfs( 0);
		System.out.println(res);
	}

	public static void dfs(int num) {
		if (num == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			map[num] = i;
			if(check(num)) {
				dfs(num+1);
			}
		}

	}

	public static boolean check(int num) {
		boolean res = true;
		for(int i=0;i<num;i++) {
			if(map[i]==map[num]) return false;
			if(Math.abs(num-i)==Math.abs(map[num]-map[i])) return false;
		}
		return res;
	}
}