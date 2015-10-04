//given a set of coins and a sum, S, find the minimum number of coins whose total sum is
//less than or equal to S
public class minCoins {
	public static void main (String [] args) {
		int [] arr = {25,5,10};
		int sum = 73;
		int [] [] lookup = new int [sum+1][sum];
		for (int i = 0; i < sum+1; i++) {
			for (int j = 0; j < sum; j++) {
				lookup[i][j] = -1;
 			}
		}
		System.out.println (minCoins(arr,sum, lookup));
	}

	public static int minCoins (int [] arr, int sum, int [] [] lookup) {
		if (sum == 0) {
			return 0;
		}
		boolean isSmaller = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < sum) {
				isSmaller = true;
			}
		}
		if (!isSmaller) return 0;
		else {
			int found = 1000000;
			for (int i = 0; i < arr.length;i++) {
				 if (lookup[sum][i] != -1) found = lookup[sum][i];
				if (sum >= arr[i]) {
					int sum2 = sum-arr[i];
					int otherVal = minCoins (arr, sum2, lookup)+1;
					found = Math.min (found, otherVal);
					lookup[sum][i] = found;
				}
			}
			return found;
		}
	}
}




