
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start =br.readLine();
		String target = br.readLine();
		int res = 0;
		int iter = target.length() - start.length();
		StringBuilder sb = new StringBuilder(target);
		for(int i=0; i<iter;i++) {		
			if(sb.charAt(sb.length()-1)=='B') {
				sb.deleteCharAt(sb.length()-1);
				sb=sb.reverse();
				continue;
			}
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb.toString().equals(start)) {
			res = 1;
		}
		System.out.println(res);
	}
}