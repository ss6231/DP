//classic greatest increasing subsequence problem

//basic idea is that LS (j) is the length of the longest increasing subsequence of all indexes from 0 to j, inclusive
//suppose we're solving LS (i) where i > j, so LS(j) is a subproblem of LS(i)
//create the solution of LS(i) saying if j < i and A[i] > A[j], then LS(i) = 1 + max (LS(j)) where LS(j) is all
//sub solutions from 0-j and j < i

public class incSubseq {
	public static void main (String [] args) {
		int [] arr = {1,5,2,4,8,6,7,9,100,10};
		System.out.println (incSub (arr, arr.length-1));
	}
	public static int LS (int [] arr, int ind) {
		int count = 0;
		for (int i = 0; i <= ind; i++) {
			int cur = arr[i]; //current LS (i) we are looking at;
			for (int j = 0; j <= i; j++) { //smaller LS (j) we are looking at
				if (cur > arr[j]) {
					count = Math.max (count, LS (arr, j) + 1); //here, A[i]>A[j], so add 1 to the currently longest subsequence
				}
				else {
					count = Math.max (count, 1); //if A[i] is NOT greater than A[j], then the current solution for LS(i) will be the longest subsequence encountered so far
				}
			}
		}
		return count;
	}
}
