import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger money = sc.nextBigInteger();
		BigInteger p = sc.nextBigInteger();
		System.out.println(money.divide(p));
		System.out.println(money.mod(p));
	}
}