import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SuperPrimes {
	
	static StringBuilder sb;

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		
		sb = new StringBuilder();
		/*
		 * System.out.println(1); System.out.println(2); getPrimes();
		 */
		
		double n = Math.pow(10, 7);
		
		calcPrimeNumbers(n);
		
		System.out.println(sb.toString());

		//System.out.println("");
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(primes.size());

		//long endTime = System.nanoTime();

		//long duration = endTime - startTime;

		//System.out.println("\n" + duration / 10000000);

	}

	public static boolean CheckPrime(double x) {

		int n = (int) x;

		char[] chars = String.valueOf(n).toCharArray();
		int lastDigit = Character.digit(chars[chars.length - 1], 10);

		// 1 and 2
		if (n == 1 || n == 2 || n == 3 || n == 5 || n == 7) {
			return true;
		}

		// Evens
		if (lastDigit == 2) {
			return false;
		}

		if (lastDigit == 4) {
			return false;
		}

		if (lastDigit == 6) {
			return false;
		}

		if (lastDigit == 8) {
			return false;
		}

		// Fives
		if (lastDigit == 5) {
			return false;
		}

		if (lastDigit == 0) {
			return false;
		}

		// Threes
		if (addThrees(n) % 3 == 0) {
			return false;
		}

		// Elevens
		if (addEleven(n) == 0 && n != 11) {
			return false;
		}

		// Everything else
		if (isPrime(n)) {
			return true;
		}

		else {
			return false;
		}

	}

	public static long addThrees(int number) {
		long result = 0;
		result = 0;
		int tmp = 0;
		while (number > 0) {
			tmp = number % 10;
			result += tmp;
			number /= 10;
		}

		return result;
	}

	public static int addEleven(int n) {
		int tmp = 0;
		boolean on = true;
		int result = 0;
		while (n > 0) {
			tmp = n % 10;
			if (on) {
				result += tmp;
				on = false;
			} else {
				result -= tmp;
				on = true;
			}
			n /= 10;
		}
		return result;
	}

	public static boolean prime(int n) {
		int test = 1;
		double part = n / 2;
		while (test < part) {
			test++;
			if (test % n == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int n) {

		int test = 1;
		double half = Math.sqrt(n);

		while (test < half) {

			if (n % ++test == 0)
				return false;

		}
		return true;
	}

	public static void calcPrimeNumbers(double n) {
		BigInteger[] isPrimeNumber = new BigInteger[(int) (n + 1)]; // boolean defaults
															// to
		// false
		List<Double> primes = new ArrayList<Double>();
		List<Double> super_primes = new ArrayList<Double>();
		// isPrimeNumber[0] =
		
		for(int i = 0; i < n; i++){
			isPrimeNumber[(int) i] = BigInteger.ZERO;
		}

		for (double i = 2; i < n; i++) {
			int v = primes.size();
			if (isPrimeNumber[(int) i].equals(BigInteger.ZERO)) {
				primes.add(i);
				if (CheckPrime(primes.size()) && primes.size() > 1) {
					
					sb.append((int)i + "\n");
					// Now mark the multiple of i as non-prime number

				}
				for (double j = i; j * i <= n; j++) {
					isPrimeNumber[(int) (i * j)] = BigInteger.ONE;
				}
			}

		}
		// System.out.println(primes.size());

	}

}
