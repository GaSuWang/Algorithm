import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String [] arr;
	static Set <Character> set;
	static char[] num;
	static int res;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		set = new HashSet<>();
		num = new char[10];
		
		res = 0;
		for(int i=0; i<N;i++) {
			arr[i] = br.readLine();
			char[] temp = arr[i].toCharArray();
			for(int j=0; j<temp.length;j++) {
				set.add(temp[j]);
			}
		}
		
		check = new boolean[26];
		dfs(9);
		System.out.println(res);
		
	}
	static void dfs(int count) {
		if(count==9-set.size()) {
			int tempRes = 0;
			for(int i=0;i<N;i++) {
				char[] temp = arr[i].toCharArray();
				int sum =0;
				for(int j=0;j<temp.length;j++) {
					sum*=10;
					for(int k=9; k>=0;k--) {
						if(num[k]==temp[j]) sum+=k;
					}
				}
				tempRes +=sum;
			}
			res = Math.max(res, tempRes);
			return;
		}
		for(char temp : set) {
			if(check[temp-'A']) continue;
			
			check[temp-'A'] = true;
			num[count] = temp;
			dfs(count -1);
			check[temp-'A'] = false;
		}
	}
}



