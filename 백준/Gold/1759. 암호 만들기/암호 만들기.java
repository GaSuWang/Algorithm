import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int len;
	static String alpha[];
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		len = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		alpha = new String[c];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c;i++) {
			alpha[i] = st.nextToken();
		}
		Arrays.sort(alpha);
		combi(0,0,0,false,"");
	}	
	private static void combi(int start, int count,int sonCount,boolean isMom, String password) {
		if(count == len && isMom && sonCount>1) {
			System.out.println(password);
			return;
		}
		
		if(isMom) {
			for(int i=start;i<c;i++) {
				boolean isSon = true;
				if(alpha[i].equals("a")||alpha[i].equals("e")||alpha[i].equals("i")||alpha[i].equals("o")||alpha[i].equals("u")) {
					isSon = false;
				}
				if(isSon) {
					sonCount++;
				}
				combi(i+1,count+1,sonCount,isMom,password+alpha[i]);
				if(isSon) {
					sonCount--;
				}
			}
		}
		else {
			for(int i=start;i<c;i++) {
				if(alpha[i].equals("a")||alpha[i].equals("e")||alpha[i].equals("i")||alpha[i].equals("o")||alpha[i].equals("u")) {
					isMom = true;
				}
				combi(i+1,count+1,isMom?sonCount:sonCount+1,isMom,password+alpha[i]);
				isMom = false;
			}
		}
		return;
	}
		
		
	

}
