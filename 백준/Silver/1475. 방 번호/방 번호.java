import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[10];
		String [] str =sc.nextLine().split("");
		int max = Integer.MIN_VALUE;
		for(String s : str) {
			int num =Integer.parseInt(s);
			if(num ==6||num==9) {
				if(arr[6]>arr[9]) {
					arr[9]++;
				}
				else {
					arr[6]++;
				}
			}
			else {
				arr[num]++;
			}
		}
		for(int a:arr) {
			if(max<a) max =a;
		}
		System.out.println(max);
		
	}

}