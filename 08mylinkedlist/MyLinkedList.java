import java.util.*;

public class MyLinkedList<T>{

    private class LNode{
	//instance variables
	private T value;
	private LNode next;
	
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

    //instance Variables
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

    public T remove(int index){
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
	return oldInt;
	
    }

    public T get(int index){
	LNode current = head;
	int ctr = 0;
	while(ctr < index){
	    current = current.getNext();
	    ctr++;
	}
	return current.getValue();
    }

    public T set(int index, T newValue){
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
}
