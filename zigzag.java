//A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative
//return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order
public class zigzag {
	public static void main (String [] args) {
		int [] arr = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		int x = zigzag(arr, arr.length-1);
		if (x > 0) {
			System.out.println(x);
		}
		else {
			System.out.println(-x);
		}
	}
	public static int zigzag (int [] arr, int last) {
		if (arr.length == 1) {
			return 1;
		}
		if (arr.length == 0) return 0;
		if (last == 1 && (arr[last]-arr[last-1]) >= 0) {
			return 2;
		}
		if (last == 1 && (arr[last] - arr[last-1]) < 0) {
			return -2;
		}
		int found = -1;
		int size = zigzag (arr, last-1); //1
		boolean prevIsNeg = false;
		if (size < 0) {
			prevIsNeg = true; //
			size *= -1; //3
		}
		else {
			prevIsNeg = false;
		}

		if ((arr[last]-arr[last-1]) > 0 && prevIsNeg) {
			found = Math.max (found, size+1);
		}
		else if ((arr[last]-arr[last-1]) < 0 && !prevIsNeg) {
			found = Math.max (found, size+1);
			found *= -1;
		}
		else {
			if (prevIsNeg) {
				found = -1 * size;
			}
			else {
				found = size;
			}
		}
		return found;
	}
}
