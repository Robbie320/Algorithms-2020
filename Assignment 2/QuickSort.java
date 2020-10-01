import java.util.ArrayList;
import java.util.Random;
public class QuickSort {
	public static int comparisons = 0;
	public int quickSort(String[] array) {
		/*QuickSort(A,p,r)
		* 	if p < r
		* 		q = Partition(A, p , r)
		* 		QuickSort(A, p, q - 1)
		* 		QuickSort(A, q + 1, r)
		* Partition(A, p, r)
		* 	x = A[r]
		* 	i = p - 1
		* 	for j = p to r - 1
		* 		if A[j] <= x
		* 			i = i + 1
		* 			exchange A[i] with A[j]
		* 	exchange A[i + 1] with A[r]
		* 	return i + 1 */
		int n = array.length;
		
		this.sort(array, 0, n - 1);
		
		//print out array to check
		/*for(int x = 0; x < n; x++) {
			System.out.println(array[x]);
		} //end for x
		System.out.println();*/
		//number of comparisons done during sort
		System.out.println("Quick Sort Comparisons:");
		return comparisons;
	}//end quickSort
	public static void sort(String array[], int begin, int n) {
		if(begin < n) {
			int q = partition(array, begin, n);
			
			sort(array, begin, q - 1);
			sort(array, q + 1, n);
		}//end if
	} //end divide
	public static int partition(String array[], int begin, int n) {
		//Select Pivot Randomly
		Random random = new Random();
		//generate three random values
		int a = random.nextInt(n);
		int b = random.nextInt(n);
		int c = random.nextInt(n);
		
		//Select three random pivot points
		String pivot1 = array[a];
		String pivot2 = array[b];
		String pivot3 = array[c];
		String medPivot = "";
		
		//Select a median pivot to actually pivot around
		/*if((b < a && a < c)
				 || (c < a && a < b)) { //Check pivot1
			medPivot = pivot1;
		} else if((a < b && b < c)
				 || (c < b && b < a)) { //Check pivot2
			medPivot = pivot2;
		} else {
			medPivot = pivot3;
		}*/
		
		/*if((pivot2.compareTo(pivot1) < 0 && pivot1.compareTo(pivot3) < 0)
				 || (pivot3.compareTo(pivot1) < 0 && pivot1.compareTo(pivot2) < 0)) { //Check pivot1
			medPivot = pivot1;
		} else if((pivot1.compareTo(pivot2) < 0 && pivot2.compareTo(pivot3) < 0)
				 || (pivot3.compareTo(pivot2) < 0 && pivot2.compareTo(pivot1) < 0)) { //Check pivot2
			medPivot = pivot2;
		} else {
			medPivot = pivot3;
		}*/
		
		/*String temp1 = medPivot;
		medPivot = array[n];
		array[n] = temp1;*/
		
		medPivot = array[n];
		
		int i = (begin - 1);
		for(int j = begin; j < n; j++) {
			if(array[j].compareTo(medPivot) < 0) {
				i++;
				String temp2 = array[i];
				array[i] = array[j];
				array[j] = temp2;
				comparisons++;
			}//end if
		}//end for j
		String temp3 = array[i+1];
		array[i+1] = array[n];
		array[n] = temp3;
		
		return i + 1;
	}//end partition
}//end class QuickSort
