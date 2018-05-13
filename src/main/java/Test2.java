import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		int[] aa = new int[3];
		aa[0] = 23;
		aa[1] = 239;
		aa[2] = 339;
		List inputList1 = Arrays.asList(aa) ;
		System.out.println(inputList1.size()); 
		
		int[] aab = new int[3];
		aab[0] = 23;
		aab[1] = 239;
		aab[2] = 339;
		inputList1.add(aab);
		System.out.println(inputList1.size());
		List<Long> inputList = new ArrayList<Long>();
		//inputList.add(arg0)
	}
}
