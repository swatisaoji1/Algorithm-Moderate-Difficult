import java.lang.reflect.Array;
import java.util.Arrays;

/*=============================================================
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *============================================================*/
public class SumOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares1(13));

	}
	
	// n * m space and complexity
	 public static int numSquares(int n) {
		 int m = (int)Math.sqrt(n) + 1 ;
		 int[][] table = new int[m][n+1] ;
		 for(int i = 0 ; i < n+1 ; i++){
			 table[1][i] = i;
		 }
		 for(int i = 0 ; i < m ; i++){
			 table[i][0] = 0;
		 }
		 
		 int x, y;
		 for(int i = 2; i < m ; i++){
			 for(int j = 1; j < n+1; j++){
				 x = table[i-1][j];
				 y = j - (i*i) >= 0 ? table[i][j - (i*i)] + 1 : n+1 ;
				 table[i][j] = Math.min(x, y);
			 }
		 }
		return table[m-1][n];
	        
	        
	        
	 }
	 
	 // space O(n) and compl = O(n)
	 public static int numSquares1(int n) {
		 int[] table = new int[n+1] ;
		 Arrays.fill(table, n+1);
		 int m = (int)Math.sqrt(n) + 1;
		 int i = 0;
		 table[0] = 0;
		 while(i++ <= m ){
			 for(int j = 0; j < n+1; j++){
				 int x = j - (i * i) >= 0 ?  table[j - (i * i)] : n+1;
				 table[j] = Math.min(table[j], x + 1);
			 }
		 }
	        
	    return table[n];    
	        
	 }

}
