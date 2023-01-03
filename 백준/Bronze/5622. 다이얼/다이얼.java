
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int sum =0;
		for(int i=0; i<input.length;i++) {
			int num =  (input[i]-'A')/3 +3;
			if(input[i]-'A'==18||input[i]-'A'==21||input[i]-'A'>=24) num--;
			sum+=num;
		}
		System.out.println(sum);
			

	}

}