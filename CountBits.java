import java.util.HashMap;
import java.util.Map;

/*
 Given a non negative integer number num. 
 For every numbers i in the range 0 ≤ i ≤ num 
 calculate the number of 1's in their binary representation and return them as an array.
 
 Example:
 For num = 5 you should return [0,1,1,2,1,2].
*/
public class CountBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = countTheBits(5);
		for(int i : r){
			System.out.println(i);
		}
	}

	public static int[] countTheBits(int n){
		int[] result = new int[n+1];
		
		// initialize
		result[0] = 0;
		result[1] = 1;
		
		for(int i = 2; i < n+1; i++){
			if(((i-1) & 1) == 0){
				result[i] = result[i-1] + 1 ;
			}else{
				result[i] = result[i-1] + 1;
				int temp = i-1;
				while((temp & 1) == 1){
					result[i]--;
					temp = temp >> 1;
				}
			}
		}
		return result;
		
	}
}
