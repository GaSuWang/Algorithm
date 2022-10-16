
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
//		for(int i=0; i<N;i++) {
//			input[i] = N-i;
//		}
//		char[] input = br.readLine().toCharArray();
//		char[] input = new char[N];
//		for(int i=0;i<N;i++) {
//			input[i] = (char) (i+'0');
//		}
		
		int[] output = new int[N];
		Arrays.fill(output, -1);
		for(int i=0; i<N;i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else {
				while(!stack.isEmpty()&&input[stack.peek()]<input[i]) {
					output[stack.pop()]=input[i];
				}
				stack.push(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			sb.append(output[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}
}