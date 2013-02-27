import java.util.Scanner;


class FourSquare {

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			String next = scanner.next();
			if(next == "break")
				System.exit(0);
			//System.out.println(next);
			System.out.println(getOptions(next));
		}

	}
	
	/*
	 * x = a^2 + b^2 + c^2 + d^2
	 * 
	 * x = 0   + 0   + 0   + d^2
	 * In general, the strategy is to begin by setting the first term to be the
	 * largest square below N and try to represent the smaller remainder as a sum of three
	 * squares. Then the first term is set to the next largest square below N, and so forth. Over
	 * time a lightning calculator would become familiar with expressing small numbers as
	 * sums of squares, which would speed up the process.
	 * 
	 */
	
	static int getOptions(String in){
		
		int input = Integer.valueOf(in).intValue();
		int answer = 0;
		double a_top = Math.sqrt(input);
		int largest_square = (int) a_top;
		for(int a = largest_square; a >= 0; a--){
			int largest_squared = (int) (largest_square * largest_square);
			int a_remainder = largest_squared - a;
			int a_largest_square = (int)Math.sqrt(a_remainder);
			for(int b = a_largest_square; b >= 0; b--){
				int b_largest_squared = (int) (a_largest_square * a_largest_square);
				int b_remainder = b_largest_squared - b;
				int b_largest_square = (int) Math.sqrt(b_remainder);
				for(int c = b_largest_square; c >= 0; c--){
					int c_largest_squared = (int) (b_largest_square * b_largest_square);
					int c_remainder = c_largest_squared - c;
					int c_largest_square = (int) Math.sqrt(c_remainder);
					if(c_largest_square + b_largest_square + a_largest_square >= input)
						answer++;
				}
				
			}
		}
		return answer;
	}

}
