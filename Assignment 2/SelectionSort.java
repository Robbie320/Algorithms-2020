public class SelectionSort {
	public int selectionSort(String[] array) {
		int comparisons = 0;
		int n = array.length;
		
		//Go through each item in the string array to compare
		for (int i = 0; i < n; i++) {
			//set min index
			int smallPos = i;
			//set min string based off of min index
			String smallString = array[i];
			//Compare minString to the next item in the array
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(smallString) < 0) {
					smallPos = j;
					smallString = array[j];
					comparisons++;
				}//end if
			}//end for x
			if (smallPos != i) {
				String temp = array[smallPos];
				array[smallPos] = array[i];
				array[i] = temp;
			}//end if
		}//end for i
		
		//print out array to check
		/*for(int x = 0; x < n; x++) {
			System.out.println(array[x]);
		}*/ //end for x
		//System.out.println();
		//number of comparisons done during sort
		System.out.println("Selection Sort Comparisons:");
		return comparisons;
	}//end selectionSort
}//end class SelectionSort
