//import java.util.Scanner;
//
//public class Main {
//	static int n,k;
//	static String [] arr;
//	static boolean [] alpha;
//	static int res = 0;
//	//abcdefghijklmnopqrstuvwxyz 26
//	public static void main(String[] args){
//		Scanner sc =new Scanner(System.in);
//		
//		n = sc.nextInt();
//		k = sc.nextInt();
//		sc.nextLine();
//		
//		arr = new String[n];
//		for(int i=0; i<n;i++) {
//			String str = sc.nextLine();
//			str = str.replace("anta", "");
//			str = str.replace("tica", "");
//			arr[i] = str;
//		}
//		if(k<5) {
//			System.out.println(0);
//			return;
//		}
//		if(k==26) {
//			System.out.println(n);
//			return;
//		}
//		//a n t i c
//		alpha = new boolean[26];
//		alpha['a'-'a'] = true;
//		alpha['n'-'a'] = true;
//		alpha['t'-'a'] = true;
//		alpha['i'-'a'] = true;
//		alpha['c'-'a'] = true;
//		
//		dfs(0,0);
//		System.out.println(res);
//	}
//	private static void dfs(int count,int start) {
//		if(count == k - 5) {
//			int tempRes=0;
//			for(int i=0; i<n;i++) {
//				boolean check = true;
//				for(int j = 0; j<arr[i].length();j++) {
//					if(!alpha[arr[i].charAt(j)-'a']) {
//						check = false;
//						break;
//					}
//				}
//				if(check) tempRes++;
//			}
//			res = Math.max(res, tempRes);
//			return;
//		}
//		for(int i=start; i<26;i++) {
//			if(!alpha[i]) {
//				alpha[i] = true;
//				dfs(count,i);
//				alpha[i] = false;
//			}
//			
//		}
//		
//	}	
//}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int [] arr;
	static int alpha;
	static int res;
	//abcdefghijklmnopqrstuvwxyz 26
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken())-5;
		arr = new int[n];
		alpha = 0;
		res = 0;
		for(int i=0; i<n;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=0; j<temp.length;j++) {
				arr[i] = arr[i] | (1<<temp[j]-'a');
			}
		}
		//a n t i c
		if(k<0) {
			System.out.println(0);
			return;
		}
		alpha = 0;
		alpha = alpha | (1<<'a'-'a');
		alpha = alpha | (1<<'n'-'a');
		alpha = alpha | (1<<'t'-'a');
		alpha = alpha | (1<<'i'-'a');
		alpha = alpha | (1<<'c'-'a');
		dfs(0,0);
		System.out.println(res);
	}
	private static void dfs(int count,int start) {
		if(count == k) {
			int tempRes=0;
			for(int i=0; i<n;i++) {
				if((arr[i]&alpha)==arr[i]) tempRes++;
			}
			res = Math.max(res, tempRes);
			return;
		}
		
		for(int i=start; i<26;i++) {
			if((alpha&(1<<i))!=0) continue;
			alpha = alpha | (1<<i);
			dfs(count+1,i+1);
			alpha = alpha & ~(1<<i);
		}
		
	}	

}

