
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {2,3,4};
		int amount = 4;
		System.out.println(coinChange(coins, amount));

	}

	 public static int coinChange(int[] coins, int amount) {
	        int m = coins.length;
	        int n = amount;
	        
	        // memo table
	        int[][] table = new int[m+1][n+1];
	        for(int i = 0; i < m+1; i++ ){
	            table[i][0]= 0;
	        }
	        
	         for(int i = 1; i < n+1; i++ ){
	            table[0][i]= Integer.MAX_VALUE;
	        }
	        
	        int x, y;
	        for(int i = 1; i < m+1 ; i++){
	             for(int j = 1; j < n+1 ; j++){
	                x = table[i-1][j];
	                y = (j - coins[i-1] >= 0 &&  table[i][j - coins[i-1]] != Integer.MAX_VALUE) ? table[i][j - coins[i-1]] + 1 : Integer.MAX_VALUE;
	                table[i][j] = Math.min(x, y);
	             }
	        }
	      
	        return table[m][n]== Integer.MAX_VALUE ? -1 : table[m][n];
	        
	    }
	}

