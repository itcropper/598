import java.util.*;


public class BaseNeg2 {

	/**
	 * just fooling around
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> caseList = new ArrayList<String>();
		
		int cases = Integer.valueOf(scan.nextLine());
		
		int count = 0;
		while(count++ < cases){
			caseList.add(scan.next());
		}
		
		
		
		
		
		for(int i = 0; i < caseList.size(); i++){
			if (i == caseList.size())
				convert(caseList.get(i), true);
			else
				convert(caseList.get(i), false);
		}
		
	}
	
	static void convert(String bin, boolean  last){
		
		int out = 0;
		
		//System.out.println(bin.length() - 1);
		
		
		for(int i = 0; i < bin.length(); i++){
			
			int charAt = Integer.valueOf(Character.getNumericValue(bin.charAt(i)));
			double pow = Math.pow(-2, (bin.length() - 1)  - i);
			
			out += pow * charAt;
		}
		
		if(last){
			System.out.print(out);
		}else{
			System.out.print(out + " ");
		}
		
		
	}

}
