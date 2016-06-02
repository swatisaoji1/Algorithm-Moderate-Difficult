
public class SumOfSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,4,5,6};
		int sum = 6;
		System.out.println(isSumPossible(array, sum));
		System.out.println(countSetsForSum(array, sum));

	}

	private static int countSetsForSum(int[] array, int sum) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static boolean isSumPossible(int[] array, int sum) {
		if(sum == 0){
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

}
