public class InsertionSort {
	public int insertionSort(String[] array) {
		/*Insertion-Sort(A)
		 * 	for j = 2 to A.length
		 *  		key = A[j]
		 * 	 	//insert A[j] into the sorted sequence A[1..j-1]
		 * 	 	i = j - 1
		 * 	 	while i > 0 and A[i] > key
		 * 			A[i + 1] = A[i]
		 * 			i = i - 1
		 * 		A[i + 1] = key */
		int comparisons = 0;
		int n = array.length;
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					comparisons++;
				}//end if
			}//end for j
		} //end for i
		
		//print out array to check
		/*for(int x = 0; x < n; x++) {
			System.out.println(array[x]);
		}*/ //end for x
		//System.out.println();
		//number of comparisons done during sort
		System.out.println("Insertion Sort Comparisons:");
		return comparisons;
	}//end insertionSort
}//end class InsertionSort
