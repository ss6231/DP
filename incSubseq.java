public class incSubseq {
	public static void main (String [] args) {
		int [] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println (incSub (arr, arr.length-1));
	}
	public static int incSub (int [] arr, int last) {
		if (last == 0) {
			return 0;
		}
		else {
			int found = -1;
			int value = incSub (arr, last-1);
			if (arr[last] >= arr[last-1]) {
				found = Math.max (found, value+1);
				if (last-1 == 0) {
					System.out.println (arr[last-1]);
				}
				System.out.println (arr[last]);
			}
			else {
				found = value;
			}
			return found;
		}
	}
}









