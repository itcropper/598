import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NextPalindrome {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int testCases = Integer.valueOf(scan.nextLine());
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		
		
		for(int i = 0; i < testCases; i++){
			list.add(new BigInteger(scan.nextLine()));
		}
		
		for(BigInteger i : list){
			System.out.println(nextPalindrome(i));
		}
		
		/*
		String sb = "1";
		for(int i = 0; i < 999998; i++){
			sb += "0";
		}
		//out.write("hey");
		sb += "11";
		out.write(nextPalindrome(new BigInteger(sb)));
		fstream.close();
		*/
	}

	public static String nextPalindrome(BigInteger num) {
		return nextPalindrome(num.toString(), true);
	}

	private static String nextPalindrome(String num, boolean firstTime) {
		String numString = "" + num.toString();
		int leftEndIndex = -1;
		int rightStartIndex = -1;
		boolean isOdd = numString.length() % 2 == 1;
		if (isOdd) {
			leftEndIndex = numString.length() / 2;
			rightStartIndex = leftEndIndex + 1;
		} else {
			leftEndIndex = rightStartIndex = numString.length() / 2;

		}
		String leftHalf = numString.substring(0, leftEndIndex);
		String rightHalf = numString.substring(rightStartIndex);

		String leftReversed = new StringBuffer(leftHalf).reverse().toString();
		String palindrome = null;
		
		BigInteger lr = new BigInteger(leftReversed);
		BigInteger rh = new BigInteger(rightHalf);
		
		if (lr.compareTo(rh) > 0 || !firstTime) {
			if (isOdd)
				palindrome = leftHalf + numString.charAt(leftEndIndex)+ leftReversed;
			else
				palindrome = leftHalf + leftReversed;
			return palindrome;
		} else {
			if (isOdd) {
				String leftAndMiddle = leftHalf
						+ numString.charAt(leftEndIndex);
				BigInteger incrementedLeft = new BigInteger(leftAndMiddle).add(BigInteger.ONE);
				return nextPalindrome((incrementedLeft + rightHalf), false);
			} else {
				BigInteger incrementedLeft = new BigInteger(leftHalf).add(BigInteger.ONE);
				return nextPalindrome((incrementedLeft + rightHalf), false);
			}
		}

	}
}
