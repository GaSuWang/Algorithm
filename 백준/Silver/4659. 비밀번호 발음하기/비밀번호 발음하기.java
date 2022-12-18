import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		outer: while(true) {
			input = br.readLine();
			if(input.equals("end"))break;
			StringBuilder sb= new StringBuilder();
			boolean aeiou = false;
			char before = ' ';
			int count1=0;
			int count2=0;
			for(int i=0; i<input.length();i++) {
				char cur = input.charAt(i);
				if(cur=='a'||cur=='e'||cur=='i'||cur=='o'||cur=='u') {
					aeiou = true;
					count1++;
					count2=0;
				}
				else {
					count1=0;
					count2++;
				}
				if(count1>=3||count2>=3) {
					sb.append('<').append(input).append('>').append(" is not acceptable.");
					System.out.println(sb.toString());
					continue outer;
				}
				if(before==cur&&!(cur=='e'||cur=='o')) {
					sb.append('<').append(input).append('>').append(" is not acceptable.");
					System.out.println(sb.toString());
					continue outer;
				}
				before = cur;
				
			}
			
			if(!aeiou) {
				sb.append('<').append(input).append('>').append(" is not acceptable.");
				System.out.println(sb.toString());
				continue outer;
			}
			sb.append('<').append(input).append('>').append(" is acceptable.");
			System.out.println(sb.toString());
		}
		
	}

}