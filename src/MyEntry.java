import java.util.Map;


	final class MyEntry {
	    private final int key;
	    private char value;

	    public MyEntry(int key, char value) {
	        this.key = key;
	        this.value = value;
	    }

	    public int getKey() {
	        return key;
	    }

	    public char getValue() {
	        return value;
	    }

	    public char setValue(char value) {
	    	char old = this.value;
	        this.value = value;
	        return old;
	    }
	}
