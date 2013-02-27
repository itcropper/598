import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimesToAMillion {

	public static void main(String[] args) throws IOException {

		long startTime = System.nanoTime();
		/*
		System.out.println(1);
		System.out.println(2);
		getPrimes();
		*/
		List<Double> primes = calcPrimeNumbers(1);
		StringBuilder sb = new StringBuilder();
		
		 //FileWriter fstream = new FileWriter("out.txt");
		 //BufferedWriter out = new BufferedWriter(fstream);
		 
		
		for(int i = 0; i < primes.size(); i++){
			if(i == primes.size() - 1){
				sb.append(primes.get(i).intValue());
			}
			else
				sb.append(primes.get(i).intValue() + "\n");
		}
		
		System.out.println(sb.toString());

		//long endTime = System.nanoTime();

		//long duration = endTime - startTime;

		//System.out.println("\n" + duration / 10000000);

	}

	public static void getPrimes() {

		int n = 2;
		StringBuilder sb = new StringBuilder();

		while (n < 1000000) {
			// System.out.println(n);
			n++;

			char[] chars = String.valueOf(n).toCharArray();
			int lastDigit = Character.digit(chars[chars.length - 1], 10);

			if (lastDigit == 2) {
				continue;
			} else if (lastDigit == 4) {
				continue;
			} else if (lastDigit == 8) {
				continue;
			}

			if ((lastDigit == 5 || lastDigit == 0) && chars.length > 0) {
				continue;
			}

			if (addThrees(n) % 3 == 0 && n != 3) {
				continue;
			}

			if (addEleven(n) == 0 && n != 11) {
				continue;
			}

			if (isPrime(n)) {
				sb.append(n + "\n");
			}

		}
		System.out.print(sb.toString());
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

	public static boolean isPrime(int n) {

		int test = 1;
		double half = Math.sqrt(n);

		while (test < half) {

			if (n % ++test == 0)
				return false;

		}
		return true;
	}

	public static List<Double> calcPrimeNumbers(double n) {
		boolean[] isPrimeNumber = new boolean[(int) (n + 1)]; // boolean defaults to
		// false
		List<Double> primes = new ArrayList<Double>();
		for (int i = 2; i < n; i++) {
			isPrimeNumber[i] = true;
		}
		for (double i = 2; i < n; i++) {
			if (isPrimeNumber[(int) i]) {
				primes.add(i);
				// Now mark the multiple of i as non-prime number
				for (double j = i; j * i <= n; j++) {
					isPrimeNumber[(int) (i * j)] = false;
				}
			}

		}

		return primes;
	}

}
