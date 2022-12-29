
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long min;
	static long max;
	static String resMin;
	static String resMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String[] symbol = br.readLine().split(" ");
		boolean check[] = new boolean[10];
		min = 9999999999L;
		max = -1;
		resMin = "";
		resMax = "";
		for(int i=0; i<10;i++) {
			check[i] = true;
			StringBuilder sb= new StringBuilder();
			dfs(check,symbol,K,0,sb.append(i));
			check[i] = false;
		}
		System.out.println(resMax);
		System.out.println(resMin);
	}
	public static void dfs(boolean [] check, String[] symbol,int K, int num, StringBuilder sb) {
		if(num==K) {
			if(min>Long.parseLong(sb.toString())) {
				resMin = sb.toString();
				min = Long.parseLong(sb.toString());
			}
			if(max<Long.parseLong(sb.toString())) {
				resMax = sb.toString();
				max = Long.parseLong(sb.toString());
			}
			return;
		}
		int before = (int)sb.charAt(sb.length()-1)-'0';
		if(symbol[num].equals("<")) {
			for(int i=before+1;i<10;i++) {
				if(check[i]) continue;
				check[i] = true;
				dfs(check,symbol,K,num+1,sb.append(i));
				sb.deleteCharAt(sb.length()-1);
				check[i] = false;
			}
		}
		else {
			for(int i=0;i<before;i++) {
				if(check[i]) continue;
				check[i] = true;
				dfs(check,symbol,K,num+1,sb.append(i));
				sb.deleteCharAt(sb.length()-1);
				check[i] = false;
			}
		}
		
	}
	
}