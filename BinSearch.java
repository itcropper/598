import java.util.*;


public class BinSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String firstLine = scan.nextLine();
		
		int sizeOfArray = Integer.valueOf(firstLine.split(" ")[0]);
		
		int queries = Integer.valueOf(firstLine.split(" ")[1]);
		
		int[] array = new int[sizeOfArray];
		
		String[] secondLine = scan.nextLine().split(" ");
		
		for(int i = 0; i < sizeOfArray; i++){
			array[i] = Integer.valueOf(secondLine[i]);
		}
		System.out.print(array);

	}

}
