import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	String input = br.readLine();
    	String target = br.readLine();
    	Stack<Character> stack1 = new Stack<Character>(); 
    	Stack<Character> stack2 = new Stack<Character>();
    	outer: for(int i=0; i<input.length();i++) {
    		if(input.charAt(i)!=target.charAt(0)) {
    			stack1.push(input.charAt(i));
    		}
    		else {
    			if(i+target.length()-1>input.length()-1) {
    				stack1.push(input.charAt(i));
    				continue;
    			}
    			for(int j=1; j<target.length();j++) {
    				if(input.charAt(i+j)!=target.charAt(j)) {
    					stack1.push(input.charAt(i));
    					continue outer;
    				}
    			}
    			i += target.length()-1;
    		}
    	}
    	outer: while(!stack1.isEmpty()) {
    		char cur = stack1.pop();
    		stack2.push(cur);
    		if(stack1.size()>=target.length()-1&&cur==target.charAt(target.length()-1)) {
    			for(int i= target.length()-2;i>=0;i--) {
    				cur = stack1.pop();
    				if(cur!=target.charAt(i)) {
    					stack1.push(cur);
    					continue outer;
    				}
    				else {
    					stack2.push(cur);
    				}
    			}
    			for(int i=0; i<target.length();i++) {
    				stack2.pop();
    			}
    			int index = 0;
    			while(!stack2.isEmpty()&&index<target.length()) {
    				stack1.push(stack2.pop());
    				index++;
    			}
    		}
    	}
    	if(stack2.size()==0) {
    		System.out.println("FRULA");
    		return;
    	}
    	StringBuilder sb = new StringBuilder();
    	while(!stack2.isEmpty()) {
    		sb.append(stack2.pop());
    	}
    	System.out.println(sb.toString());
    }
}