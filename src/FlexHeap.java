
public class FlexHeap extends BinaryTree {

	public String heapMode = "maxHeap";
	
	
	public FlexHeap(MyEntry[] binaryTreeArray) {
		super(binaryTreeArray);
		bottomUpHeapConstruction();
	}
	public FlexHeap() {
		super();
	}
	public void switchMinHeap()
	{
		heapMode = "minHeap";
		bottomUpHeapConstruction();
	}
	public void switchMaxHeap()
	{
		heapMode = "maxHeap";
		bottomUpHeapConstruction();
	}
	public void toggleHeap()
	{
		if ( heapMode.equals("minHeap"))
			heapMode = "maxHeap";
		else
			heapMode = "minHeap";
		bottomUpHeapConstruction();
	}
	public MyEntry remove()
	{
		MyEntry temp = this.remove(0);
		downHeap(0);
		return temp;
	}
	public void bottomUpHeapConstruction()
	{
		int currentHeight = height() - 1; // Get the height one above the max height
		while (currentHeight >= 0) // Loop until we are at root
		{
			int startIndex = (int)(Math.pow(2, currentHeight) -1); // Determines where to start and end in the array
			int endIndex = (int)(Math.pow(2, currentHeight + 1) -2);
			
			for ( int i = startIndex; i <= endIndex; i++) // Loop through each node and restore the heap order
				downHeap(i); 
			currentHeight--;
			
		}	
	}
	public void downHeap(int index)
	{

		if ((heapMode == "minHeap" && this.hasRight(index) && this.binaryTreeArray[index].getKey() > this.right(index).getKey() && this.right(index).getKey() < this.left(index).getKey() )
			|| (heapMode == "maxHeap" && this.hasRight(index) && this.binaryTreeArray[index].getKey() < this.right(index).getKey() && this.right(index).getKey() > this.left(index).getKey()))
		{
			this.swap(index, index*2 + 2);
			downHeap(index*2+2);
		}
		else if ((heapMode =="minHeap" && this.hasLeft(index) && this.binaryTreeArray[index].getKey() > this.left(index).getKey()
				|| ( heapMode =="maxHeap" && this.hasLeft(index) && this.binaryTreeArray[index].getKey() < this.left(index).getKey())) )
		{
			this.swap(index, index*2 + 1);
			downHeap(index*2+1);
		}
		
	}
	public void upHeap(int index)
	{
		while (this.parent(index) != null)
		{
			if ((heapMode == "minHeap" && this.binaryTreeArray[index].getKey() < this.parent(index).getKey() ) || (heapMode == "maxHeap" && this.binaryTreeArray[index].getKey() > this.parent(index).getKey()))
			{
				int temp = (int)Math.ceil(index/2.0 - 1.0);
				swap(index, temp);
				index = temp;
			}
			else
				break;
		}
	}
	public void heapInsert(MyEntry entry)
	{
		insert(entry);
		upHeap(size() - 1);
	}
	

}
