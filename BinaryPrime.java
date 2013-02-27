import java.util.*;

public class BinaryPrime {
	

	public static void main(String[] arg0) {
		
		Scanner scan = new Scanner(System.in);

		int testCases = Integer.valueOf(scan.nextLine());

		int currentCase = 0;
		boolean first = true;
		
		int[] cases = new int[testCases];

		while (currentCase < testCases) {
			
			cases[currentCase] = Integer.valueOf(scan.nextLine());
			
			currentCase++;

		}
		for(Integer in : cases)
			takeCareOfIt(in, 1000000);
		
		System.exit(0);
	}

	private static void takeCareOfIt(int in, int LIMIT) {
		
		int length = 0;
		
		String primes;
		if(in > 1000000){
			primes = calcPrimeNumbers(150000000, in);
		}else{
			primes = getPrimes(in);
			
		}
		//System.out.println(primes);
		getPrimeStream(primes, in);
	}
	
	private static void getPrimeStream(String primes, int in) {
		
		int running = 0;
		for(int i = 0; i < in; i++){
			if(primes.charAt(i) == '1')
				running++;
		}
		//System.out.println(primes);
		System.out.println(running);
	}

	public static String getPrimes(int LIMIT) {

		int n = 2;
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(n));
		//System.out.println(Integer.toBinaryString(n));

		while (n < LIMIT) {
			// System.out.println(n);
			n++;

			char[] chars = String.valueOf(n).toCharArray();
			int lastDigit = Character.digit(chars[chars.length - 1], 10);

			if(n == 2 || n == 3 || n == 5 || n == 7 || n == 11){
				sb.append(Integer.toBinaryString(n));
				//System.out.println(Integer.toBinaryString(n));
				continue;
			}
			
			if (lastDigit == 2) {
				continue;
			} else if (lastDigit == 4) {
				continue;
			} else if (lastDigit == 8) {
				continue;
			}

			if (lastDigit == 5 || lastDigit == 0) {
				continue;
			}

			if (addThrees(n) % 3 == 0) {
				continue;
			}

			if (addEleven(n) == 0 && n != 11) {
				continue;
			}

			if (isPrime(n)) {
				sb.append(Integer.toBinaryString(n));
				//System.out.println(Integer.toBinaryString(n));
			}

		}
		return sb.toString();
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
	
	public static String calcPrimeNumbers(double n, int LIMIT) {
		double[] isPrimeNumber = new double[(int) (n + 1)]; // boolean defaults
															// to
		// false
		List<Double> primes = new ArrayList<Double>();
		List<Double> super_primes = new ArrayList<Double>();
		// isPrimeNumber[0] =
		String binary = "";
		for (double i = 2; i < n; i++) {
			int v = primes.size();
			if (isPrimeNumber[(int) i] == 0) {
				binary += Integer.toBinaryString((int) i);
				int size = binary.length();
				if(size >= LIMIT)
					return binary;
				
				for (double j = i; j * i <= n; j++) {
					isPrimeNumber[(int) (i * j)] = 1;
				}
			}

		}
		// System.out.println(primes.size());
		return binary;
	}
}
