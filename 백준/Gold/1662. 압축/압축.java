
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int res = 0;
		int count = 0;
		int openerCount = 0;
		for(int i =0; i<string.length;i++) {
			if(string[i]=='(') openerCount++;
		}
		int len[] = new int[openerCount+2];
		int lenIndex =0;
		for (int i = 0; i < string.length; i++) {
			if (string[i] == ')') {
				while (stack.peek() != '(') {
					stack.pop();
					count++;
				}
				stack.pop();
				count = (count+len[lenIndex+1]) * (stack.pop() - '0');
				len[lenIndex] += count;
				len[lenIndex+1] = 0;
				lenIndex--;
				count = 0;

			} else {
				stack.push(string[i]);
				if (string[i] == '(')
					lenIndex++;
				// System.out.println(stack.peek());
			}
		}
		while (!stack.isEmpty()) {
			stack.pop();
			res++;

		}
		System.out.println(res+len[1]);
	}
}