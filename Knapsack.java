import java.util.*;

public class Knapsack {
	


	public static int[][] table;
	
	public static int CAPACITY;
	public static int ITEMS;
	
	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		ArrayList<int[]> inputs=  new ArrayList<int[]>();
		
		String[] initial = scan.nextLine().split(" ");
		CAPACITY = Integer.valueOf(initial[0]);
		ITEMS = Integer.valueOf(initial[1]);
		
		table = new int[ITEMS + 1][CAPACITY + 1];
		
		
		for(int i = 0; i < ITEMS; i++){
			
			String[] next = scan.nextLine().split(" ");
			int[] tmp = new int[2];
			
			
			tmp[0] = Integer.valueOf(next[0]);
			tmp[1] = Integer.valueOf(next[1]);
			
			inputs.add(tmp);
			
		}
		
//		try{
			fillTable(inputs);
//		}catch (Exception e){
//			System.out.println(e);
//		}

	}
	
	public static void fillTable(ArrayList<int[]> inputs){
		
		
		//System.out.println("Done");
		for(int i = 1; i <= ITEMS; i++){
			int weight = inputs.get(i - 1)[0];
			int value = inputs.get(i - 1)[1];
			for(int j = 1; j <= CAPACITY; j++){
				
				int a = -1, b = -1, c = -1;
				
//				System.out.println(i + ", " + j);
				
				if(i > 0){
					a = table[i - 1][j];
				}else{
					a = 0;
				}
				if(j > 0){
					b = table[i][j - 1];
				}else{
					b = 0;
				}
				if(i > 0 && j >= weight){
					c = table[i - 1][j - weight] + value;
				}
				table[i][j] =  Math.max(a, Math.max(b, c));
			}
		}
//		for(int i = 0; i <= ITEMS; i++){
//			for(int j = 0; j <= CAPACITY; j++){
//				Object ob;
//				if(table[i][j] > 10)
//					ob = table[i][j] + "  ";
//				else
//					ob = table[i][j] + "   ";
//				System.out.print(ob);
//			}
//			System.out.println("");
//		}
		System.out.println(table[ITEMS][CAPACITY]);
	}

}

