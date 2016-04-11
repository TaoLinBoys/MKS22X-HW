import java.util.*;
import java.lang.*;

public class MyLinkedList<T> implements Iterable<T>{

    //Iterator Iterable stuff
    public Iterator<T> iterator(){
	return new MLLIterator();  
    }

    private class MLLIterator implements Iterator<T>{
	private LNode temp;
	public MLLIterator(){
	    temp = head;
	}
	public boolean hasNext(){
	    return temp!=null;
	}
	public T next(){
	    T oldValue = temp.getValue();
	    temp = temp.getNext();
	    return oldValue;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    //LNode innerclass
    private class LNode{
	//instance variables
	private T value;
	private LNode next;
	private LNode prev;
	
	public LNode(T v){
	    value = v;
	}

	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(T v){
	    value = v;
	}
	public void setNext(LNode n){
	    next = n;
	}
    }

    //instance variables
    LNode head;
    LNode end;
    int size;
    
    //methods
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    end = head;
	}else{
	    end.setNext(new LNode(value));
	    end = end.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int index, T value){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	if(index == 0){
	    LNode newhead = new LNode(value);
	    newhead.setNext(head);
	    head = newhead;
	    size++;
	    return true;
	}

	if(index == size){
	    return add(value);
	}else{
	    LNode newNode = new LNode(value);
	    LNode current = head;
	    int ctr = 0;
	    while(ctr < index - 1){
		current = current.getNext();
		ctr++;
	    }
	    LNode nextone = current.getNext();
	    current.setNext(newNode);
	    newNode.setNext(nextone);
	    size++;
	    return true;
	}
    }

    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0){
	    T oldInt = head.getValue();
	    head = head.getNext();
	    size--;
	    return oldInt;
	}
	if (index == size-1){
	    LNode current = head;
	    for(int ctr = 0; ctr < index - 1; ctr++){
		current = current.getNext();
	    }
	    T oldInt = current.getNext().getValue();
	    current.setNext(null);
	    end = current;
	    size--;
	    return oldInt;
	    
	}
	LNode current = head;
	int ctr = 0;
	while(ctr < index - 1){
	    current = current.getNext();
	    ctr++;
	}

	
	LNode skip = current.getNext();
	T oldInt = skip.getValue();
	skip = skip.getNext();
	current.setNext(skip);
	size--;
	return oldInt;
	
    }

    public T get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int ctr = 0;
	while(ctr < index){
	    current = current.getNext();
	    ctr++;
	}
	return current.getValue();
    }

    public T set(int index, T newValue){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int ctr = 0;
	while(ctr < index){
	    current = current.getNext();
	    ctr++;
	}
	T old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    public int indexOf(T value){
	LNode current = head;
	int ctr = 0;
	while(ctr < size){
	    if(current.getValue() == value){
		return ctr;
	    }else{
		ctr++;
		current = current.getNext();
	    }
	}
	return -1;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }

    //debugging toString
    public String toString(boolean anything){
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]" + " head: "+head.getValue() + " tail: "+end.getValue();
    }
}
