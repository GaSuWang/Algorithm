
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		while(true) {
			int len = 3;
			if(N<=3) {
				if(N==1) {
					System.out.println("m");
					return;
				}
				else {
					System.out.println("o");
					return;
				}
			}
			int k=0;
			for(int i=1;;i++) {
				if(len*2+i+3>=N) {
					//이제 찾기
					k = i;
					break;
				}
				len = len*2+i+3;
			}
			if(N>len+k+3) {
				N = N-(len+k+3);
			}
			else {
				if(N==len+1) {
					System.out.println("m");
					return ;
				}
				else {
					System.out.println("o");
					return;
				}
			}
		}
		
		
	}
}
