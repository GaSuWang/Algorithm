import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
	static String input;
	static List<String> res;
	static List<int[]> pairs;
	static int N;
	static boolean check[];
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = 0;
		res = new ArrayList<>();
		pairs = new ArrayList<>();
		for(int i=0; i<input.length();i++) {
			if(input.charAt(i)=='(') {
				stack.push(i);
				N++;
			}
			else if(input.charAt(i)==')') {
				pairs.add(new int[] {stack.pop(),i});
			}
		}
		check = new boolean[N];
		dfs(0);
		Collections.sort(res);
		for(int i=0; i<res.size();i++) {
			System.out.println(res.get(i));
		}
	}
	
	public static void dfs(int num) {
		if(num==N) {
			//System.out.println(Arrays.toString(check));
			StringBuilder sb = new StringBuilder();
			boolean flag = false;
			sb.append(input);
			for(int i=0; i<N;i++) {
				if(check[i]) continue;
				sb.replace(pairs.get(i)[0], pairs.get(i)[0]+1, " ");
				sb.replace(pairs.get(i)[1], pairs.get(i)[1]+1, " ");
				flag = true;
			}

			if(!flag) return;
			String resString = sb.toString().replace(" ", "");
			//System.out.println(resString);
			if(!res.contains(resString)) {	
				res.add(resString);
			}
			return;
		}
		dfs(num+1);
		check[num] = true;
		dfs(num+1);
		check[num] = false;
	}
}