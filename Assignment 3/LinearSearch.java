public class LinearSearch {
	public static int comparisons = 0;
	public static int linearSearch(String array[]) {
		
		//System.out.print("Linear Search: Average Number of Comparisons = ");
		int avgComparisons = comparisons/42;
		return avgComparisons;
	}//end linearSearch
	public static boolean search(String array[], String item) {
		int n = array.length;
		for(int i = 0; i < n; i++) {
			if(array[i].equals(item)) {
				comparisons--;
				return true;
			}//end if
			comparisons++;
		}//end for i
		return false;
	}//end search
}//end class LinearSearch
