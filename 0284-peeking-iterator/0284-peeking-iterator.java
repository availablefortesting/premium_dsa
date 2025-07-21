// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;

	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.hasPeeked = false;
        this.peekedElement = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasPeeked) {
            this.peekedElement = this.next();
            this.hasPeeked = true;
        }
        return this.peekedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!hasPeeked) 
            return iterator.next();
        
        Integer ele = this.peekedElement;
        this.peekedElement = null;
        this.hasPeeked = false;
        return ele;
	}
	
	@Override
	public boolean hasNext() {
	    return hasPeeked || this.iterator.hasNext();
	}
}