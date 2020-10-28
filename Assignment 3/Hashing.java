import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Hashing {
	public Node head;
	public static int comparisons = 1;
	private static final int HASH_TABLE_SIZE = 250;

	public static int makeHashCode(String str) {
		str = str.toUpperCase();
		int length = str.length();
		int letterTotal = 0;
		
		// Iterate over all letters in the string, totalling their ASCII values.
		for (int i = 0; i < length; i++) {
			char thisLetter = str.charAt(i);
			int thisValue = (int)thisLetter;
			letterTotal = letterTotal + thisValue;

			// Test: print the char and the hash.
			/*
			System.out.print(" [");
			System.out.print(thisLetter);
			System.out.print(thisValue);
			System.out.print("] ");
			// */
		}//end for i

		// Scale letterTotal to fit in HASH_TABLE_SIZE.
		int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
		// TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.

		return hashCode;
	}//end makeHashCode
	// chainedHashInsert()
	public void put(String table[], int key, String value) {
		/*CHAINED-HASH-INSERT(T,x)
		* 	insert x at the head of list T[(x,key)] */
		Node n = new Node();
		n.item = value;
		
		if(table[key] == null) {
			table[key] = value;
			this.head = n;
		} else {
			this.head.next = n;
		}
	}//end put
	// chainedHashSearch
	public int get(String table[], int key, String value) {
		/*CHAINED-HASH-SEARCH(T,k)
		* 	search for an element with key k in list T[h(k)] */
		
		int temp = makeHashCode(value);
		
		while(this.head != null && !table[key].equals(value)) {
			if(this.head.item == value) {
				break;
			} else {
				comparisons++;
				this.head = this.head.next;
			}
		}
		//System.out.print("Hashing get(): Average Number of Comparisons: ");
		int avgComparisons = comparisons/42;
		
		return avgComparisons;
	}//end get
	// chainedHashDelete
	public void delete(String[] table, int key, String value) {
		/*CHAINED-HASH-DELETE(T,x)
		* 	delete x from the list T[h(x,key)] */
		Node start = new Node();
		start.item = table[key];
		Node end = new Node();
		end = start;
		
		if(start.item == value /*this.head.prev != null*/) {
			table[key] = start.next.item;
			//this.head.prev.next = this.head.next;
		/*} else {
			this.head = this.head.next;*/
		}//end if
		while(end.next != null && end.next.item != value) {
			end = end.next;
		}//end while
		if(end.next == null/*this.head.next != null*/) {
			System.out.println("\nERROR: Item " + value + " Not Found | Not able to delete.\n");
			//this.head.next.prev = this.head.prev;
		}//end if
		if(end.next.next == null) {
			end.next = null;
		}//end if
		end.next = end.next.next;
		table[key] = start.item;
	}//end delete
}//end class Hashing
