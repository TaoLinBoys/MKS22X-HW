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
    int size;
    
    //methods
    public boolean add(int value){
	if(head == null){
	    head = new LNode(value);
	}else{
	    LNode p = head;			
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode(value));
	}
	size+=1;
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
	return true;
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

    public int size(){
	LNode current = head;
	int size = 0;
	while(current != null){
	    size++;
	    current = current.getNext();
	}
	return size;
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
   
    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	for(int i = 0; i < 10; i++){
	    int rand = (int)(Math.random()*100) - 20;
	    test.add(rand);
	}
	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.get(1));
	System.out.println(test.set(5,420));
	System.out.println(test);
        test.add(3,420);
	System.out.println(test);
    }
}
