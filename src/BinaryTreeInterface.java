
public interface BinaryTreeInterface {
	public int size();
	public boolean isEmpty();
	public MyEntry replace(MyEntry entry, int i);
	public MyEntry root();
	public MyEntry parent(int i);
	public MyEntry left(int i); 
	public MyEntry right(int i);
	public boolean hasLeft(int i);
	public boolean hasRight(int i);
	public boolean isInternal(int i);
	public boolean isExternal(int i);
	public boolean isRoot(int i);
	
}
