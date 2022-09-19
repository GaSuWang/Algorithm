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
    	int N = Integer.parseInt(br.readLine())-1;
    	int res = 0;
    	int al[] = new int[26]; 
    	char[]input = br.readLine().toCharArray();
    	for(int i=0; i<input.length;i++) {
    		al[input[i]-'A']++;
    	}
    	for(int i=0;i<N;i++) {
    		char[] curInput = br.readLine().toCharArray();
    		int [] curAl = new int[26]; 
    		for(int j=0;j<curInput.length;j++) {
    			curAl[curInput[j]-'A']++;
    		}
    		int only = 0;
    		int onlyCur = 0;
    		for(int j=0;j<26;j++) {
    			if(al[j]==curAl[j]) continue;
    			if(al[j]-curAl[j]>0) only+=al[j]-curAl[j];
    			else onlyCur+=curAl[j] - al[j];
    		}
    		if(only==0&&onlyCur==0) {
    			res++;//문자 구성이 같은경우
    		}
    		else if((only==0||onlyCur==0)&&Math.abs(only-onlyCur)==1) {
    			res++;//하나를 더하거나 빼는경우
    		}
    		else if(only==1&&onlyCur==1) {
    			res++; //하나를 바꾸는경우
    		}
    	}
    	System.out.println(res);
    	
    	
    }
}