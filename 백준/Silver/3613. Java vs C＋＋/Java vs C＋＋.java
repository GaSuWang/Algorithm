import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//32차이
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	char [] name = br.readLine().toCharArray();
    	int len = name.length;
    	StringBuilder sb = new StringBuilder();
    	//-1 = java 1= c++
    	int check = 0;
    	if(name[0]<'a'||name[0]>'z') {
    		System.out.println("Error!");
			return;	
    	}
    	if(name[len-1]=='_') {
    		System.out.println("Error!");
			return;	
    	}
    	for(int i=0; i<len;i++) {
    		if(name[i]>='A'&&name[i]<='Z') {
    			if(check==1) {
    				System.out.println("Error!");
    				return;
    			}
    			check = -1;
    		}
    		if(name[i]=='_') {
    			if(check==-1) {
    				System.out.println("Error!");
    				return;
    			}
    			if(name[i+1]=='_') {
    				System.out.println("Error!");
    				return;
    			}
    			check=1;
    		}
    	}
    	
    	for(int i=0; i<len;i++) {
    		if(name[i]>='a'&&name[i]<='z') {
    			sb.append(name[i]);
    		}
    		else if(name[i]=='_') {
    			
    			sb.append(Character.toChars(name[i+1]-32));
    			i++;
    		}
    		else if(name[i]>='A'&&name[i]<='Z') {
    			sb.append('_');
    			sb.append(Character.toChars(name[i]+32));
    		}
    	}
    	
    	System.out.println(sb.toString());
    }
}