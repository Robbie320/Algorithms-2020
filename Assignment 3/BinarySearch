import java.util.Random;

public class BinarySearch {
	public static int comparisons = 0;
	public static int binarySearch(String array[]) {
		/*BinarySearch(A, start, stop, target)
		* 	midPoint = int((start + stop)/2) // round, ceil, floor?
		* 	if(start > stop)
		* 		return = false
		* 	else if(target == A[midPoint])
		* 		return true
		* 	else if(target < A[midPoint])
		* 		BinarySearch(A, start, midPoint - 1, target)
		* 	else //target > A[midPoint] or not there at all
		* 		BinarySearch(A, midPoint + 1, stop, target)
		* 	end if
		*end BinarySearch */
		
		//System.out.print("Binary Search: Average Number of Comparisons = ");
		int avgComparisons = comparisons/42;
		
		return avgComparisons;
	}//end binarySearch
	public static boolean search(String[] array, int start, int stop, String target) {
		int midPoint = (start + stop)/2; //round, ceil, floor?
		if(start > stop) {
			return false;
		} else if(target.equals(array[midPoint])) {
			System.out.print(target);
			System.out.println(" | Index in Sorted List: " + midPoint);
			return true;
		} else if(target.compareTo(array[midPoint]) < 0) {
			comparisons++;
			search(array, start, midPoint - 1, target);
		} else { //target > A[midPoint] or not there at all
			comparisons++;
			search(array, midPoint + 1, stop, target);
		}//end if
		return true;
	}//end search
}//end class BinarySearch
