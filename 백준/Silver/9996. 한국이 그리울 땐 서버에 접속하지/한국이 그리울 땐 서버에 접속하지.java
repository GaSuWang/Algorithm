////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String p = br.readLine();
    	String pattern[] = new String[2];
    	for(int i=0; i<p.length();i++) {
    		if(p.charAt(i)==42) {
    			pattern[0] = p.substring(0, i);
    			pattern[1] = p.substring(i+1,p.length());
    			break;
    		}
    	}
    	for(int i=0; i<N;i++) {
    		String file = br.readLine();
    		if(pattern[0].length()>=file.length()||pattern[1].length()>=file.length()) {
    			System.out.println("NE");
    			continue;
    		}
    		String start = file.substring(0, pattern[0].length());
    		String end = file.substring(file.length()-pattern[1].length()<pattern[0].length()?pattern[0].length():file.length()-pattern[1].length(),file.length());
    		if(start.equals(pattern[0])&&end.equals(pattern[1])) System.out.println("DA");
    		else System.out.println("NE");
    	}	
    }
}