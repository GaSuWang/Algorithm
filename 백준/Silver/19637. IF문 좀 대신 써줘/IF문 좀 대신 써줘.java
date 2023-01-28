import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Item{
	String title;
	int power;
	Item(String title, int power){
		this.title=title;
		this.power = power;
	}
}

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Item [] arr = new Item[N];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String title = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			arr[i] = new Item(title,power);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M;i++) {
			int cur = Integer.parseInt(br.readLine());
			int left = 0;
			int right = N-1;
			int mid = (left+right)/2;
			while(left<=right) {
				mid = (left+right)/2;
				if(arr[mid].power<cur) {
					left = mid+1;
					
					
				}
				else{
					right=mid-1;
				}
			}
			sb.append(arr[left].title).append('\n');
		}
		System.out.println(sb.toString());
	}
	
}
