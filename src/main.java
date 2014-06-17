import java.util.Random;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyEntry[] myArray = randomArray(6);
		
		// Testing of the BinaryTree
		BinaryTree binaryTree = new BinaryTree(myArray);
		System.out.println("Binary tree with " + binaryTree.size() + " nodes and has a height of " + binaryTree.height());
		binaryTree.printTree();
		System.out.println();
		
		System.out.println("The root is (" + binaryTree.root().getKey() + "," + binaryTree.root().getValue() + ")");
		
		myArray = randomArray(100);
		binaryTree = new BinaryTree(myArray);
		System.out.println("Binary tree with " + binaryTree.size() + " nodes and has a height of " + binaryTree.height());
		binaryTree.printTree();
		System.out.println();
		
		System.out.println("Inserted (50,R)");
		binaryTree.insert(new MyEntry(50,'R'));
		System.out.println("Binary tree with " + binaryTree.size() + " nodes and has a height of " + binaryTree.height());
		binaryTree.printTree();
		binaryTree.insert(new MyEntry(50,'R'));
		System.out.println();
		
		
		
		FlexHeap heap = new FlexHeap(randomArray(20));
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		
		System.out.println();
		
		MyEntry temp = heap.remove();
		System.out.println("The entry (" + temp.getKey() + "," + temp.getValue() + ") has been removed from the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		System.out.println();
		
	    temp = heap.remove();
		System.out.println("The entry (" + temp.getKey() + "," + temp.getValue() + ") has been removed from the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		System.out.println();
		
	    temp = heap.remove();
		System.out.println("The entry (" + temp.getKey() + "," + temp.getValue() + ") has been removed from the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		
		heap.toggleHeap();
		System.out.println("The heap has been toggled");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		
		System.out.println();
		heap.heapInsert(new MyEntry(1,'Z'));
		System.out.println("Entry (1,'Z') has been inserted into the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		System.out.println();
		
		
		heap.toggleHeap();
		System.out.println("The heap has been toggled");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		
		System.out.println();
		heap.heapInsert(new MyEntry(50,'T'));
		System.out.println("Entry (50,'T') has been inserted into the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		System.out.println();
		
		System.out.println();
		heap.heapInsert(new MyEntry(99,'A'));
		System.out.println("Entry (99,'A') has been inserted into the heap");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
		System.out.println();
		
		
		System.out.println("Build heap by inserting one entry at a time");
		heap = new FlexHeap();
		heap.printTree();
		Random randomGenerator = new Random();
		for (int i = 0; i < 10; i++)
		{
			temp = new MyEntry(randomGenerator.nextInt(100),(char)(randomGenerator.nextInt(25) + 65));
			System.out.println("Entry (" + temp.getKey() + "," + temp.getValue() + ") has been inserted into the heap");
			heap.heapInsert(temp);
			heap.printTree();
			System.out.println();
		}
		
		heap.toggleHeap();
		System.out.println("The heap has been toggled");
		System.out.println("Heap in mode: " + heap.heapMode + " and has " + heap.size() + " nodes and has a height of " + binaryTree.height());
		heap.printTree();
	}
	static MyEntry[] randomArray(int size)
	{
		MyEntry[] myArray = new MyEntry[size];
		Random randomGenerator = new Random();
		for( int i = 0; i < size; i++)
		{
			myArray[i] = new MyEntry(randomGenerator.nextInt(100),(char)(randomGenerator.nextInt(25) + 65));
		}
		return myArray;
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                        