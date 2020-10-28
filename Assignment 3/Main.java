import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Initialize Classes
		MergeSort mergeSort = new MergeSort();
		BinarySearch binarySearch = new BinarySearch();
		LinearSearch linearSearch = new LinearSearch();
		Hashing hashing = new Hashing();
		LinkedList linkedList = new LinkedList();
		Random random = new Random();
		
		//Initialize scanner to scan through magicitems.txt file
		Scanner input = new Scanner(new File("src/magicitems.txt"));
		
		final int arrSize = 666;
		
		//Initialize array to hold the magicitems
		String[] magicitemsList = new String[arrSize];
		
		//Add each item in magicitems to the array
		for(int i = 0; input.hasNextLine(); i++) {
			String item = input.nextLine().toUpperCase();
			magicitemsList[i] = item; //add next line to array
			//System.out.println(item);
		}//end for i
		
		//Sort items in the magicitemsList using Merge Sort
		mergeSort.mergeSort(magicitemsList);
		
		int start = 0;
		int stop = magicitemsList.length;
		String target = "";
		String[] targetList = new String[42];
		
		int linearAvgComparisons = 0;
		int binaryAvgComparisons = 0;
		
		//LINEAR & BINARY SEARCH//
		for(int i = 0; i < targetList.length; i++) {
			linearSearch.comparisons = 0;
			binarySearch.comparisons = 0;
			int randInt = random.nextInt(magicitemsList.length);
			//Search for items in the array
			target = magicitemsList[randInt];
			targetList[i] = target;
			System.out.println("Item " + (i+1) + ":");
			linearSearch.search(magicitemsList, target);
			binarySearch.search(magicitemsList, start, stop, target);
			//Linear Search number of comparisons
			System.out.println("Linear Search: Number of Comparisons = " + linearSearch.comparisons);
			//Binary Search number of comparisons
			System.out.println("Binary Search: Number of Comparisons = " + binarySearch.comparisons);
			linearAvgComparisons += linearSearch.comparisons;
			binaryAvgComparisons += binarySearch.comparisons;
		}//end for i
		
		//Compute Average
		linearAvgComparisons /= 42;
		binaryAvgComparisons /= 42;
		
		//Linear Search average number of comparisons
		System.out.println("\nLinear Search: Average Number of Comparisons = " + linearAvgComparisons);
		//Binary Search average number of comparisons
		System.out.println("Binary Search: Average Number of Comparisons = " + binaryAvgComparisons + "\n");
		
		//Initialize Hash Table Array
		int HASH_TABLE_SIZE = 250;
		int key = 0;
		int getAvgComparisons = 0;
		
		String[] hashTableArr = new String[HASH_TABLE_SIZE];
		for(int x = 0; x < hashTableArr.length; x++) {
			hashTableArr[x] = null;
		}//end for y
		
		//HASH TABLE//
		for(int h = 0; h < targetList.length; h++) {
			hashing.comparisons = 1;
			target = targetList[h];
			//MAKE HASH CODE
			key = hashing.makeHashCode(target);
			//Insert element into chained hash
			hashing.put(hashTableArr, key, target);
			
			//PRINT OUT HASHTABLE//
			System.out.println("Item " + (h+1) + ":");
			System.out.print(hashTableArr[key] + " | ");
			System.out.println("Hash Table Index: " + key );
			//Search for element in chained hash and print comparisons
			hashing.get(hashTableArr, key, target);
			System.out.println("Hashing get: Number of Comparisons = " + hashing.comparisons);
			getAvgComparisons += hashing.comparisons;
		}//end for x
		
		getAvgComparisons /= 42;
		Math.ceil(getAvgComparisons);
		
		System.out.println("\nHashing get(): Average Number of Comparisons = " + getAvgComparisons);
	}//end main
}//end Main Class
