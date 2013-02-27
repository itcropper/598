import java.util.*;


public class Feynman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int line = Integer.valueOf(scan.nextLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(line != 0){
			
			//System.out.println(line);
			
			list.add(Integer.valueOf(line));
			
			line = Integer.valueOf(scan.nextLine());
			
		}
		
		for(int i : list){
			int out = 0;
			for(int j = i; j > 0; j--){
				out += (j * j);
			}
			System.out.println(out);
			
		}

	}

}
