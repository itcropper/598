import java.util.*;
import java.util.Scanner;


public class kimpici {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int tests = Integer.valueOf(scan.nextLine());
		
		List<int[]> cases = new ArrayList<int[]>();
		
		
		for(int i = 0; i < tests; i++){
			char[] ccase = scan.nextLine().toCharArray();
			
			int[] array = new int[10];
			for(int j = 0; j < ccase.length; j++){
				array[Character.getNumericValue(ccase[j])] = 1;
			}
			cases.add(array);
		}
		int x= 0;

	}

}
