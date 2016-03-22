public class MyLinkedList{

    private class LNode{
	//instance variables
	int value;
	LNode next;
	
	public LNode(int v){
	    value = v;
	}

	public int getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(int v){
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
    public boolean add(int value){
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

    public boolean add(int index, int value){
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

    public int remove(int index){
	LNode current = head;
	int ctr = 0;
	while(ctr < index - 1){
	    current = current.getNext();
	    ctr++;
	}
	
	LNode skip = current.getNext();
	int oldInt = skip.getValue();
	skip = skip.getNext();
	current.setNext(skip);
	return oldInt;
	
    }

    public int get(int index){
	LNode current = head;
	int ctr = 0;
	while(ctr < index){
	    current = current.getNext();
	    ctr++;
	}
	return current.getValue();
    }

    public int set(int index, int newValue){
	LNode current = head;
	int ctr = 0;
	while(ctr < index){
	    current = current.getNext();
	    ctr++;
	}
	int old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    public int indexOf(int value){
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
