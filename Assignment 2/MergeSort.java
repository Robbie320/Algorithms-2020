public class MergeSort {
	public static int comparisons = 0;
	public int mergeSort(String[] array) {
		/*Merge(A,p,q,r)
		* 	n1 = q - p + 1
		* 	n2 = r - q
		* 	let L[1...n1 + 1] R[1...n2 + 1] be new arrays
		* 	for i = 1 to n1
		* 		L[i] = A[p + i - 1]
		* 	for j = 1 to n2
		* 		R[j] = A[q + j]
		* 	L[n1 + 1] = infinity
		* 	R[n2 + 1] = infinity
		* 	i = 1
		* 	j = 1
		* 	for k = p to r
		* 		if L[i] <= R[j]
		* 			A[k] = L[i]
		* 			i = i + 1
		* 		else A[k] = R[j]
		* 			j = j + 1 */
		int n = array.length;
		int mid = n/2;
		
		this.divide(array, n);
		
		//print out array to check
		for(int x = 0; x < n; x++) {
			System.out.println(array[x]);
		}//end for x
		System.out.println();
		//number of comparisons done during sort
		System.out.println("Merge Sort Comparisons:");
		return comparisons;
	}//end mergeSort
	
	public static void divide(String[] array, int n) {
		if(n == 1) {
			return;
		} else {
			int mid = n / 2;
			String[] left = new String[mid];
			String[] right = new String[n - mid];//n-mid to account for odd numbers
			
			//Divide array into left and right arrays
			int j = 0;
			for (int i = 0; i < n; i++) {
				if (i < mid) {
					left[i] = array[i];
				} else {
					right[j] = array[i];
				}// end if
			}// end for i
			
			//Keep dividing the whole until n == 1
			if (n > 1) {
				divide(left, mid);
				divide(right, n - mid);
			}
			//merge left and right arrays into the whole array.  mid=leftLength n-mid=rightLength
			else {
				merge(left, right, array, mid, n - mid);
			}
		}//end if else
	}//end sort
	public static void merge(String[] left, String[] right, String array[], int left_n, int right_n) {
		int arrayInt = 0;
		int leftInt = 0;
		int rightInt = 0;
		//Only merge if in order, while loops to check
		while(leftInt < left_n && rightInt < right_n) {
			if(left[leftInt].compareTo(right[rightInt]) < 0) {
				array[arrayInt++] = left[leftInt++];
				comparisons++;
			} else {
				array[arrayInt++] = right[rightInt++];
				comparisons++;
			}//end if
		}//end while
		while(leftInt < left_n) {
			array[arrayInt++] = left[leftInt++];
		}//end while
		while(rightInt < right_n) {
			array[arrayInt++] = right[rightInt++];
		}//end while
		if(left_n != 0 && right_n != 0) {
			merge(left, right, array, left_n, right_n);
		}
	}//end merge
}//end class MergeSort
