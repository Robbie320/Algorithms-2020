public class BinarySearchTree {
	public int comparisons = 0;
	public Node root = null;
	public Node treeSearch(Node node, String key) {
		/*TreeSearch(T,k)
		* 	if(T == null or T.key == k)
		* 		return T //return a pointer to the node where we found the key. Could be NULL
		* 	else
		* 		if(K < T.key)
		* 			return TreeSearch(T.leftChild, k) //continue looking down the LEFT subtree
		* 		else
		* 			return TreeSearch(T.rightChild, k) //continue looking down the LEFT subtree */
		
		if(node == null || node.key.equals(key)) {
			return node;
		} else {
			if(key.compareTo(node.key) < 0) {
				comparisons++;
				return treeSearch(node.leftChild, key);
			} else {
				comparisons++;
				return treeSearch(node.rightChild, key);
			}//end if
		}//end if
	}//end treeSearch
	public void treeInsert(String key) {
		/*TreeInsert(T,z)
		* 	y = null //training pointer
		* 	x = T.root
		* 	while(x != null)
		* 		y = x
		* 		if(z.key < x.key)
		* 			x = x.left
		* 		else
		* 			x = x.right
		* 	z.parent = y
		* 	if(y == null)
		* 		T.root = z //?
		* 	else
		* 		if(z.key < y.key)
		* 			x.left = z
		* 		else
		* 			x.right = z */
		
		//Make new Node
		Node newNode = new Node();
		newNode.key = key;
		
		Node trailingPointer = null;
		Node currentNode = this.root;
		
		
		while (currentNode != null) {
			trailingPointer = currentNode;
			if (newNode.key.compareTo(currentNode.key) < 0) {
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
			}//end if
		}//end while
		newNode.parent = trailingPointer;
		if(trailingPointer == null) {
			this.root = newNode;
		} else {
			currentNode = trailingPointer;
			if(newNode.key.compareTo(trailingPointer.key) < 0) {
				currentNode.leftChild = newNode;
			} else {
				currentNode.rightChild = newNode;
			}//end if
		}//end if
	}//end treeInsert
}//end class BinarySearchTree
