import java.util.Map;


public class BinaryTree implements BinaryTreeInterface {

	protected  MyEntry[] binaryTreeArray;
	private int maxSize = 1;
	private int size = 0;
	

	
	@SuppressWarnings("unchecked")
	public BinaryTree(MyEntry[] binaryTreeArray)
	{
		this.maxSize = binaryTreeArray.length;
		size = maxSize;
		this.binaryTreeArray = binaryTreeArray;
		
	}
	public BinaryTree()
	{
		this.maxSize = 10;
		size = 0;
		this.binaryTreeArray = new MyEntry[maxSize];
	}
	public int size() {
		return size;
	}
	public MyEntry remove(int i)
	{
		size--;
		return replace(binaryTreeArray[size], i);
	}
	public boolean isEmpty() {
		return ( size == 0);
	}


	@SuppressWarnings("unchecked")
	public void insert(MyEntry entry)
	{
		if ( maxSize == size) // Check if the array is full
		{
			maxSize *= 2;
			MyEntry[] newBinaryTreeArray = new MyEntry[maxSize];
			for ( int i = 0; i < size; i++ ) // copy the array into a new one double the size
				newBinaryTreeArray[i] = binaryTreeArray[i];
			binaryTreeArray = newBinaryTreeArray;
		}
		binaryTreeArray[size++] = entry;
	}

	public MyEntry root() {
		return binaryTreeArray[0];
	}


	public MyEntry parent(int i) {
		if ( i > 0)
		{
			if ( i == 1)
				return binaryTreeArray[0];
			else
				return binaryTreeArray[(int)Math.ceil(i/2.0 - 1.0)];
			
		}
		else 
			return null;
	}
	
	public MyEntry replace(MyEntry entry, int i) {
		MyEntry returnEntry = binaryTreeArray[i];
		binaryTreeArray[i] = entry;
		return returnEntry;
	}

	@Override
	public MyEntry left(int i) {
		if ( hasLeft(i) )
			return binaryTreeArray[i*2+1];
		else
			return null;
	}

	@Override
	public MyEntry right(int i) {
		if ( hasRight(i) )
			return binaryTreeArray[i*2+2];
		else
			return null;
	}

	@Override
	public boolean hasLeft(int i) {
		return ( size > i * 2 + 1 && binaryTreeArray[i*2+1] != null);		
	}

	@Override
	public boolean hasRight(int i) {
		return( size > i * 2 + 2 && binaryTreeArray[i*2+2] != null);
	}

	@Override
	public boolean isInternal(int i) {
		return (hasLeft(i) && hasRight(i));

	}
	public void swap(int index1, int index2)
	{
		MyEntry temp = binaryTreeArray[index1];
		binaryTreeArray[index1] = binaryTreeArray[index2];
		binaryTreeArray[index2] = temp;
	}
	@Override
	public boolean isExternal(int i) {
		return !isInternal(i);
	}

	@Override
	public boolean isRoot(int i) {
		return ( i == 0);
	}
	public int height()
	{
		return (int) (Math.log(size)/Math.log(2));
	}
	
	public void printTree()
	{
		int lastEntryInRow = 0;
		int currentHeight = 0;
		String temp = "";
		int j;
		for ( j = 0; j <= size -1; j++)
		{
			temp = temp + "(" + binaryTreeArray[j].getKey() + "," + binaryTreeArray[j].getValue() + ") ";
			if ( j == lastEntryInRow || j == size -1)
			{ 
				currentHeight++;
				lastEntryInRow = (int) Math.pow(2, currentHeight + 1) - 2;
			System.out.println(temp);
			temp = "";
			}
		}			
	}

}
