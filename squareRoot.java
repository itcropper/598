import java.text.DecimalFormat;
import java.util.Scanner;


public class squareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int squared = Integer.valueOf(scan.nextLine());
		
		System.out.println(getSquare(squared));

	}

	private static String getSquare(double squared) {
		
		double half = squared / 2;
		double square = half * half;
		
		while(Math.abs((square * square - squared)) > .0001){
			
			if(square * square > squared){
				half = square / 1.8;
				square = half;
			}else{
				square *= 1.2;
			}	

		}
		DecimalFormat myFormat = new DecimalFormat("0.000");
		String myDoubleString = myFormat.format(square);
		return myDoubleString;
	}

}
