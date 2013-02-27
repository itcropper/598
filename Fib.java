import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


public class Fib {

    /**
     * @param args
	 */
	public static int N;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		while(true){
			N = Integer.valueOf(scan.next());
			
			getFib();
//		}
	}
	
	public static void getFib(){
		
		BigInteger[] list = new BigInteger[N + 1];
		
		if(N == 1){
			System.out.println(1);
			return;
		}else if (N == 0){
			System.out.println(0);
			return;
		}else{
			list[0] = BigInteger.valueOf(0);
			list[1] = BigInteger.valueOf(1);
			list[2] = BigInteger.valueOf(1);
		}
		
		int count = 2;
		
		while(count <= N){
			list[count] = list[count - 1].add(list[count - 2]);
			//System.out.println(list[count]);
			count++;
		}
		NumberFormat formatter = new DecimalFormat("#####");  
		   
		String f = formatter.format(list[N]); 
		System.out.println(f);
		
	}

}
