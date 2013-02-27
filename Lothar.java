import java.util.*;


public class Lothar {
	
	static Map<Integer, Integer> counts;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int expecting = Integer.valueOf(scan.nextLine()).intValue();
		
		int[][] testCases = new int[expecting][2];
		
		for (int i = 0; i < expecting; i++){
			String next = scan.nextLine();
			String[] split = next.split(" ");
			testCases[i][0] = Integer.valueOf(split[0]).intValue();
			testCases[i][1] = Integer.valueOf(split[1]).intValue();
		}
		
		for(int i = 0; i < testCases.length; i++){
			
			counts = new HashMap<Integer, Integer>();
			
			int a, b;
			a = testCases[i][0];
			b = testCases[i][1];
			
			for(int j = a; j <= b; j++){
				//print("------------");
				solver(j, j, 0);
			}
			int max = 0;
			for(int x : counts.keySet()){
				if(counts.get(x) > max){
					max = counts.get(x);
				}
			}
			//System.out.println(counts);
			System.out.println(max);
			
		}


	}
	
	public static int solver(int orig, int n, int count){
		//print(n);
		//print(count);
		while(n != 1){
			count++;
			
			if(n % 2 == 0){
				n = n/2;
			}else{
				n = n * 3 + 1;
			}
			
			if(counts.containsKey(n)){
				counts.put(n, count + counts.get(n));
				return counts.get(n);
			}
		}
		counts.put(n, count);
		

		return count;
		

	}
	
	public static void print(Object k){
		System.out.println(k);
	}

}

