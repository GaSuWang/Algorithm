////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer: for(int t=0; t<T;t++) {
			char[] commands = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				br.readLine();
				for(int i=0; i<commands.length;i++) {
					
					if(commands[i]=='D') {
						System.out.println("error");
						continue outer;
					}
				}
				System.out.println("[]");
				continue outer;
			}
			String input = br.readLine();
			input = input.substring(1,input.length()-1);
			String inputArr[] = input.split(","); 
			int [] arr = new int[n];
			int idx = 0;
			for(int i=0; i<inputArr.length;i++) {
				arr[idx] = Integer.parseInt(inputArr[i]);
				idx++;
			}
			int sPoint = 0;
			int ePoint = n-1;
			int count = n;
			boolean flag = false;
			
			for(int i=0; i<commands.length;i++) {
				if(commands[i]=='R') {
					flag = !flag;
				}
				else {
					if(count==0) {
						System.out.println("error");
						continue outer;
					}
					if(!flag) {
						arr[sPoint] = 0;
						sPoint++;
					}
					else {
						arr[ePoint] = 0;
						ePoint--;
					}
					count--;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if(!flag) {
				for(int i=sPoint;i<=ePoint;i++) {
					sb.append(arr[i]);
					if(i==ePoint) break;
					sb.append(',');
				}
			}
			else {
				for(int i=ePoint; i>= sPoint; i--) {
					sb.append(arr[i]);
					if(i==sPoint) break;
					sb.append(',');
				}
			}
			sb.append("]");
			System.out.println(sb);
		}
	} 
}