public class SelectionSort {
	public Node selectionSort(Node nodeHead) {
		Node n, bigNode;
		Node temp;
		int bigUnitPrice;
		n = nodeHead;
		
		//Go through each item in the list
		//while b is not the last node
		while(n.next != null) {
			//set max node
			bigNode = n;
			//set max unit price
			bigUnitPrice = n.unit_price;
			//compare min unit price to next nodes unit price
			while(n.next != null) {
				if(n.next.unit_price > bigUnitPrice) {
					//bigNode = n.next;
					bigUnitPrice = n.next.unit_price;
				}//end if
				n = n.next;
			}//end while
			if(bigNode != n) {
				temp = bigNode;
				bigNode = n.next;
				n = temp;
			}//end if
			n = n.next;
		}//end while
		return n;
	}//end selectionSort
	public void printLinkedList(LinkedList spiceLinkedList) {
		Node n;
		n = spiceLinkedList.head;
		
	}
}//end class SelectionSort
