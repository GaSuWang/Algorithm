
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,long[]> hashMap = new HashMap<>();
		hashMap.put("black", new long[] {0,1});
		hashMap.put("brown", new long[] {1,10});
		hashMap.put("red", new long[] {2,100});
		hashMap.put("orange", new long[] {3,1000});
		hashMap.put("yellow", new long[] {4,10000});
		hashMap.put("green", new long[] {5,100000});
		hashMap.put("blue", new long[] {6,1000000});
		hashMap.put("violet", new long[] {7,10000000});
		hashMap.put("grey", new long[] {8,100000000});
		hashMap.put("white", new long[] {9,1000000000});
		StringBuilder sb = new StringBuilder();
		long res = Integer.parseInt(sb.append(hashMap.get(br.readLine())[0]).append(hashMap.get(br.readLine())[0]).toString())*hashMap.get(br.readLine())[1];
		System.out.println(res);
	}

}