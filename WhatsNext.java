import java.util.*;
import java.util.Scanner;


public class WhatsNext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		List<double[]> list = new ArrayList<double[]>();
		
		double[] array;
		
		String line = scan.nextLine();
		
		while(true){
			
			array = new double[3];
			
			String[] tmp = line.split(" ");
			
			for(int i = 0; i < 3; i++){
				array[i] = Integer.valueOf(tmp[i]);
				//System.out.print(array[i]);
			}
			//System.out.println("");
			
			if(array[0] == 0 &&
			   array[1] == 0 &&
			   array[2] == 0){
				break;
			}
			
			list.add(array);
			
			line = scan.nextLine();
			
			//print(line);

		}
		//print("hey");
		//int x = list.size();
		
		for(int i = 0; i < list.size(); i++){
			getNext(list.get(i));
		}
		

	}
	
	public static void print(Object obj){
		System.out.println(obj);
	}

	private static void getNext(double[] array) {
		
		double first = array[1] - array[0];
		double second = array[2] - array[1];
		
		double gFirst = array[2] / array[1];
		
		//System.out.println(first + " : " + second);
		
		if(first == second){
			System.out.println("AP " + (int)(array[2] + first));
		}else{
			System.out.println("GP " + (int)(gFirst * array[2]));
		}
		
	}

}
