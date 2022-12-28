import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a= s.next();
		String b= s.next();
		a = new StringBuilder(a).reverse().toString();
		b= new StringBuilder(b).reverse().toString();
		int a2 = Integer.parseInt(a);
		int b2 = Integer.parseInt(b);
		if(a2>b2) System.out.print(a2);
		else if(a2<b2) System.out.print(b2);
		s.close();
	}
	
}
