

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char [] input = br.readLine().toCharArray();
		char [] cur = new char[N]; 
		char [] goal = br.readLine().toCharArray();
		//첫번째 스위치 안눌렀을 때
		cur = copy(input);
		int res = -1;
		int tempRes = progress(input, cur, goal);
		if(cur[N-2]!=goal[N-2]&&cur[N-1]!=goal[N-1]) {
			tempRes++;
			res = tempRes;
		}
		else if(cur[N-2]==goal[N-2] && cur[N-1]==goal[N-1]) res = tempRes;
		//첫번째 눌렀을 때
		cur = copy(input);
		cur[0] = cur[0]=='0'?'1':'0'; 
		cur[1] = cur[1]=='0'?'1':'0';
		tempRes = progress(input, cur, goal)+1;
		if(cur[N-2]!=goal[N-2]&&cur[N-1]!=goal[N-1]) {
			tempRes++;
			res = res==-1?tempRes:Math.min(res,tempRes);
		}
		else if(cur[N-2]==goal[N-2] && cur[N-1]==goal[N-1]) res = res==-1?tempRes:Math.min(res,tempRes);
		System.out.println(res);		
	}
	
	
	public static  char [] copy(char [] input) {
		int length = input.length;
		char [] res = new char[length];
		for(int i=0; i<length;i++) {
			res[i] = input[i];
		}
		return res;
	}
	
	public static int progress(char [] input, char [] cur, char [] goal) {
		int tempRes = 0;
		int N = input.length;
		for(int i=1; i<N-1;i++) {
			if(cur[i-1]!=goal[i-1]) {
				//누름
				tempRes++;
				cur[i-1] = cur[i-1]=='0'?'1':'0'; 
				cur[i] = cur[i]=='0'?'1':'0'; 
				cur[i+1] = cur[i+1]=='0'?'1':'0'; 
			}
		}
		return tempRes;
	}
}


