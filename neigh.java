//description found here: http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
import java.util.Arrays;
public class neigh {
	public static void main (String [] args) {
		int [] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
  int [] lookup = new int [arr.length];
	System.out.println (neigh(arr, arr.length-1, lookup));
	}

	public static int neigh (int [] arr, int n, int [] lookup) {
		if (n == 1) {
			lookup[n] = arr[1];
			return arr[1];
		}
		if (n == 0) {
			lookup[n] = arr[0];
			return arr[0];
		}
		else {
			if (lookup[n] != 0) return lookup[n];
			int pos1 = neigh (arr, n-1, lookup);
			int pos2 = neigh (arr, n-2, lookup);
			int max;
			if (n == arr.length-1 && (arr.length)%2 != 0) {
				max = Math.max(pos1, pos2-arr[0]+arr[n]);
			}
			else if (n == arr.length-1 && (arr.length)%2 == 0) {
				max = Math.max(pos1, pos2-arr[0]+arr[n]);	
			}
			else {
				 max = Math.max (pos1, pos2+arr[n]);
			}
			lookup[n] = max;
			return max;
		}
	}
}
