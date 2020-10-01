import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Initialize Selection, Insertion, Merge, and Quick Sorts
		SelectionSort selectionSort = new SelectionSort();
		InsertionSort insertionSort = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		QuickSort quickSort = new QuickSort();
		
		//Initialize scanner to scan through magicitems.txt file
		Scanner input = new Scanner(new File("src/magicitems.txt"));
		
		final int arrSize = 666;
		
		//Initialize array to hold the magicitems
		String[] magicitemsSelection = new String[arrSize];
		String[] magicitemsInsertion = new String[arrSize];
		String[] magicitemsMerge = new String[arrSize];
		String[] magicitemsQuick = new String[arrSize];
		
		//Add each item in magicitems to the array
		for(int i = 0; input.hasNextLine(); i++) {
			String item = input.nextLine().toUpperCase();
			magicitemsSelection[i] = item; //add next line to array
			magicitemsInsertion[i] = item;
			magicitemsMerge[i] = item;
			magicitemsQuick[i] = item;
			//System.out.println(item);
		}//end for i
		System.out.println(selectionSort.selectionSort(magicitemsSelection));
		System.out.println(insertionSort.insertionSort(magicitemsInsertion));
		System.out.println(mergeSort.mergeSort(magicitemsMerge));
		System.out.println(quickSort.quickSort(magicitemsQuick));
	}//end main
}//end Main Class
